package com.nttdata.bc19.msmanagementclientproduct.service.impl;

import com.nttdata.bc19.msmanagementclientproduct.model.PasProPerCli;
import com.nttdata.bc19.msmanagementclientproduct.repository.IPasProPerCliRepository;
import com.nttdata.bc19.msmanagementclientproduct.request.PasProPerCliRequest;
import com.nttdata.bc19.msmanagementclientproduct.service.IPasProPerCliService;
import com.nttdata.bc19.msmanagementclientproduct.util.PasiveProductType;
import com.nttdata.bc19.msmanagementclientproduct.webclient.impl.ServiceWCImpl;
import org.bson.types.ObjectId;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.time.LocalDateTime;

@Service
public class PasProPerCliSerImpl implements IPasProPerCliService {

    @Autowired
    IPasProPerCliRepository pasiveProductPersonClientRepository;

    @Autowired
    private ServiceWCImpl clientServiceWC;

    @Override
    public Mono<PasProPerCli> create(PasProPerCliRequest pasProPerCliRequest) {

        return clientServiceWC.findPersonClientById(pasProPerCliRequest.getIdPersonClient())
                .switchIfEmpty(Mono.error(new Exception()))
                .flatMap(personClientResponse ->
                    clientServiceWC.findPasiveProductById(pasProPerCliRequest.getIdPasiveProduct())
                        .switchIfEmpty(Mono.error(new Exception()))
                        .flatMap(pasiveProductResponse -> {
                            PasProPerCli pasProPerCli = new PasProPerCli();
                            pasProPerCli.setId(new ObjectId().toString());
                            pasProPerCli.setCreatedAt(LocalDateTime.now());
                            pasProPerCli.setAmount(pasProPerCliRequest.getAmount());
                            //pasiveProductPersonClient.setAccountNumber("GenerateNumberAccount"); //Generate number account
                            pasProPerCli.setOpeningDate(LocalDateTime.now());
                            pasProPerCli.setIdPersonClient(pasProPerCliRequest.getIdPersonClient());
                            pasProPerCli.setIdPasiveProduct(pasProPerCliRequest.getIdPasiveProduct());
                            pasProPerCli.setPersonClient(personClientResponse);
                            pasProPerCli.setPasiveProduct(pasiveProductResponse);

                            long numAhorro = pasiveProductPersonClientRepository.findByIdPersonClient(pasProPerCli.getPersonClient().getId()).toStream().filter(x -> x.getPasiveProduct().getName().equals(PasiveProductType.AHORRO.name())).count();
                            long numCorriente = pasiveProductPersonClientRepository.findByIdPersonClient(pasProPerCli.getPersonClient().getId()).toStream().filter(x -> x.getPasiveProduct().getName().equals(PasiveProductType.CORRIENTE.name())).count();
                            long numPlazoFijo = pasiveProductPersonClientRepository.findByIdPersonClient(pasProPerCli.getPersonClient().getId()).toStream().filter(x -> x.getPasiveProduct().getName().equals(PasiveProductType.PLAZOFIJO.name())).count();

                            boolean validateClientPersonPasiveProduct = (pasiveProductResponse.getName().equals(PasiveProductType.AHORRO.name()) && numAhorro == 0)
                                                                        || (pasiveProductResponse.getName().equals(PasiveProductType.CORRIENTE.name()) && numCorriente == 0)
                                                                        || (pasiveProductResponse.getName().equals(PasiveProductType.PLAZOFIJO.name()) && numPlazoFijo == 0);

                            if(pasiveProductResponse.getAllowPersonClient() && validateClientPersonPasiveProduct){
                                return pasiveProductPersonClientRepository.save(pasProPerCli);
                            }
                            return null;
                        })
                );
    }

    @Override
    public Mono<PasProPerCli> update(PasProPerCli pasProPerCli) {
        pasProPerCli.setUpdatedAt(LocalDateTime.now());
        return pasiveProductPersonClientRepository.save(pasProPerCli);
    }

    @Override
    public Mono<Void> deleteById(String id) {
        return pasiveProductPersonClientRepository.deleteById(id);
    }

    @Override
    public Mono<PasProPerCli> findById(String id) {
        return pasiveProductPersonClientRepository.findById(id);
    }

    @Override
    public Flux<PasProPerCli> findAll() {
        return pasiveProductPersonClientRepository.findAll();
    }
}
