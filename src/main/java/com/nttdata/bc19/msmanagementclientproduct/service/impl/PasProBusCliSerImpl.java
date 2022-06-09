package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.PasProBusCli;
import com.nttdata.bc19.msmanagementclientproduct.repository.IPasProBusCliRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.PasProBusCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IPasProBusCliService;
import com.nttdata.bc19.msmanagementclientproduct.util.PasiveProductType;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PasProBusCliSerImpl implements IPasProBusCliService {

    @Autowired
    IPasProBusCliRepository pasiveProductBusinessClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;
    
    @Override
    public Mono<PasProBusCli> create(PasProBusCliRequest pasiveProductBusinessClientrequest) {
        return clientServiceWC.findBusinessClientById(pasiveProductBusinessClientrequest.getIdBusinessClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(businessClientResponse ->
                        clientServiceWC.findPasiveProductById(pasiveProductBusinessClientrequest.getIdPasiveProduct())
                                .switchIfEmpty(Mono.error(new Exception()))
                                .flatMap(pasiveProductResponse -> {
                                    PasProBusCli pasProBusCli = new PasProBusCli();
                                    pasProBusCli.setId(new ObjectId().toString());
                                    pasProBusCli.setCreatedAt(LocalDateTime.now());
                                    pasProBusCli.setAmount(pasiveProductBusinessClientrequest.getAmount());
                                    //pasiveProductBusinessClient.setAccountNumber("GenerateNumberAccount"); //Generate number account
                                    pasProBusCli.setOpeningDate(LocalDateTime.now());
                                    pasProBusCli.setIdBusinessClient(pasiveProductBusinessClientrequest.getIdBusinessClient());
                                    pasProBusCli.setIdPasiveProduct(pasiveProductBusinessClientrequest.getIdPasiveProduct());
                                    pasProBusCli.setBusinessClient(businessClientResponse);
                                    pasProBusCli.setPasiveProduct(pasiveProductResponse);
                                    pasProBusCli.setHolders(pasiveProductBusinessClientrequest.getHolders());
                                    pasProBusCli.setSigners(pasiveProductBusinessClientrequest.getSigners());

                                    if(pasiveProductResponse.getAllowBusinessClient() && pasiveProductResponse.getName().equals(PasiveProductType.CORRIENTE.name()) && !pasProBusCli.getHolders().isEmpty()){
                                        return pasiveProductBusinessClientRepository.save(pasProBusCli);
                                    }
                                    return null;
                                })
                );
    }

    @Override
    public Mono<PasProBusCli> update(PasProBusCli pasProBusCli) {
        pasProBusCli.setUpdatedAt(LocalDateTime.now());
        return pasiveProductBusinessClientRepository.save(pasProBusCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return pasiveProductBusinessClientRepository.deleteById(id);
    }

    @Override
    public Mono<PasProBusCli> findById(String id) {
        return pasiveProductBusinessClientRepository.findById(id);
    }

    @Override
    public Flux<PasProBusCli> findAll() {
        return pasiveProductBusinessClientRepository.findAll();
    }
}
