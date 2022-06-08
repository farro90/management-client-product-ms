package com.nttdata.bc19.msmanagementclientproduct.webclient;

import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.ActiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.BusinessClient;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.PasiveProduct;
import com.nttdata.bc19.msmanagementclientproduct.model.responseWC.PersonClient;
import reactor.core.publisher.Mono;

public interface IServiceWC {
    Mono<PersonClient> findPersonClientById(String id);

    Mono<BusinessClient> findBusinessClientById(String id);

    Mono<PasiveProduct> findPasiveProductById(String id);

    Mono<ActiveProduct> findActiveProductById(String id);
}
