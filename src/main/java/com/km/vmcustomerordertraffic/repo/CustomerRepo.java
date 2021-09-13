package com.km.vmcustomerordertraffic.repo;

import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.km.vmcustomerordertraffic.model.CustomerInfo;

@Repository
public interface CustomerRepo extends JpaRepository<CustomerInfo, Integer>{

	Optional<CustomerInfo> findCustomerDetailsById(int id);
	
	Optional<CustomerInfo> findCustomerDetailsByGenerateCode(String gc);
	
	void deleteById(int id);
}
