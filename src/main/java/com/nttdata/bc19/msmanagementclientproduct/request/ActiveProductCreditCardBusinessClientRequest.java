package com.nttdata.bc19.msmanagementclientproduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActiveProductCreditCardBusinessClientRequest {
    private BigDecimal creditLine;
    private int AnnualCommission;
    private int cutoffDate;
    private int payLimitDate;
    private String idBusinessClient;
    private String idActiveProduct;
}
