package com.learn.springcloudcontract.fraud.carrentalclient.gateway.rabbitmq;

import com.learn.springcloudcontract.fraud.carrentalclient.gateway.rabbitmq.to.PersonTO;
import org.assertj.core.api.BDDAssertions;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.stream.messaging.Sink;
import org.springframework.messaging.Message;
import org.springframework.messaging.SubscribableChannel;
import org.springframework.messaging.support.MessageBuilder;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class FraudListenerTest {

    @Autowired
    FraudListener fraudListener;

    @Autowired
    private Sink sink;

    @Test
    public void shouldConsumeFraudMessage() throws Throwable {
        String sampleName = "Sample Name";
        Message<PersonTO> msg = MessageBuilder.withPayload(
                PersonTO.builder().name(sampleName).build()
        ).build();

        SubscribableChannel input = sink.input();
        boolean send = input.send(msg);

        BDDAssertions.then(send).isEqualTo(true);
        BDDAssertions.then(fraudListener.getName()).isEqualTo(sampleName);
    }

}