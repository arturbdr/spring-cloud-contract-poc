package com.learn.springcloudcontract.fraud.fraudservice.usecase;

import com.learn.springcloudcontract.fraud.fraudservice.gateway.FraudGateway;
import com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to.PersonTO;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class FraudServices {

    private final FraudGateway fraudGateway;

    public void sendPerson(PersonTO personTO) {
        fraudGateway.sendPersonTO(personTO);
    }
}
