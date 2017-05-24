package com.sudybooknosecurity.rabbitmq;

import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by HealerJean on 2017/5/9.
 */
@RestController
public class TestController {
    @Autowired
    RabbitTemplate rabbitTemplate; //1
    @Autowired
    private Receiver receiver;

    @RequestMapping(value = "rabbitmqOne" ,method = RequestMethod.GET)
    public String rabbitmqStudy(String message){
        rabbitTemplate.convertAndSend("my-queue", message);//3
        return  receiver.getMessage();
    }
}
