package com.studybook.Excel;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;


/**
 * Created by wei on 2017/3/23.
 */
public interface CompanyInfoRepository extends CrudRepository<CompanyInfo, String> {


    @Override
    List<CompanyInfo> findAll();



}
