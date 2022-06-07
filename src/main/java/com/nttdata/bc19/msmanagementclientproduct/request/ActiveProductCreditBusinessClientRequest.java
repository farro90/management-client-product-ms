package com.nttdata.bc19.msmanagementclientproduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActiveProductCreditBusinessClientRequest {
    private BigDecimal amountGiven;
    private BigDecimal interestRate;
    private String idBusinessClient;
    private String idActiveProduct;
}
