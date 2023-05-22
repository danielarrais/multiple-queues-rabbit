package dev.danielarrais.multiplequeuesrabbit.broker.consumer;


import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.core.Message;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Log4j2
@Component
public class Example2Consumer {

    @RabbitListener(queues = "${queues.example1Queue.name}")
    public void consumer(Message message) {
        log.info("Received example2Queue message!!!");
    }
}
