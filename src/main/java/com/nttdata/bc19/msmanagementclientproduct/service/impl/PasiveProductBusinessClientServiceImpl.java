package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductBusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.repository.IPasiveProductBusinessClientRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.PasiveProductBusinessClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IPasiveProductBusinessClientService;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PasiveProductBusinessClientServiceImpl implements IPasiveProductBusinessClientService {

    @Autowired
    IPasiveProductBusinessClientRepository pasiveProductBusinessClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;
    
    @Override
    public Mono<PasiveProductBusinessClient> create(PasiveProductBusinessClientRequest pasiveProductBusinessClientrequest) {
        return clientServiceWC.findBusinessClientById(pasiveProductBusinessClientrequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse ->
                        clientServiceWC.findPasiveProductById(pasiveProductBusinessClientrequest.getIdPasiveProduct())
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(pasiveProductResponse -> {
                                    PasiveProductBusinessClient pasiveProductBusinessClient = new PasiveProductBusinessClient();
                                    pasiveProductBusinessClient.setId(new ObjectId().toString());
                                    pasiveProductBusinessClient.setCreatedAt(LocalDateTime.now());
                                    pasiveProductBusinessClient.setAmount(pasiveProductBusinessClientrequest.getAmount());
                                    //pasiveProductBusinessClient.setAccountNumber("GenerateNumberAccount"); //Generate number account
                                    pasiveProductBusinessClient.setOpeningDate(LocalDateTime.now());
                                    pasiveProductBusinessClient.setBusinessClient(businessClientResponse);
                                    pasiveProductBusinessClient.setPasiveProduct(pasiveProductResponse);

                                    if(pasiveProductBusinessClient.getPasiveProduct().getAllowBusinessClient()){
                                        return pasiveProductBusinessClientRepository.save(pasiveProductBusinessClient);
                                    }
                                    return null;
                                })
                );
    }

    @Override
    public Mono<PasiveProductBusinessClient> update(PasiveProductBusinessClient pasiveProductBusinessClient) {
        pasiveProductBusinessClient.setUpdatedAt(LocalDateTime.now());
        return pasiveProductBusinessClientRepository.save(pasiveProductBusinessClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return pasiveProductBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<PasiveProductBusinessClient> findById(String id) {
        return pasiveProductBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<PasiveProductBusinessClient> findAll() {
        return pasiveProductBusinessClientRepository.findAll();
    }
}
