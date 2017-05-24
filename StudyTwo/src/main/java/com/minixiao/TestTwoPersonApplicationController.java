package com.minixiao;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HealerJean on 2017/3/19.
 */
@RestController //这个类要是想通过web的方式访问就要加一个 注解 @RestController
public class TestTwoPersonApplicationController {

@Autowired    // 省略 get/setter 直接进行使用
private  TestTwoPersonBean testtwopersonBean;
    @RequestMapping(value = "/testtwopersonbean" ,method = RequestMethod.GET)
    public String TestApplication(){
        return testtwopersonBean.getName();
    }

}
