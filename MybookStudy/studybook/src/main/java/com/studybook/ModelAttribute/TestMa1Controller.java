package com.studybook.ModelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * 首先会进入这个@ModelAttribute
 * ModelAttribute 没有参数 map保存，相当于model也是一样
 * Created by HealerJean on 2017/3/29.
 */
@Controller
public class TestMa1Controller {

    @ModelAttribute
    public void getUser(Map<String, Object> map){
        User user=new User( 23, "张宇晋");
        map.put("user", user);
    }
    @RequestMapping("test1")
    public String testModelAttribute(User user){
        System.out.println("修改："+user);
        return "ModelAttributeindex";
    }


}
