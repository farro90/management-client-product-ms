package com.nttdata.bc19.msmanagementclientproduct.model;

import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.ActiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.PersonClient;
import lombok.Data;
import org.springframework.data.mongodb.core.mapping.Document;

import java.math.BigDecimal;
import java.time.LocalDateTime;

@Data
@Document
public class ActProCreCarPerCli extends BaseModel{
    private String creditCardNumber;
    private BigDecimal creditLine;
    private BigDecimal amountConsumed;
    private BigDecimal minimumPayment;
    private int AnnualCommission;
    private int cutoffDate;
    private int payLimitDate;
    private LocalDateTime openingDate;
    private LocalDateTime deliveryDate;
    private String idPersonClient;
    private String idActiveProduct;
    private PersonClient personClient;
    private ActiveProduct activeProduct;
}
