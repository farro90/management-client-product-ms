package com.nttdata.bc19.msmanagementclientproduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActiveProductCreditCardPersonClientRequest {
    private BigDecimal creditLine;
    private int AnnualCommission;
    private int cutoffDate;
    private int payLimitDate;
    private String idPersonClient;
    private String idActiveProduct;
}
