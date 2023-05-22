package dev.danielarrais.multiplequeuesrabbit.broker.setup;

import lombok.RequiredArgsConstructor;
import org.springframework.amqp.core.Declarables;
import org.springframework.amqp.core.Queue;
import org.springframework.amqp.core.QueueBuilder;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
@RequiredArgsConstructor
public class QueuesInitializer {

    private final QueuesProperties queuesProperties;

    @Bean
    public Declarables queues() {
        return buildPrimaryQueues();
    }

    private Declarables buildPrimaryQueues() {
        List<Queue> queues = queuesProperties.getQueues().stream().map(
                queue ->
                        QueueBuilder.durable(queue.getName())
                                .ttl(queue.getTll())
                                .build()).toList();

        return new Declarables(queues);
    }

}