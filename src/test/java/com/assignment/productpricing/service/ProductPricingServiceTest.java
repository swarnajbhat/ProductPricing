package com.assignment.productpricing.service;

import java.math.BigDecimal;
import java.util.Optional;

import org.assertj.core.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;

import com.assignment.productpricing.exception.ResourceNotFoundException;
import com.assignment.productpricing.model.PricingInfo;
import com.assignment.productpricing.repository.ProductPricingRepository;


@ExtendWith(MockitoExtension.class)
public class ProductPricingServiceTest {

	@Mock
	private ProductPricingRepository repository;
	
	@InjectMocks
	private ProductPricingService service;
	
	@Test
	public void testGetProductPriceById() throws ResourceNotFoundException {
		PricingInfo pricingInfo = new PricingInfo();
		pricingInfo.setCurrencyCode("USD");
		pricingInfo.setId("1234");
		pricingInfo.setUnitPrice(BigDecimal.valueOf(13.84));
		
		Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(pricingInfo));
		
		PricingInfo price = service.getProductPriceById("123");
		
		Assertions.assertThat(price.getUnitPrice().equals(BigDecimal.valueOf(13.84)));
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyString());
		
	}
	
	
	@Test
	public void testupdateProductPricing() throws ResourceNotFoundException {
		PricingInfo pricingInfo = new PricingInfo();
		pricingInfo.setCurrencyCode("USD");
		pricingInfo.setId("1234");
		pricingInfo.setUnitPrice(BigDecimal.valueOf(13.84));
		
		PricingInfo updatedpricingInfo = new PricingInfo();
		updatedpricingInfo.setCurrencyCode("USD");
		updatedpricingInfo.setUnitPrice(BigDecimal.valueOf(14.84));
		
		Mockito.when(repository.findById(Mockito.anyString())).thenReturn(Optional.ofNullable(pricingInfo));
		
		Mockito.when(repository.save(Mockito.any())).thenReturn(updatedpricingInfo);
		
		PricingInfo actualUpdatedPrice = service.updateProductPricing("1234", updatedpricingInfo);
		
		Assertions.assertThat(actualUpdatedPrice.getUnitPrice().equals(BigDecimal.valueOf(14.84)));
		Mockito.verify(repository, Mockito.times(1)).findById(Mockito.anyString());
		Mockito.verify(repository, Mockito.times(1)).save(Mockito.any());
		
	}
	
	
}
