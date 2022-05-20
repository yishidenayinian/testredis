package com.example.testredis;

import com.example.testredis.testCurdRepository.factory.BaseJpaRepositoryFactoryBean;
import org.apache.kafka.clients.consumer.ConsumerRecord;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.annotation.KafkaListeners;
import org.springframework.messaging.handler.annotation.SendTo;

import java.util.concurrent.CountDownLatch;

@SpringBootApplication
public class TestredisApplication {

    public static void main(String[] args) {
        SpringApplication.run(TestredisApplication.class, args);
    }

}
