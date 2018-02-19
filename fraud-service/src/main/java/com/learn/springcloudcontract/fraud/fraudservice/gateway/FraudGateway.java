package com.learn.springcloudcontract.fraud.fraudservice.gateway;

import com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to.PersonTO;

public interface FraudGateway {

    public void sendPersonTO(PersonTO personTO);
}
