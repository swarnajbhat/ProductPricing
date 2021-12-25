package com.assignment.productpricing.controller;

import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;

import java.math.BigDecimal;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.web.servlet.MockMvc;

import com.assignment.productpricing.model.PricingInfo;
import com.assignment.productpricing.service.ProductPricingService;



@ExtendWith(MockitoExtension.class)
@WebMvcTest(ProductPricingController.class)
public class ProductPricingControllerTest {

	@Autowired
	private MockMvc mockmvc;
	
	@MockBean
	private ProductPricingService service;
	
	@Test
	public void testGetPriceByProductId() throws Exception {
		PricingInfo pricingInfo = new PricingInfo();
		pricingInfo.setCurrencyCode("USD");
		pricingInfo.setId("1234");
		pricingInfo.setUnitPrice(BigDecimal.valueOf(13.84));
		
		Mockito.when(service.getProductPriceById(Mockito.anyString())).thenReturn(pricingInfo);
		
		mockmvc.perform(get("/api/v1/pricing/{id}",123))
		.andExpect(jsonPath("$.unitPrice").value("13.84"));
		
	}
}
