package com.learn.springcloudcontract.fraud.fraudservice.gateway.http;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to.PersonTO;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class FraudController {

    private final ObjectMapper objectMapper;

    @GetMapping("/fraudsters")
    public ResponseEntity<Collection<PersonTO>> getFraudsters() {
        Collection<PersonTO> personTOS = Collections.singletonList(PersonTO.builder()
                .age(10)
                .name("John")
                .build());

        return ResponseEntity.ok().body((personTOS));
    }
}
