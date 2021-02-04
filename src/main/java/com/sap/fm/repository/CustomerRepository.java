package com.sap.fm.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sap.fm.entity.Customer;

@Repository
public interface CustomerRepository extends JpaRepository<Customer, Long>{

}
