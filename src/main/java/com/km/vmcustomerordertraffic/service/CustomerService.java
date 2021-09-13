package com.km.vmcustomerordertraffic.service;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.transaction.Transactional;

import org.springframework.stereotype.Service;

import com.km.vmcustomerordertraffic.exception.NotFoundException;
import com.km.vmcustomerordertraffic.model.CustomerInfo;
import com.km.vmcustomerordertraffic.model.CustomerOrder;
import com.km.vmcustomerordertraffic.repo.CustomerRepo;
import com.km.vmcustomerordertraffic.repo.OrdersRepo;

@Service
@Transactional
public class CustomerService {
	private static final String WNF = " was not found"; 
	
	CustomerRepo customerRepo;
	OrdersRepo ordersRepo;
	
	public CustomerService(CustomerRepo customerRepo, OrdersRepo ordersRepo) {
		super();
		this.customerRepo = customerRepo;
		this.ordersRepo = ordersRepo;
	}
	
	public List<CustomerInfo> getAllCustomerDetails(){
		return customerRepo.findAll();
	}
	
	public List<CustomerOrder> getAllCustomerOrders(){
		return ordersRepo.findAll();
	}
	
	public CustomerInfo getCustomerDetails(int id) {
		return customerRepo.findCustomerDetailsById(id)
				.orElseThrow(() -> new NotFoundException("Customer id "+ id + WNF));
	}
	
	public CustomerOrder getCustomerOrder(int id) {
		return ordersRepo.findCustomerOrderById(id)
				.orElseThrow(() -> new NotFoundException("Customer id "+ id + WNF));
	}
	
	public List<CustomerOrder> getCustomerOrders(int id) {
		return ordersRepo.findCustomerOrdersByCustomer_Id(id)
				.orElseThrow(() -> new NotFoundException("Customer id "+ id + WNF));
	}
	
	public CustomerInfo getCustomerDetailsByGC(String gc) {
		return customerRepo.findCustomerDetailsByGenerateCode(gc)
				.orElseThrow(() -> new NotFoundException("Customer generate code "+ gc + WNF));
	}
	
	public CustomerInfo addCustomerInfo(CustomerInfo customerInfo) {
		customerInfo.setGenerateCode(UUID.randomUUID().toString());
		customerInfo.setStatus("Active");
		customerInfo.setDateAdded(new Date());
		return customerRepo.save(customerInfo);
	}
	
	public CustomerOrder addCustomerOrder(CustomerOrder customerOrder) {
		customerOrder.setDateAdded(new Date());
		return ordersRepo.save(customerOrder);
	}
	
	public CustomerInfo updateCustomerInfo(CustomerInfo customerInfo) {
		return customerRepo.save(customerInfo);
	}
	
	public void deleteCustomerById(int id) {
		customerRepo.deleteById(id);
	}
	
	public void deleteCustomerOrderById(int itemId) {
		ordersRepo.deleteByItemId(itemId);
	}
}
