package io.github.jhipster.application.service;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.stereotype.Service;

import java.io.IOException;

@Service
public class JhipsterSampleApplicationKafkaConsumer {

    private final Logger log = LoggerFactory.getLogger(JhipsterSampleApplicationKafkaConsumer.class);
    private static final String TOPIC = "topic_jhipstersampleapplication";

    @KafkaListener(topics = "topic_jhipstersampleapplication", groupId = "group_id")
    public void consume(String message) throws IOException {
        log.info("Consumed message in {} : {}", TOPIC, message);
    }
}
