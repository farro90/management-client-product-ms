package com.nttdata.bc19.msmanagementclientproduct.model;

import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.BusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.PasiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.PersonClient;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Document
public class PasProBusCli extends BaseModel{
    //private String code;
    private BigDecimal amount;
    private String accountNumber;
    private LocalDateTime openingDate;
    private String idBusinessClient;
    private String idPasiveProduct;
    private BusinessClient businessClient;
    private PasiveProduct pasiveProduct;
    private List<PersonClient> holders;
    private List<PersonClient> signers;
    //private boolean state;
}
