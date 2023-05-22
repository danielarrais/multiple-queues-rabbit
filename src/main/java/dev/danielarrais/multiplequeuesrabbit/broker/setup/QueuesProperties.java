package dev.danielarrais.multiplequeuesrabbit.broker.setup;

import jakarta.validation.constraints.NotBlank;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;
import org.springframework.util.CollectionUtils;
import org.springframework.validation.annotation.Validated;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Map;

@Data
@Validated
@Component
@ConfigurationProperties
public class QueuesProperties {

    private Map<String, Queue> queues;

    public Collection<Queue> getQueues() {
        if (CollectionUtils.isEmpty(queues)) return new ArrayList<>();
        return queues.values();
    }

    @Data
    @Validated
    public static class Queue {
        @NotBlank
        private String name;
        private int tll;
    }
}