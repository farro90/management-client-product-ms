package com.nttdata.bc19.msmanagementclientproduct.model.responseWC;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PasiveProduct {
    private String id;
    private String name;
    private BigDecimal maintenanceCommission;
    private BigDecimal transactionCommission;
    private BigDecimal minimumOpeningAmount;
    private int numLimitMovements;
    private int dayMovement;
    private Boolean allowBusinessClient;
    private Boolean allowPersonClient;
    private Boolean needCreditCard;
}
