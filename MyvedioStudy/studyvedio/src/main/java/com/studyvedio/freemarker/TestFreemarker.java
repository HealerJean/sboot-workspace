package com.studyvedio.freemarker;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.Map;

/**
 * Created by HealerJean on 2017/3/30.
 */
@Controller
public class TestFreemarker {
    @RequestMapping(value = "/freemarker" ,method = RequestMethod.GET)
    public String returnJson(Model model){
    model.addAttribute("user","Healer123Jean");
        return "freemarker";
    }
}
