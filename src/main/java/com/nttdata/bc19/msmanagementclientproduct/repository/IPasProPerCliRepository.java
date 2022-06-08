package com.nttdata.bc19.msmanagementclientproduct.repository;

import com.nttdata.bc19.msmanagementclientproduct.model.PasProPerCli;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;

@Repository
public interface IPasProPerCliRepository extends ReactiveMongoRepository<PasProPerCli, String> {
    Flux<PasProPerCli> findByIdPersonClient(String id);
}
