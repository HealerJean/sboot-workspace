package com.studybook.Exception;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

/**
 * 局部异常的 测试和处理
 * Created by HealerJean on 2017/3/29.
 */
@Controller
public class LocalExceptionController {
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView mv = new ModelAndView("globalerror");
        mv.addObject("localexception", ex);
        System.out.println("in testExceptionHandler");
        return mv;
    }
    @RequestMapping("/localException")
    public String error(){
        int i = 5/0;
        return "hello";
    }

}
