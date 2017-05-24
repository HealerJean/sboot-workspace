package com.studyvedio.ReturnJson;

import com.alibaba.fastjson.annotation.JSONField;

import java.util.Date;

/**
 * Created by HealerJean on 2017/3/30.
 */
public class User {
    int age;
    String name;
    //测试fastjson的时候用到
    //这个注释在在fastjson的包里面的 com.alibaba.fastjson.annotation.JSONField;
    @JSONField(format = "yyyyMMddhhmmss")
    Date createTime;
    public User() {
    }

    public int getAge() {
        return age;
    }

    public Date getCreateTime() {
        return createTime;
    }

    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
