package com.nttdata.bc19.msmanagementclientproduct.model;

import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.ActiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.BusinessClient;
import lombok.Data;

import java.math.BigDecimal;

@Data
public class ActProCreBusCli extends BaseModel{
    private double amountGiven;
    private double amountPaid;
    private double interestRate;
    private String idBusinessClient;
    private String idActiveProduct;
    private BusinessClient businessClient;
    private ActiveProduct activeProduct;
}
