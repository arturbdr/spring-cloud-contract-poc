package com.learn.springcloudcontract.fraud.fraudservice.gateway.http;

import com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to.PersonTO;
import com.learn.springcloudcontract.fraud.fraudservice.usecase.FraudServices;
import lombok.RequiredArgsConstructor;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collection;
import java.util.Collections;

@RestController
@RequiredArgsConstructor
public class FraudController {

    private final FraudServices fraudServices;

    @GetMapping(value = "/fraudster", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Collection<PersonTO>> getFraudsters() {
        Collection<PersonTO> personTOS = Collections.singletonList(PersonTO.builder()
                .age(10)
                .name("John")
                .build());

        return ResponseEntity.ok().body(personTOS);
    }

    @PostMapping(value = "/message")
    public ResponseEntity message() {
        PersonTO samplePerson = PersonTO.builder()
                .name("Sample Name")
                .build();

        fraudServices.sendPerson(samplePerson);

        return ResponseEntity.noContent().build();
    }
}
