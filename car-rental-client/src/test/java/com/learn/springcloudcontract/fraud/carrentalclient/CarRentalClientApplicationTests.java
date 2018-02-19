package com.learn.springcloudcontract.fraud.carrentalclient;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.github.tomakehurst.wiremock.client.WireMock;
import com.learn.springcloudcontract.fraud.carrentalclient.gateway.http.to.Address;
import com.learn.springcloudcontract.fraud.carrentalclient.gateway.http.to.PersonTO;
import org.assertj.core.api.BDDAssertions;
import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.cloud.contract.stubrunner.junit.StubRunnerRule;
import org.springframework.cloud.contract.wiremock.AutoConfigureWireMock;
import org.springframework.core.ParameterizedTypeReference;
import org.springframework.http.HttpMethod;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.RestTemplate;

import java.util.Collection;
import java.util.Collections;
import java.util.List;

import static org.springframework.http.HttpStatus.OK;

@RunWith(SpringRunner.class)
@SpringBootTest
@AutoConfigureWireMock(port = 8081)
public class CarRentalClientApplicationTests {

    @Rule
    public StubRunnerRule stubRunnerRule =
            new StubRunnerRule()
                    .downloadStub("com.learn.springcloudcontract.fraud", "fraud-service")
                    .workOffline(true)
                    .minPort(9090)
                    .maxPort(9090);

    @Test
    public void shouldReturnAllFraudPerson() throws JsonProcessingException {

        ObjectMapper objectMapper = new ObjectMapper();

        List<PersonTO> personTOS = Collections.singletonList(PersonTO.builder()
                .age(10)
                .name("John")
                .build());

        String expectedJsonReturned = objectMapper.writeValueAsString(personTOS);

        WireMock.stubFor(
                WireMock.get(WireMock.urlEqualTo("/fraudster"))
                        .willReturn(WireMock.aResponse()
                                .withHeader("Content-Type", MediaType.APPLICATION_JSON_VALUE)
                                .withStatus(OK.value())
                                .withBody(expectedJsonReturned))
        );

        ParameterizedTypeReference<Collection<PersonTO>> parameterizedTypeReference =
                new ParameterizedTypeReference<Collection<PersonTO>>() {
                };

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Collection<PersonTO>> responseEntity = restTemplate.exchange("http://localhost:8081/fraudster",
                HttpMethod.GET,
                null,
                parameterizedTypeReference);

        Collection<PersonTO> body = responseEntity.getBody();
        BDDAssertions.then(body.stream().findFirst().get()).isEqualTo(personTOS.stream().findFirst().get());
        BDDAssertions.then(responseEntity.getStatusCode()).isEqualTo(OK);

    }

    @Test
    public void shouldReturnAllFraudPersonIntegration() {

        List<PersonTO> personTOS = Collections.singletonList(PersonTO.builder()
                .age(10)
                .name("John")
                .build());

        ParameterizedTypeReference<Collection<PersonTO>> parameterizedTypeReference =
                new ParameterizedTypeReference<Collection<PersonTO>>() {
                };

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Collection<PersonTO>> responseEntity = restTemplate.exchange("http://localhost:9090/fraudster",
                HttpMethod.GET,
                null,
                parameterizedTypeReference);

        Collection<PersonTO> body = responseEntity.getBody();
        BDDAssertions.then(body.stream().findFirst().get()).isEqualTo(personTOS.stream().findFirst().get());
        BDDAssertions.then(responseEntity.getStatusCode()).isEqualTo(OK);

    }

    @Test
    public void shouldReturnAllFraudPersonAddressIntegration() {

        List<PersonTO> personTOS = Collections.singletonList(PersonTO.builder()
                .age(10)
                .name("John")
                .address(Address.builder()
                        .number(555)
                        .street("Any Street Name").build())
                .build());

        ParameterizedTypeReference<Collection<PersonTO>> parameterizedTypeReference =
                new ParameterizedTypeReference<Collection<PersonTO>>() {
                };

        RestTemplate restTemplate = new RestTemplate();

        ResponseEntity<Collection<PersonTO>> responseEntity = restTemplate.exchange("http://localhost:9090/fraudster",
                HttpMethod.GET,
                null,
                parameterizedTypeReference);

        Collection<PersonTO> body = responseEntity.getBody();
        BDDAssertions.then(body.stream().findFirst().get()).isEqualTo(personTOS.stream().findFirst().get());
        BDDAssertions.then(responseEntity.getStatusCode()).isEqualTo(OK);

    }
}
