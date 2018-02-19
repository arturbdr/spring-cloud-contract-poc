package com.learn.springcloudcontract.fraud.fraudservice.gateway.http.to;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Address {
    private String zipcode;
    private String number;
    private String street;
}
