package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreBusCli;
import com.nttdata.bc19.msmanagementclientproduct.repository.IActProCreBusCliRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreBusCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActProCreBusCliService;
import com.nttdata.bc19.msmanagementclientproduct.util.ActiveProductType;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActProCreBusCliSerImpl implements IActProCreBusCliService {

    @Autowired
    IActProCreBusCliRepository activeProductCreditBusinessClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActProCreBusCli> create(ActProCreBusCliRequest actProCreBusCliRequest) {

        return clientServiceWC.findBusinessClientById(actProCreBusCliRequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse ->
                    clientServiceWC.findActiveProductById(actProCreBusCliRequest.getIdActiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(activeProductResponse ->{
                            ActProCreBusCli actProCreBusCli = new ActProCreBusCli();
                            actProCreBusCli.setId(new ObjectId().toString());
                            actProCreBusCli.setCreatedAt(LocalDateTime.now());
                            actProCreBusCli.setAmountGiven(actProCreBusCliRequest.getAmountGiven());
                            actProCreBusCli.setInterestRate(actProCreBusCliRequest.getInterestRate());
                            actProCreBusCli.setIdBusinessClient(actProCreBusCliRequest.getIdBusinessClient());
                            actProCreBusCli.setIdActiveProduct(actProCreBusCliRequest.getIdActiveProduct());
                            actProCreBusCli.setBusinessClient(businessClientResponse);
                            actProCreBusCli.setActiveProduct(activeProductResponse);
                            if(activeProductResponse.getName().equals(ActiveProductType.CREDITO.name()))
                                return activeProductCreditBusinessClientRepository.save(actProCreBusCli);
                            return null;
                        })
                );
    }

    @Override
    public Mono<ActProCreBusCli> update(ActProCreBusCli actProCreBusCli) {
        actProCreBusCli.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditBusinessClientRepository.save(actProCreBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActProCreBusCli> findById(String id) {
        return activeProductCreditBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<ActProCreBusCli> findAll() {
        return activeProductCreditBusinessClientRepository.findAll();
    }
}
