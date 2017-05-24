package com.studybook.ModelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * 地址栏输入 http://localhost:8080/test3?age=23&name=zhangyujin
 * Created by HealerJean on 2017/3/29.
 */
@Controller
public class TestMa3Controller {

    @RequestMapping("test3")
    public String testModelAttribute(@ModelAttribute("user") User user){
        System.out.println("修改："+user);
        return "ModelAttributeindex";
    }

}
