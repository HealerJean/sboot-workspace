package com.studybook.Excel;


import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.springframework.util.ResourceUtils;

import java.io.*;
import java.util.*;

/**
 * Created by HealerJean on 2017/4/12.
 */
public class Test {
    public Test() throws FileNotFoundException {
    }
    //读取单个单元格

    public static void main(String[] args)throws Exception {
        Test test = new Test();
       test.testReadList();
      //  test.getDbToExcel();;
    }
    public  void getTitle(){
        //Excel文件
        HSSFWorkbook wb = null;
        try {
            wb = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("D:\\xxx.xlsx")));

            //Excel工作表
            HSSFSheet sheet = wb.getSheetAt(0);

            //表头那一行
            HSSFRow titleRow = sheet.getRow(0);

            //表头那个单元格
            HSSFCell titleCell = titleRow.getCell(0);

            String title = titleCell.getStringCellValue();

            System.out.println("标题是："+title);

        } catch (IOException e) {
            e.printStackTrace();
        }

    }


//读取Excel的内容
    public void testReadList() throws Exception {

        List<WebDto> list = new ArrayList<WebDto>();

    //    HSSFWorkbook book = new HSSFWorkbook(new FileInputStream(ResourceUtils.getFile("classpath:web-info.xls")));
        String outputFile="D:\\xxx.xlsx";
        File file = new File(outputFile);


        Workbook book=null;
        if((file.getName()).endsWith("xls".trim())){
            //2003
            book = new HSSFWorkbook(new FileInputStream(file));
        }else if((file.getName()).endsWith("xlsx".trim())){
            //2007
             book = new XSSFWorkbook(new FileInputStream(file));
        }else {
            System.out.println("文件格式不支持");
        }


        Sheet sheet = book.getSheetAt(0);

        for(int i=0; i<sheet.getLastRowNum()+1; i++) {
            Row row = sheet.getRow(i);
            String id = row.getCell(0).getStringCellValue(); //名称
            String description = row.getCell(1).getStringCellValue(); //url
            String currentdate =row.getCell(2).getStringCellValue();

            list.add(new WebDto(id, description, currentdate));
        }

        System.out.println("共有 " + list.size() + " 条数据：");
        for(WebDto wd : list) {
            System.out.println(wd);
        }
    }




  /* public void getDbToExcel(){

       CompanyInfoServiceImpl companyInfoService = new CompanyInfoServiceImpl();
       List<CompanyInfo>  companyInfos =companyInfoService.findAll();
            try {
                XSSFWorkbook workbook=new XSSFWorkbook();
                XSSFSheet sheet=workbook.createSheet("countryDB");
                XSSFRow row = sheet.createRow((short)0);
                XSSFCell cell=null;
                cell=row.createCell((short)0);
                cell.setCellValue("code");
                cell=row.createCell((short)1);
                cell.setCellValue("shortname");
                cell=row.createCell((short)2);
                cell.setCellValue("name");
                cell=row.createCell((short)3);
                cell.setCellValue("englishname");
                int i=1;
            for (CompanyInfo companyInfo:companyInfos){

                    row=sheet.createRow(i);
                    cell=row.createCell(0);
                    cell.setCellValue(companyInfo.getId());
                    cell=row.createCell(1);
                    cell.setCellValue(companyInfo.getAddress());
                    cell=row.createCell(2);
                    cell.setCellValue(companyInfo.getEmail());
                    cell=row.createCell(3);
                    cell.setCellValue(companyInfo.getName());
                    i++;
                }
                FileOutputStream FOut = new FileOutputStream(ResourceUtils.getFile("classpath:index.xls"));
                workbook.write(FOut);
                FOut.flush();
                FOut.close();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }*/

    //读取内容，进入map
    public  List<Map<String,Object>> getExcelContent(String filePath) {
        List<Map<String, Object>> list = new ArrayList<Map<String, Object>>();
        Workbook book = null;
        File file = new File(filePath);

        try {
            if ((file.getName()).endsWith("xls".trim())) {
                //2003
                book = new HSSFWorkbook(new FileInputStream(file));
            } else if ((file.getName()).endsWith("xlsx".trim())) {
                //2007
                book = new XSSFWorkbook(new FileInputStream(file));
            } else {
                System.out.println("文件格式不支持");
            }

            Sheet sheet = book.getSheetAt(0);
            //得到标题
            List<String> titles = new ArrayList<String>();
            //表头那一行
            Row titleRow = sheet.getRow(0);


     /*       //表头那个单元格
            Cell titleCell1 = titleRow.getCell(0);
            String title = titleCell1.getStringCellValue();
            System.out.println("标题是："+title);*/
            //表头那个单元格
/*
            System.out.println(titleRow.getLastCellNum()+1);
*/
            for (int i = 0; i < titleRow.getLastCellNum(); i++) {
                String titleCell = titleRow.getCell(i).getStringCellValue();
                titles.add(titleCell);
            }


            Row row = null;
            long rowNum = 0; //有效行数
            for (int j = 1; j < sheet.getLastRowNum() + 1; j++) {
                row = sheet.getRow(j);
                Map<String, Object> map = new HashMap<String, Object>();
                for (int i = 0; i < row.getLastCellNum(); i++) {
                    String strValue = row.getCell(i).getStringCellValue();
                    map.put(titles.get(i), strValue);
                }
                list.add(map);

            }
            return list;
        } catch (Exception e) {
            e.printStackTrace();
        }

        return  null;
    }
}
