package com.minixiao;

import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**  配置文件 3
 * Created by HealerJean on 2017/3/19.
 */
//把普通pojo实例化到spring容器中，相当于配置文件中的<bean id="" class="">
@Component
//识别配置文件的前缀prefix，可以通过一个注解ConfigurationProperties然后根据属性进行注入
@ConfigurationProperties(prefix = "person")
public class TestTwoPersonBean {
    private  String name;
    private  int age;
    public String getName(){
        return  this.name;
    }
    public void setName(String name){
        this.name= name;
    }

    public int getAge(){
        return  this.age;
    }
    public void setAge(int age){
        this.age= age;
    }
}
