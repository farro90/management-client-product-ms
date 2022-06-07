package com.nttdata.bc19.msmanagementclientproduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActiveProductCreditPersonClientRequest {
    private BigDecimal amountGiven;
    private BigDecimal interestRate;
    private String idPersonClient;
    private String idActiveProduct;
}
