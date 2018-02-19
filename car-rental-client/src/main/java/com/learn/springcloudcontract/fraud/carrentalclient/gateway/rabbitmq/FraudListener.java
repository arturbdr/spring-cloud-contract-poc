package com.learn.springcloudcontract.fraud.carrentalclient.gateway.rabbitmq;

import com.learn.springcloudcontract.fraud.carrentalclient.gateway.rabbitmq.to.PersonTO;
import lombok.Getter;
import lombok.extern.slf4j.Slf4j;
import org.springframework.cloud.stream.annotation.StreamListener;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class FraudListener {

    @Getter
    private String name;

    @StreamListener(Sink.INPUT)
    public void onfraudMessage(PersonTO personTO) {
        log.info("This is the person: {}", personTO);
        this.name = personTO.getName();
    }
}
