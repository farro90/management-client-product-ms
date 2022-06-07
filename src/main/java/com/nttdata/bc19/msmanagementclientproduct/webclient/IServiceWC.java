package com.nttdata.bc19.msmanagementclientproduct.webclient;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.BusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.PersonClient;
import reactor.core.publisher.Mono;

public interface IServiceWC {
    Mono<PersonClient> findPersonClientById(String id);

    Mono<BusinessClient> findBusinessClientById(String id);

    Mono<PasiveProduct> findPasiveProductById(String id);

    Mono<ActiveProduct> findActiveProductById(String id);
}
