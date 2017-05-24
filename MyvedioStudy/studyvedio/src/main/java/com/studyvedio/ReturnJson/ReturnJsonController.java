package com.studyvedio.ReturnJson;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 * 测试 domain返回json数据
 * Created by HealerJean on 2017/3/30.
 */
@RestController
public class ReturnJsonController {
    //Spring boot 默认使用的json 解析框架是Jackjson
    @RequestMapping(value = "/returnJson" ,method = RequestMethod.GET)
    public User returnJson(){
        User user = new User();
        user.setAge(23);
        user.setName("Hee35rJean");
        user.setCreateTime(new Date());
        return user; //直接返回就是一个json
    }

}
