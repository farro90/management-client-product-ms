package com.nttdata.bc19.msmanagementclientproduct.model;

import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class ActiveProductCreditCardPersonClient extends BaseModel{
    private String creditCardNumber;
    private BigDecimal creditLine;
    private BigDecimal amountConsumed;
    private BigDecimal minimumPayment;
    private int AnnualCommission;
    private int cutoffDate;
    private int payLimitDate;
    private LocalDateTime openingDate;
    private LocalDateTime deliveryDate;
    private PersonClient personClient;
    private ActiveProduct activeProduct;
}
