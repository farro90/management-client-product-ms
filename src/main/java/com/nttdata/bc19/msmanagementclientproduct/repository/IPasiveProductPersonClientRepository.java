package com.nttdata.bc19.msmanagementclientproduct.repository;

import com.nttdata.bc19.msmanagementclientproduct.model.PasiveProductPersonClient;
import org.springframework.data.mongodb.repository.ReactiveMongoRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IPasiveProductPersonClientRepository extends ReactiveMongoRepository<PasiveProductPersonClient, String> {
}
