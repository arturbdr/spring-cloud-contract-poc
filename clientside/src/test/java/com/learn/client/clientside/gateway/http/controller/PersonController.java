package com.learn.client.clientside.gateway.http.controller;

import com.learn.client.clientside.gateway.http.to.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

@SpringBootTest
@RunWith(SpringRunner.class)
public class PersonController {

    @Test
    public void shouldReturnAllPerson() {
        RestTemplate restTemplate = new RestTemplate();

        restTemplate.exchange("http://localhost:8081/person", Person.class);

    }
}
