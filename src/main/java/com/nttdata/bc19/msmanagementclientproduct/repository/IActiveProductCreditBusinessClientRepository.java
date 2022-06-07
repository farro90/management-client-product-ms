package com.nttdata.bc19.msmanagementclientproduct.repository;

import com.nttdata.bc19.msmanagementclientproduct.model.ActiveProductCreditBusinessClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IActiveProductCreditBusinessClientRepository extends ReactiveMongoRepository<ActiveProductCreditBusinessClient, String> {
}
