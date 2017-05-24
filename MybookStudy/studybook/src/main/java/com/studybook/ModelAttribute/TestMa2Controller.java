package com.studybook.ModelAttribute;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Map;

/**
 * ModelAttribute 不管有没有user参数 都可以返回值 ，
 * 解释;这种方法其实也是放到了model里面
 * 注意：有了返回值 User才能生效，仅仅是void不能生效
 * Created by HealerJean on 2017/3/29.
 */
@Controller
public class TestMa2Controller {
    //这种不带参数也是可以的
    //@ModelAttribute
    @ModelAttribute("user")
    public User getUser(Map<String, Object> map){
        User user=new User( 23, "张宇晋");
        return  user;
    }
    @RequestMapping("test2")
        //  @ModelAttribute("user") 整体 可有可没有
        //public String testModelAttribute(@ModelAttribute("user") User user){
        public String testModelAttribute(User user){
        System.out.println("修改："+user);
        return "ModelAttributeindex";
    }


}
