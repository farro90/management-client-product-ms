package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.model.PersonClient;
import com.nttdata.bc19.msmanagementclientproduct.repository.IActiveProductCreditPersonClientRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditPersonClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditPersonClientService;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActiveProductCreditPersonClientServiceImpl implements IActiveProductCreditPersonClientService {

    @Autowired
    IActiveProductCreditPersonClientRepository activeProductCreditPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActiveProductCreditPersonClient> create(ActiveProductCreditPersonClientRequest activeProductCreditPersonClientRequest) {

        return clientServiceWC.findPersonClientById(activeProductCreditPersonClientRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findActiveProductById(activeProductCreditPersonClientRequest.getIdActiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(activeProductResponse -> {
                            ActiveProductCreditPersonClient activeProductCreditPersonClient = new ActiveProductCreditPersonClient();
                            activeProductCreditPersonClient.setId(new ObjectId().toString());
                            activeProductCreditPersonClient.setCreatedAt(LocalDateTime.now());
                            activeProductCreditPersonClient.setAmountGiven(activeProductCreditPersonClientRequest.getAmountGiven());
                            activeProductCreditPersonClient.setInterestRate(activeProductCreditPersonClientRequest.getInterestRate());
                            activeProductCreditPersonClient.setPersonClient(personClientResponse);
                            activeProductCreditPersonClient.setActiveProduct(activeProductResponse);
                            return activeProductCreditPersonClientRepository.save(activeProductCreditPersonClient);
                        })
                );
    }

    @Override
    public Mono<ActiveProductCreditPersonClient> update(ActiveProductCreditPersonClient activeProductCreditPersonClient) {
        activeProductCreditPersonClient.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditPersonClientRepository.save(activeProductCreditPersonClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActiveProductCreditPersonClient> findById(String id) {
        return activeProductCreditPersonClientRepository.findById(id);
    }

    @Override
    public Flux<ActiveProductCreditPersonClient> findAll() {
        return activeProductCreditPersonClientRepository.findAll();
    }
}
