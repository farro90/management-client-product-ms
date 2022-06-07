package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.model.PersonClient;
import com.nttdata.bc19.msmanagementclientproduct.repository.IActiveProductCreditBusinessClientRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditBusinessClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditBusinessClientService;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActiveProductCreditBusinessClientServiceImpl implements IActiveProductCreditBusinessClientService {

    @Autowired
    IActiveProductCreditBusinessClientRepository activeProductCreditBusinessClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActiveProductCreditBusinessClient> create(ActiveProductCreditBusinessClientRequest activeProductCreditBusinessClientRequest) {

        return clientServiceWC.findBusinessClientById(activeProductCreditBusinessClientRequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse ->
                    clientServiceWC.findActiveProductById(activeProductCreditBusinessClientRequest.getIdActiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(activeProductResponse ->{
                            ActiveProductCreditBusinessClient activeProductCreditBusinessClient = new ActiveProductCreditBusinessClient();
                            activeProductCreditBusinessClient.setId(new ObjectId().toString());
                            activeProductCreditBusinessClient.setCreatedAt(LocalDateTime.now());
                            activeProductCreditBusinessClient.setAmountGiven(activeProductCreditBusinessClientRequest.getAmountGiven());
                            activeProductCreditBusinessClient.setInterestRate(activeProductCreditBusinessClientRequest.getInterestRate());
                            activeProductCreditBusinessClient.setBusinessClient(businessClientResponse);
                            activeProductCreditBusinessClient.setActiveProduct(activeProductResponse);
                            return activeProductCreditBusinessClientRepository.save(activeProductCreditBusinessClient);
                        })
                );
    }

    @Override
    public Mono<ActiveProductCreditBusinessClient> update(ActiveProductCreditBusinessClient activeProductCreditBusinessClient) {
        activeProductCreditBusinessClient.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditBusinessClientRepository.save(activeProductCreditBusinessClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActiveProductCreditBusinessClient> findById(String id) {
        return activeProductCreditBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<ActiveProductCreditBusinessClient> findAll() {
        return activeProductCreditBusinessClientRepository.findAll();
    }
}
