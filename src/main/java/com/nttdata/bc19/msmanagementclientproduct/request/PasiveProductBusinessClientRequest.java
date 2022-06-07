package com.nttdata.bc19.msmanagementclientproduct.request;

import lombok.Data;

import java.math.BigDecimal;

@Data
public class PasiveProductBusinessClientRequest {
    //private String code;
    private BigDecimal amount;
    //private String accountNumber;
    //private LocalDateTime openingDate;
    private String idBusinessClient;
    private String idPasiveProduct;
    //private boolean state;
}
