package com.nttdata.bc19.msmanagementclientproduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActProCrePerCliRequest {
    private BigDecimal amountGiven;
    private BigDecimal interestRate;
    private String idPersonClient;
    private String idActiveProduct;
}
