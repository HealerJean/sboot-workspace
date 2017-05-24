package com.studybook.Excel;

import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDate;
import java.time.LocalDateTime;

/**
 * Created by wei on 2017/3/23.
 * 公司信息表
 */
@Entity
@Table(name = "rec_info")
public class CompanyInfo {
    //编号，主键UUID
    @Id
    @GenericGenerator(name = "idGenerator", strategy = "uuid")
    @GeneratedValue(generator = "idGenerator")
    private String id;

    //公司名称
    private String name;


    //公司详细地址
    private String address;

    //联系邮箱 用于登录
    private String email;


    public CompanyInfo() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}