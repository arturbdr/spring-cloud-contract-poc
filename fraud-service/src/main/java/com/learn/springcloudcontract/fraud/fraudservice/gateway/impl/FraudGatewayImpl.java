package com.learn.springcloudcontract.fraud.fraudservice.gateway.impl;

import com.learn.springcloudcontract.fraud.fraudservice.gateway.FraudGateway;
import com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to.PersonTO;
import com.learn.springcloudcontract.fraud.fraudservice.gateway.rabbitmq.FraudRabbitMQ;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Component;

@Component
@RequiredArgsConstructor
public class FraudGatewayImpl implements FraudGateway {

    private final FraudRabbitMQ fraudRabbitMQ;

    @Override
    public void sendPersonTO(PersonTO personTO) {
        fraudRabbitMQ.sendMessage(personTO);

    }
}
