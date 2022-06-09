package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreCarBusCli;
import com.nttdata.bc19.msmanagementclientproduct.repository.IActProCreCarBusCliRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreCarBusCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActProCreCarBusCliService;
import com.nttdata.bc19.msmanagementclientproduct.util.ActiveProductType;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActProCreCarBusCliSerImpl implements IActProCreCarBusCliService {

    @Autowired
    IActProCreCarBusCliRepository activeProductCreditCardBusinessClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActProCreCarBusCli> create(ActProCreCarBusCliRequest actProCreCarBusCliRequest) {
        return clientServiceWC.findBusinessClientById(actProCreCarBusCliRequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse ->
                        clientServiceWC.findActiveProductById(actProCreCarBusCliRequest.getIdActiveProduct())
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(activeProductResponse -> {
                                    ActProCreCarBusCli actProCreCarBusCli = new ActProCreCarBusCli();
                                    actProCreCarBusCli.setId(new ObjectId().toString());
                                    actProCreCarBusCli.setCreatedAt(LocalDateTime.now());
                                    actProCreCarBusCli.setCreditLine(actProCreCarBusCliRequest.getCreditLine());
                                    actProCreCarBusCli.setAnnualCommission(actProCreCarBusCliRequest.getAnnualCommission());
                                    actProCreCarBusCli.setCutoffDate(actProCreCarBusCliRequest.getCutoffDate());
                                    actProCreCarBusCli.setPayLimitDate(actProCreCarBusCliRequest.getPayLimitDate());
                                    //activeProductCreditCardBusinessClient.setCreditCardNumber();
                                    actProCreCarBusCli.setIdBusinessClient(actProCreCarBusCliRequest.getIdBusinessClient());
                                    actProCreCarBusCli.setIdActiveProduct(actProCreCarBusCliRequest.getIdActiveProduct());
                                    actProCreCarBusCli.setBusinessClient(businessClientResponse);
                                    actProCreCarBusCli.setActiveProduct(activeProductResponse);
                                    if(activeProductResponse.getName().equals(ActiveProductType.CREDITCARD.name()))
                                        return activeProductCreditCardBusinessClientRepository.save(actProCreCarBusCli);
                                    return null;
                                })
                );
    }

    @Override
    public Mono<ActProCreCarBusCli> update(ActProCreCarBusCli actProCreCarBusCli) {
        actProCreCarBusCli.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditCardBusinessClientRepository.save(actProCreCarBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditCardBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActProCreCarBusCli> findById(String id) {
        return activeProductCreditCardBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<ActProCreCarBusCli> findAll() {
        return activeProductCreditCardBusinessClientRepository.findAll();
    }
}
