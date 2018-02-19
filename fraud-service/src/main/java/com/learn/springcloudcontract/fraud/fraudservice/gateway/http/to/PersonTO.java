package com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class PersonTO {
    private Address address;
    private String name;
    private int age;
}
