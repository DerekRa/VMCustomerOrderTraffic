package com.km.vmcustomerordertraffic.client;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.km.vmcustomerordertraffic.model.ProductItems;

@FeignClient(url="${item.request.url}", name="vendingmachine")
public interface ItemDetailsClient {

	@GetMapping(value="${item.request.api}")
	public ProductItems getItemDetails(@PathVariable int id);
}
