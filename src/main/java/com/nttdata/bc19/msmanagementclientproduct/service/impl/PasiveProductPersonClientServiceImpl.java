package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductPersonClient;
import com.nttdata.bc19.msmanagementclientproduct.repository.IPasiveProductPersonClientRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.PasiveProductPersonClientRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IPasiveProductPersonClientService;
import com.nttdata.bc19.msmanagementclientproduct.util.DocumentType;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PasiveProductPersonClientServiceImpl implements IPasiveProductPersonClientService {

    @Autowired
    IPasiveProductPersonClientRepository pasiveProductPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<PasiveProductPersonClient> create(PasiveProductPersonClientRequest pasiveProductPersonClientRequest) {

        return clientServiceWC.findPersonClientById(pasiveProductPersonClientRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findPasiveProductById(pasiveProductPersonClientRequest.getIdPasiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(pasiveProductResponse -> {
                            PasiveProductPersonClient pasiveProductPersonClient = new PasiveProductPersonClient();
                            pasiveProductPersonClient.setId(new ObjectId().toString());
                            pasiveProductPersonClient.setCreatedAt(LocalDateTime.now());
                            pasiveProductPersonClient.setAmount(pasiveProductPersonClientRequest.getAmount());
                            //pasiveProductPersonClient.setAccountNumber("GenerateNumberAccount"); //Generate number account
                            pasiveProductPersonClient.setOpeningDate(LocalDateTime.now());
                            pasiveProductPersonClient.setPersonClient(personClientResponse);
                            pasiveProductPersonClient.setPasiveProduct(pasiveProductResponse);

                            if(pasiveProductPersonClient.getPersonClient().getDocumentType().getName().equals(DocumentType.DNI.name()) && pasiveProductPersonClient.getPasiveProduct().getAllowPersonClient()){
                                return pasiveProductPersonClientRepository.save(pasiveProductPersonClient);
                            }
                            return null;
                        })
                );
    }

    @Override
    public Mono<PasiveProductPersonClient> update(PasiveProductPersonClient pasiveProductPersonClient) {
        pasiveProductPersonClient.setUpdatedAt(LocalDateTime.now());
        return pasiveProductPersonClientRepository.save(pasiveProductPersonClient);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return pasiveProductPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<PasiveProductPersonClient> findById(String id) {
        return pasiveProductPersonClientRepository.findById(id);
    }

    @Override
    public Flux<PasiveProductPersonClient> findAll() {
        return pasiveProductPersonClientRepository.findAll();
    }
}
