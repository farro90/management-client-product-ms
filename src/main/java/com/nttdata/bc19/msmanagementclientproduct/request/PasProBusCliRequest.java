package com.nttdata.bc19.msmanagementclientproduct.request;

import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.PersonClient;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

@Data
public class PasProBusCliRequest {
    //private String code;
    private BigDecimal amount;
    //private String accountNumber;
    //private LocalDateTime openingDate;
    private String idBusinessClient;
    private String idPasiveProduct;
    private List<PersonClient> holders;
    private List<PersonClient> signers;
    //private boolean state;
}
