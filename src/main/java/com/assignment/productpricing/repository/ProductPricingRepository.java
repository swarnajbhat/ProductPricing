package com.assignment.productpricing.repository;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.stereotype.Repository;

import com.assignment.productpricing.model.PricingInfo;

@Repository
public interface ProductPricingRepository extends MongoRepository<PricingInfo,String>{

}
