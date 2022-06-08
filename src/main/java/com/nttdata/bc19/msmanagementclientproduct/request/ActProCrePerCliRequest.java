package com.nttdata.bc19.msmanagementclientproduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActProCrePerCliRequest {
    private double amountGiven;
    private double interestRate;
    private String idPersonClient;
    private String idActiveProduct;
}
