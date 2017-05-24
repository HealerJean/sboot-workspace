package com.studyvedio.index;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * Created by HealerJean on 2017/3/30.
 */
@Controller
public class indexController {
    @RequestMapping(value = "/index" ,method = RequestMethod.GET)
    public String index(){

        return "index";
    }
}
