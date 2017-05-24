package com.sudybooknosecurity.rabbitmq;

import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * 定义目的地队列配置文件
 * Created by HealerJean on 2017/5/9.
 */
@Configuration
public class QuequConfig {

    //定义目的地（队列） 名称为my-queue
    @Bean //2
    public Queue wiselyQueue(){
        return new Queue("my-queue");
    }

}
