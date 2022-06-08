package com.nttdata.bc19.msmanagementclientproduct.model;

import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.ActiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.PersonClient;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;

@Data
@Document
public class ActProCrePerCli extends BaseModel{
    private BigDecimal amountGiven;
    private BigDecimal amountPaid;
    private BigDecimal interestRate;
    private String idPersonClient;
    private String idActiveProduct;
    private PersonClient personClient;
    private ActiveProduct activeProduct;
}
