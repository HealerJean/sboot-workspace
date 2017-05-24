package com.sudybooknosecurity.rabbitmq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class Receiver {
    String message ;
	@RabbitListener(queues = "my-queue")
    public void receiveMessage(String message) {
        this.message = message;
    }

    public String getMessage(){
	    return  this.message;
    }

}
