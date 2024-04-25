package com.whhc.config;

import org.springframework.amqp.core.Binding;
import org.springframework.amqp.core.BindingBuilder;
import org.springframework.amqp.core.FanoutExchange;
import org.springframework.amqp.core.Queue;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author HKK
 * @version 1.0
 * @date 2024-04-24 17:32
 */
@Configuration
public class FanoutConfig{

    // 声明FanoutExchange交换机
    @Bean
    public FanoutExchange fanoutExchange(){
        return new FanoutExchange("whhc.fanout2");
    }

    // 声明一个队列
    @Bean
    public Queue fanoutQueue3(){
        return new Queue("fanout.queue3");
    }

    // 绑定队列和交换机
    @Bean
    public Binding bindingQueue1(Queue fanoutQueue3, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue3).to(fanoutExchange);
    }


    // 声明一个队列
    @Bean
    public Queue fanoutQueue4(){
        return new Queue("fanout.queue4");
    }

    // 绑定队列和交换机
    @Bean
    public Binding bindingQueue2(Queue fanoutQueue4, FanoutExchange fanoutExchange){
        return BindingBuilder.bind(fanoutQueue4).to(fanoutExchange);
    }
}
