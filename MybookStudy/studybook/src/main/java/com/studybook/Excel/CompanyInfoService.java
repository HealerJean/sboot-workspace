package com.studybook.Excel;



import java.util.List;

/**
 * Created by wei on 2017/3/23.
 */
public interface CompanyInfoService {


  /**
   * 注册公司
   * @param companyInfo
   */
  CompanyInfo saveCompany(CompanyInfo companyInfo);


  List<CompanyInfo> findAll();





}
