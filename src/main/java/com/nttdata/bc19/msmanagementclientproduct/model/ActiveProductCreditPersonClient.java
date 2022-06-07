package com.nttdata.bc19.msmanagementclientproduct.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class ActiveProductCreditPersonClient extends BaseModel{
    private BigDecimal amountGiven;
    private BigDecimal amountPaid;
    private BigDecimal interestRate;
    private PersonClient personClient;
    private ActiveProduct activeProduct;
}
