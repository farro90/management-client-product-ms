package com.nttdata.bc19.msmanagementclientproduct.model;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActiveProductCreditBusinessClient extends BaseModel{
    private BigDecimal amountGiven;
    private BigDecimal amountPaid;
    private BigDecimal interestRate;
    private BusinessClient businessClient;
    private ActiveProduct activeProduct;
}
