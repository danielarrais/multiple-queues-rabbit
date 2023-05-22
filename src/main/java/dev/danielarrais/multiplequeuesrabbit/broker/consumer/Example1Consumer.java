package dev.danielarrais.multiplequeuesrabbit.broker.consumer;


import lombok.extern.java.Log;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Log4j2
public class Example1Consumer {

    @RabbitListener(queues = "${queues.example1Queue.name}")
    public void consumer(Message message) {
        log.info("Received example1Queue message!!!");
    }
}
