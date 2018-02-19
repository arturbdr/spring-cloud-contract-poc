package com.learn.springcloudcontract.fraud.fraudservice.gateway.rabbitmq;

import com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to.PersonTO;
import lombok.RequiredArgsConstructor;
import org.springframework.cloud.stream.messaging.Source;
import org.springframework.messaging.Message;
import org.springframework.messaging.MessageChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FraudRabbitMQ {

    private final Source source;

    public void sendMessage(PersonTO personTO) {
        Message<PersonTO> sampleMessage = MessageBuilder.withPayload(
                personTO
        ).build();

        MessageChannel output = source.output();
        output.send(sampleMessage);
    }
}
