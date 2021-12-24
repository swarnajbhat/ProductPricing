package com.assignment.productpricing.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.assignment.productpricing.exception.ResourceNotFoundException;
import com.assignment.productpricing.model.PricingInfo;
import com.assignment.productpricing.repository.ProductPricingRepository;

@Service
public class ProductPricingService {

	@Autowired
	private ProductPricingRepository repository;
	
	public PricingInfo getProductPriceById(String id) throws ResourceNotFoundException {
		PricingInfo pricingInfo = repository.findById(id).orElseThrow(() -> new ResourceNotFoundException(" Resource not found"));
		return pricingInfo;
	}
	
	public PricingInfo updateProductPricing(String id, PricingInfo pricingInfo) throws ResourceNotFoundException { 
		Optional<PricingInfo> currentPrice = repository.findById(id);
		if(currentPrice.isPresent()) { 
			PricingInfo newInfo = currentPrice.get();
			newInfo.setCurrencyCode(pricingInfo.getCurrencyCode());
			newInfo.setUnitPrice(pricingInfo.getUnitPrice());
			return(repository.save(newInfo));
		}
		else {
			throw new ResourceNotFoundException("Resource not found");
		}
	}
}
