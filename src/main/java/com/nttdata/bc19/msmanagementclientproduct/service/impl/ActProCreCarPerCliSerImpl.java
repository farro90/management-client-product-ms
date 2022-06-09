package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.ActProCreCarPerCli;
import com.nttdata.bc19.msmanagementclientproduct.repository.IActProCreCarPerCliRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.ActProCreCarPerCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActProCreCarPerCliService;
import com.nttdata.bc19.msmanagementclientproduct.util.ActiveProductType;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActProCreCarPerCliSerImpl implements IActProCreCarPerCliService {

    @Autowired
    IActProCreCarPerCliRepository activeProductCreditCardPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActProCreCarPerCli> create(ActProCreCarPerCliRequest actProCreCarPerCliRequest) {

        return clientServiceWC.findPersonClientById(actProCreCarPerCliRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findActiveProductById(actProCreCarPerCliRequest.getIdActiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(activeProductResponse -> {
                            ActProCreCarPerCli actProCreCarPerCli = new ActProCreCarPerCli();
                            actProCreCarPerCli.setId(new ObjectId().toString());
                            actProCreCarPerCli.setCreatedAt(LocalDateTime.now());
                            actProCreCarPerCli.setCreditLine(actProCreCarPerCliRequest.getCreditLine());
                            actProCreCarPerCli.setAnnualCommission(actProCreCarPerCliRequest.getAnnualCommission());
                            actProCreCarPerCli.setCutoffDate(actProCreCarPerCliRequest.getCutoffDate());
                            actProCreCarPerCli.setPayLimitDate(actProCreCarPerCliRequest.getPayLimitDate());
                            //activeProductCreditCardPersonClient.setCreditCardNumber();
                            actProCreCarPerCli.setIdPersonClient(actProCreCarPerCliRequest.getIdPersonClient());
                            actProCreCarPerCli.setIdActiveProduct(actProCreCarPerCliRequest.getIdActiveProduct());
                            actProCreCarPerCli.setPersonClient(personClientResponse);
                            actProCreCarPerCli.setActiveProduct(activeProductResponse);

                            if(activeProductResponse.getName().equals(ActiveProductType.TARJETACREDITO.name()))
                                return activeProductCreditCardPersonClientRepository.save(actProCreCarPerCli);
                            return null;
                    })
                );
    }

    @Override
    public Mono<ActProCreCarPerCli> update(ActProCreCarPerCli actProCreCarPerCli) {
        actProCreCarPerCli.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditCardPersonClientRepository.save(actProCreCarPerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditCardPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActProCreCarPerCli> findById(String id) {
        return activeProductCreditCardPersonClientRepository.findById(id);
    }

    @Override
    public Flux<ActProCreCarPerCli> findAll() {
        return activeProductCreditCardPersonClientRepository.findAll();
    }
}
