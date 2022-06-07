package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditCardBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditCardPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.repository.IActiveProductCreditCardBusinessClientRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditCardBusinessClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditCardBusinessClientService;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActiveProductCreditCardBusinessClientServiceImpl implements IActiveProductCreditCardBusinessClientService {

    @Autowired
    IActiveProductCreditCardBusinessClientRepository activeProductCreditCardBusinessClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActiveProductCreditCardBusinessClient> create(ActiveProductCreditCardBusinessClientRequest activeProductCreditCardBusinessClientRequest) {
        return clientServiceWC.findBusinessClientById(activeProductCreditCardBusinessClientRequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse ->
                        clientServiceWC.findActiveProductById(activeProductCreditCardBusinessClientRequest.getIdActiveProduct())
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(activeProductResponse -> {
                                    ActiveProductCreditCardBusinessClient activeProductCreditCardBusinessClient = new ActiveProductCreditCardBusinessClient();
                                    activeProductCreditCardBusinessClient.setId(new ObjectId().toString());
                                    activeProductCreditCardBusinessClient.setCreatedAt(LocalDateTime.now());
                                    activeProductCreditCardBusinessClient.setCreditLine(activeProductCreditCardBusinessClientRequest.getCreditLine());
                                    activeProductCreditCardBusinessClient.setAnnualCommission(activeProductCreditCardBusinessClientRequest.getAnnualCommission());
                                    activeProductCreditCardBusinessClient.setCutoffDate(activeProductCreditCardBusinessClientRequest.getCutoffDate());
                                    activeProductCreditCardBusinessClient.setPayLimitDate(activeProductCreditCardBusinessClientRequest.getPayLimitDate());
                                    //activeProductCreditCardBusinessClient.setCreditCardNumber();
                                    activeProductCreditCardBusinessClient.setBusinessClient(businessClientResponse);
                                    activeProductCreditCardBusinessClient.setActiveProduct(activeProductResponse);
                                    return activeProductCreditCardBusinessClientRepository.save(activeProductCreditCardBusinessClient);
                                })
                );
    }

    @Override
    public Mono<ActiveProductCreditCardBusinessClient> update(ActiveProductCreditCardBusinessClient activeProductCreditCardBusinessClient) {
        activeProductCreditCardBusinessClient.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditCardBusinessClientRepository.save(activeProductCreditCardBusinessClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditCardBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActiveProductCreditCardBusinessClient> findById(String id) {
        return activeProductCreditCardBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<ActiveProductCreditCardBusinessClient> findAll() {
        return activeProductCreditCardBusinessClientRepository.findAll();
    }
}
