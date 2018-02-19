package com.learn.springcloudcontract.fraud.fraudservice.config;

import com.jayway.restassured.module.mockmvc.RestAssuredMockMvc;
import com.learn.springcloudcontract.fraud.fraudservice.FraudServiceApplication;
import com.learn.springcloudcontract.fraud.fraudservice.gateway.http.FraudController;
import org.junit.Before;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.verifier.messaging.boot.AutoConfigureMessageVerifier;
import org.springframework.test.context.junit4.SpringRunner;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = FraudServiceApplication.class)
@AutoConfigureMessageVerifier
public class BaseClass {

    @Autowired
    FraudController fraudController;

    @Before
    public void setup() {
        RestAssuredMockMvc.standaloneSetup(fraudController);
    }

    public void triggerMessage() {

    }
}
