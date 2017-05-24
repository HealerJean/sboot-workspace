package com.studybook.Excel;


import javassist.bytecode.ByteArray;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFCell;
import org.apache.poi.xssf.usermodel.XSSFRow;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.io.FileSystemResource;
import org.springframework.core.io.InputStreamResource;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.util.ResourceUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.util.List;

/**
 * Created by HealerJean on 2017/4/12.
 */
@Controller
public class TestExcelEntityController {
    @Autowired
    private CompanyInfoService companyInfoService;

    Logger logger = LoggerFactory.getLogger(TestExcelEntityController.class);


    //从数据库中读取，进入d盘的并创建excel 文件
    @RequestMapping("/excel/dbtoexcel")
    @ResponseBody
    public String  getDbToExcel(){
        logger.info("excel");
        List<CompanyInfo> companyInfos =companyInfoService.findAll();
        try {
            XSSFWorkbook workbook=new XSSFWorkbook();
            XSSFSheet sheet=workbook.createSheet("countryDB");
            XSSFRow row = sheet.createRow((short)0);
            XSSFCell cell=null;
            cell=row.createCell((short)0);
            cell.setCellValue("id");
            cell=row.createCell((short)1);
            cell.setCellValue("address");
            cell=row.createCell((short)2);
            cell.setCellValue("email");
            cell=row.createCell((short)3);
            cell.setCellValue("recName");
            int i=1;
            for (CompanyInfo companyInfo:companyInfos){
                    logger.info(companyInfo.toString()+"*****************88");
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
            try {
                String outputFile="D:\\studyboot.xlsx";
                FileOutputStream FOut = new FileOutputStream(outputFile);
                workbook.write(FOut);
                FOut.flush();
                FOut.close();
                return  "ok";
            }catch (Exception e){
                e.printStackTrace();
            }

        } catch (Exception e) {
            e.printStackTrace();
        }
        return  null;
    }
    ////从数据库中读取，创建excel 文件 ,提供下载用
    @RequestMapping(value = "/excel/downloadexcel", method = RequestMethod.GET)
    public void downloadFile(HttpServletResponse response)
        throws IOException {
        List<CompanyInfo> companyInfos = companyInfoService.findAll();
        try {
            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("countryDB");
            XSSFRow row = sheet.createRow((short) 0);
            XSSFCell cell = null;
            cell = row.createCell((short) 0);
            cell.setCellValue("id");
            cell = row.createCell((short) 1);
            cell.setCellValue("address");
            cell = row.createCell((short) 2);
            cell.setCellValue("email");
            cell = row.createCell((short) 3);
            cell.setCellValue("recName");
            int i = 1;
            for (CompanyInfo companyInfo : companyInfos) {
                logger.info(companyInfo.toString() + "*****************88");
                row = sheet.createRow(i);
                cell = row.createCell(0);
                cell.setCellValue(companyInfo.getId());
                cell = row.createCell(1);
                cell.setCellValue(companyInfo.getAddress());
                cell = row.createCell(2);
                cell.setCellValue(companyInfo.getEmail());
                cell = row.createCell(3);
                cell.setCellValue(companyInfo.getName());
                i++;
            }


                try {
                    ByteArrayOutputStream os = new ByteArrayOutputStream();

                    workbook.write(os);
                    byte[] bytes = os.toByteArray();

                    response.setContentType("application/x-msdownload");
                    response.setHeader("Content-Disposition", "attachment;filename=xxx.xlsx");
                    response.setContentLength(bytes.length);
                    response.getOutputStream().write(bytes);
                    response.getOutputStream().flush();
                    response.getOutputStream().close();
                } catch (IOException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }




        } catch (Exception e) {
            e.printStackTrace();
        }

    }


}
