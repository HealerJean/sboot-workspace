package com.wisely.ch9_3_5;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

/**
 * Created by HealerJean on 2017/5/9.
 */
@Controller
public class TestController {
    @Autowired
    RabbitTemplate rabbitTemplate; //1

    public String rabbitmqStudy(){
        rabbitTemplate.convertAndSend("my-queue", "测试controller"); //3
        return  null;
    }
}
