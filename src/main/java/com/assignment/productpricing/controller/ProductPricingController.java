package com.assignment.productpricing.controller;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.productpricing.exception.ResourceNotFoundException;
import com.assignment.productpricing.model.PricingInfo;
import com.assignment.productpricing.service.ProductPricingService;

@RestController
@RequestMapping("/api/v1")
public class ProductPricingController {

	@Autowired
	private ProductPricingService service;
	
	
	/*
	 * this method returns pricing information for the id passed in the request
	 * @Param : id
	 * @Return: PricingInfo object for the id passed
	 */
	@GetMapping("/pricing/{id}")
	public PricingInfo getPriceByProductId(@PathVariable String id) throws ResourceNotFoundException {
		PricingInfo pricingInfo = service.getProductPriceById(id);
		return pricingInfo;
	}
	
	/*
	 * this method updates pricing information for the id passed in the request
	 * @Param : id
	 * @Param: PricingInfo object
	 * @Return: updated PricingInfo object for the id passed
	 */
	@PutMapping("/pricing/{id}")
	public PricingInfo updatePricingInfoForProductId(@Valid @RequestBody PricingInfo pricingInfo,@PathVariable String id) throws ResourceNotFoundException {
		PricingInfo pricingInfoSaved = service.updateProductPricing(id, pricingInfo);
		return pricingInfoSaved;
	}
}
