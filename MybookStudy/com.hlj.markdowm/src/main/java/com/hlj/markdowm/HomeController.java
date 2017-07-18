package com.hlj.markdowm;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * @Description
 * @Author healerjean.
 * @Date 2017/6/19  下午4:22.
 */
@Controller
public class HomeController {

    @GetMapping({"/index.html","/"})
    public String index(){

        return "index";
    }
}
