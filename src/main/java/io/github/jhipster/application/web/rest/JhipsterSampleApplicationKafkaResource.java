package io.github.jhipster.application.web.rest;

import io.github.jhipster.application.service.JhipsterSampleApplicationKafkaProducer;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/api/jhipster-sample-application-kafka")
public class JhipsterSampleApplicationKafkaResource {

    private final Logger log = LoggerFactory.getLogger(JhipsterSampleApplicationKafkaResource.class);

    private JhipsterSampleApplicationKafkaProducer kafkaProducer;

    public JhipsterSampleApplicationKafkaResource(JhipsterSampleApplicationKafkaProducer kafkaProducer) {
        this.kafkaProducer = kafkaProducer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestParam("message") String message) {
        log.debug("REST request to send to Kafka topic the message : {}", message);
        this.kafkaProducer.sendMessage(message);
    }
}
