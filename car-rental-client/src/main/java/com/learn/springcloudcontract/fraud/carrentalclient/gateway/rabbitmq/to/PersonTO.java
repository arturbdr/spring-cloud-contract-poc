package com.learn.springcloudcontract.fraud.carrentalclient.gateway.rabbitmq.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonTO {
    private String name;
    private int age;
}
