package com.studybook.Exception;

import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.servlet.ModelAndView;

/**
 * 全局异常的处理
 * Created by HealerJean on 2017/3/29.
 */
@ControllerAdvice
public class GlobalException {
    @ExceptionHandler
    public ModelAndView exceptionHandler(Exception ex){
        ModelAndView mv = new ModelAndView("globalerror");
        mv.addObject("exception", ex);
        System.out.println("in testControllerAdvice");
        return mv;
    }
}
