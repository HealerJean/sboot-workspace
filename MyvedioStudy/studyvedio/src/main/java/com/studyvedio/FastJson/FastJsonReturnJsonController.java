package com.studyvedio.FastJson;

import com.studyvedio.ReturnJson.User;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Date;

/**
 *
 * Created by HealerJean on 2017/3/30.
 */
@RestController
public class FastJsonReturnJsonController {
    //Spring boot 默认使用的json 解析框架是Jackjson
    @RequestMapping(value = "/fastjsonreturnJson" ,method = RequestMethod.GET)
    public User returnJson(){
        User user = new User();
        user.setAge(223);
        user.setName("Healer2J12ean12");
        user.setCreateTime(new Date());
        return user; //直接返回就是一个json
    }

}
