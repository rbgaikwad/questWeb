package com.sampleproject.learnspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.sampleproject.learnspringboot.model.Address;

@Repository
public interface AddressRepository extends JpaRepository<Address, Long>{
}
