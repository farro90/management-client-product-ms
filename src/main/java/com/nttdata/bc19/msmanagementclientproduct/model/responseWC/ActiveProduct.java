package com.nttdata.bc19.msmanagementclientproduct.model.responseWC;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActiveProduct {
    private String id;
    private String name;
    private double interestRateMonth;
    private boolean allowBusinessClient;
    private boolean allowPersonClient;
}
