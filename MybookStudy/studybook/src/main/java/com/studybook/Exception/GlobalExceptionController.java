package com.studybook.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 测试全局异常的类，发送了全局异常
 * Created by HealerJean on 2017/3/29.
 */
@Controller
public class GlobalExceptionController {
    @RequestMapping("/globalException")
    public String error(){
        int i = 5/0;
        return "hello";
    }
}
