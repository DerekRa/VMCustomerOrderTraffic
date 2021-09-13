package com.km.vmcustomerordertraffic.controller;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.km.vmcustomerordertraffic.client.ItemDetailsClient;
import com.km.vmcustomerordertraffic.model.CustomerInfo;
import com.km.vmcustomerordertraffic.model.CustomerOrder;
import com.km.vmcustomerordertraffic.model.ProductItems;
import com.km.vmcustomerordertraffic.service.CustomerService;

import io.swagger.annotations.ApiOperation;


@RestController
@RequestMapping("/api")
public class CustomerOrderController {
	ItemDetailsClient itemDetailsClient;
	CustomerService customerService;
	
	@Autowired
	public CustomerOrderController(CustomerService customerService, ItemDetailsClient itemDetailsClient) {
		this.customerService = customerService;
		this.itemDetailsClient = itemDetailsClient;
	}

	@GetMapping(value="/all")
	public ResponseEntity<List<CustomerInfo>> getAllCustomerDetails(){
		List<CustomerInfo> customerInfo = customerService.getAllCustomerDetails();
		return new ResponseEntity<>(customerInfo, HttpStatus.OK);
	}
	
	@GetMapping(value="/orders")
	public ResponseEntity<List<CustomerOrder>> getAllCustomerOrders(){
		List<CustomerOrder> customerOrder = customerService.getAllCustomerOrders();
		return new ResponseEntity<>(customerOrder, HttpStatus.OK);
	}
	
	@GetMapping(value="/all/{id}")
	public ResponseEntity<CustomerInfo> getCustomerDetails(@PathVariable("id") int id){
		CustomerInfo customerInfo = customerService.getCustomerDetails(id);
		return new ResponseEntity<>(customerInfo,HttpStatus.OK);
	}
	
	@GetMapping(value="/orders/{id}")
	public ResponseEntity<CustomerOrder> getCustomerOrder(@PathVariable("id") int id){
		CustomerOrder customerOrder = customerService.getCustomerOrder(id);
		return new ResponseEntity<>(customerOrder,HttpStatus.OK);
	}
	
	@GetMapping(value="/customerOrderList/{id}")
	public ResponseEntity<List<CustomerOrder>> getCustomerOrderList(@PathVariable("id") int id){
		List<CustomerOrder> customerOrder = customerService.getCustomerOrders(id);
		return new ResponseEntity<>(customerOrder,HttpStatus.OK);
	}
	
	@GetMapping(value="/gcode/{gc}")
	public ResponseEntity<CustomerInfo> getCustomerDetails(@PathVariable("gc") String gc){
		CustomerInfo customerInfo = customerService.getCustomerDetailsByGC(gc);
		return new ResponseEntity<>(customerInfo,HttpStatus.OK);
	}
	
	@GetMapping(value="/customerOrder/{id}")
	public ResponseEntity<List<ProductItems>> getCustomerOrders(@PathVariable("id") int id){
		CustomerInfo customerInfo = customerService.getCustomerDetails(id);
		List<CustomerOrder> orders = customerInfo.getOrders();
		List<ProductItems> items = new ArrayList<>();
		for (CustomerOrder order : orders) {
			int itemId = order.getItemId();
			ProductItems item = itemDetailsClient.getItemDetails(itemId);
			item.setDateAdded(order.getDateAdded());
			items.add(item);
		}
		return new ResponseEntity<>(items,HttpStatus.OK);
	}
	
	@PostMapping(value="/add")
	public ResponseEntity<CustomerInfo> addCustomerInfo(@RequestBody CustomerInfo customerInfo) throws ParseException{
		CustomerInfo newCustomerInfo = customerService.addCustomerInfo(customerInfo);
		return new ResponseEntity<>(newCustomerInfo, HttpStatus.CREATED);
	}
	
	@PostMapping(value="/addOrder")
	public ResponseEntity<CustomerOrder> addCustomerOrder(@RequestBody CustomerOrder customerOrder) throws ParseException{
		CustomerOrder newCustomerOrder = customerService.addCustomerOrder(customerOrder);
		return new ResponseEntity<>(newCustomerOrder, HttpStatus.CREATED);
	}
	
	@PutMapping(value="/update")
	public ResponseEntity<CustomerInfo> updateCustomerDetails(@RequestBody CustomerInfo customerInfo){
		CustomerInfo newCustomerInfo = customerService.updateCustomerInfo(customerInfo);
				return new ResponseEntity<>(newCustomerInfo, HttpStatus.OK);
	}
	
	@DeleteMapping(value="/forceDelete/{id}")
	@ApiOperation(value="Force Delete a Customer which includes other data connected on Order List",
		notes="This part Force Delete a customer which includes other data connected on Order List - deleteCustomer")
	public ResponseEntity<?> deleteCustomer(@PathVariable("id") int id) throws EmptyResultDataAccessException{
		customerService.deleteCustomerById(id);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	@DeleteMapping(value="/forceDeleteOrder/{itemId}")
	@ApiOperation(value="Force Delete a Customer which includes other data connected on Order List",
	notes="This part Force Delete a customer which includes other data connected on Order List - deleteCustomer")
	public ResponseEntity<?> deleteCustomerOrder(@PathVariable("itemId") int itemId) throws EmptyResultDataAccessException{
		customerService.deleteCustomerOrderById(itemId);
		return new ResponseEntity<>(HttpStatus.OK);
	}
	
	
}
