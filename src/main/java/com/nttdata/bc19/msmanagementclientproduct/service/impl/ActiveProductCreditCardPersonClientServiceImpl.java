package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditCardPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.repository.IActiveProductCreditCardPersonClientRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.ActiveProductCreditCardPersonClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IActiveProductCreditCardPersonClientService;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class ActiveProductCreditCardPersonClientServiceImpl implements IActiveProductCreditCardPersonClientService {

    @Autowired
    IActiveProductCreditCardPersonClientRepository activeProductCreditCardPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<ActiveProductCreditCardPersonClient> create(ActiveProductCreditCardPersonClientRequest activeProductCreditCardPersonClientRequest) {

        return clientServiceWC.findPersonClientById(activeProductCreditCardPersonClientRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findActiveProductById(activeProductCreditCardPersonClientRequest.getIdActiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(activeProductResponse -> {
                            ActiveProductCreditCardPersonClient activeProductCreditCardPersonClient = new ActiveProductCreditCardPersonClient();
                            activeProductCreditCardPersonClient.setId(new ObjectId().toString());
                            activeProductCreditCardPersonClient.setCreatedAt(LocalDateTime.now());
                            activeProductCreditCardPersonClient.setCreditLine(activeProductCreditCardPersonClientRequest.getCreditLine());
                            activeProductCreditCardPersonClient.setAnnualCommission(activeProductCreditCardPersonClientRequest.getAnnualCommission());
                            activeProductCreditCardPersonClient.setCutoffDate(activeProductCreditCardPersonClientRequest.getCutoffDate());
                            activeProductCreditCardPersonClient.setPayLimitDate(activeProductCreditCardPersonClientRequest.getPayLimitDate());
                            //activeProductCreditCardPersonClient.setCreditCardNumber();
                            activeProductCreditCardPersonClient.setPersonClient(personClientResponse);
                            activeProductCreditCardPersonClient.setActiveProduct(activeProductResponse);
                            return activeProductCreditCardPersonClientRepository.save(activeProductCreditCardPersonClient);
                    })
                );
    }

    @Override
    public Mono<ActiveProductCreditCardPersonClient> update(ActiveProductCreditCardPersonClient activeProductCreditCardPersonClient) {
        activeProductCreditCardPersonClient.setUpdatedAt(LocalDateTime.now());
        return activeProductCreditCardPersonClientRepository.save(activeProductCreditCardPersonClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return activeProductCreditCardPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<ActiveProductCreditCardPersonClient> findById(String id) {
        return activeProductCreditCardPersonClientRepository.findById(id);
    }

    @Override
    public Flux<ActiveProductCreditCardPersonClient> findAll() {
        return activeProductCreditCardPersonClientRepository.findAll();
    }
}
