package com.minixiao;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HealerJean on 2017/3/19.
 */
@RestController //这个类要是想通过web的方式访问就要加一个 注解 @RestController
public class HellowController {
    /**
     *  1.测试Helloworld
     * @return
     */
    //请求的方式的GET
    @RequestMapping(value = "/hello" ,method = RequestMethod.GET)
    public String say(){
        return "hello spring boot";
    }

}
