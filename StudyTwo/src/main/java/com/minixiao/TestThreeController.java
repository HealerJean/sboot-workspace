package com.minixiao;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HealerJean on 2017/3/19.
 */
@Controller //这个类要是想通过web的方式访问就要加一个 注解 @RestController
public class TestThreeController {
    /**
     *  1.测试Helloworld
     * @return
     */
    //请求的方式的GET
    @RequestMapping(value = "/testthreecontroller" ,method = RequestMethod.GET)
    public String say(){
        return "hello spring boot";
    }

}
