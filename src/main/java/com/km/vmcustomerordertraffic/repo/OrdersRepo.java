package com.km.vmcustomerordertraffic.repo;

import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.km.vmcustomerordertraffic.model.CustomerOrder;

public interface OrdersRepo extends JpaRepository<CustomerOrder, Integer>{

	Optional<CustomerOrder> findCustomerOrderById(int id);
	
	@Query( value = "SELECT * FROM CUSTOMER_ORDER co WHERE co.customer_id = ?", nativeQuery = true)
	Optional<List<CustomerOrder>> findCustomerOrdersByCustomer_Id(int id);
	
	void deleteByItemId(int itemId);
}
