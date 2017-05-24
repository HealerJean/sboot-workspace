package com.studybook.Excel;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * Created by wei on 2017/3/23.
 */
@Service
@Transactional
public class CompanyInfoServiceImpl implements CompanyInfoService {
  @Autowired
  private CompanyInfoRepository companyInfoRepository;

  /**
   * 注册公司
   * @param companyInfo
   */
  @Override
  public CompanyInfo saveCompany(CompanyInfo companyInfo) {


     return companyInfoRepository.save(companyInfo);

  }



  @Override
  public List<CompanyInfo> findAll() {
    return companyInfoRepository.findAll();
  }
}
