package com.sampleproject.learnspringboot.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.CrudRepository;

import com.sampleproject.learnspringboot.model.Address;

public interface AddressRepository extends CrudRepository<Address, Integer>{

}
