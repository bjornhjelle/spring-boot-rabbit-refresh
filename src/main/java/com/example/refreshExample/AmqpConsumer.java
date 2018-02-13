package com.example.refreshExample;

/**
 * Created by Bjørn Hjelle, Acando on 23.01.2018.
 */
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.amqp.core.ExchangeTypes;
import org.springframework.amqp.rabbit.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

import static org.springframework.context.annotation.ScopedProxyMode.INTERFACES;

public class AmqpConsumer {

    private static final Log LOG = LogFactory.getLog(AmqpConsumer.class);

    @Value("${bar:World!}")
    String bar;

    private TestComponent testComponent;

    @Autowired
    public AmqpConsumer(TestComponent testComponent) {
        this.testComponent = testComponent;
    }


    public String get() {
        return bar;
    }

    @RabbitListener(bindings = @QueueBinding(
            value = @Queue(
                    value = "${amqp.queue}",
                    autoDelete = "true",
                    durable = "false"
            ),
            exchange = @Exchange(
                    value = "${amqp.topicExchange}",
                    type = ExchangeTypes.TOPIC,
                    durable = "true"
            ),
            key = "${amqp.routingKey}"

    )
    )
    public void processEvent(byte[] messagePayload) throws Exception {

        System.out.println(this.hashCode() + " Hello " + testComponent.get());
    }



}