package com.sampleproject.learnspringboot.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "address")
public class Address {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private long address_id;

	private Integer house_no;
	private String street_add;
	private String state;
	private String country;
	private String pincode;

	private Integer userId;

	public Integer getUserId() {
		return userId;
	}

	public void setUserId(Integer userId) {
		this.userId = userId;
	}

	public Address() {
	}

	public Address(long address_id, Integer house_no, String street_add, String state, String country, String pincode) {
		super();
		this.address_id = address_id;
		this.house_no = house_no;
		this.street_add = street_add;
		this.state = state;
		this.country = country;
		this.pincode = pincode;
	}

	public long getAddress_id() {
		return address_id;
	}

	public void setAddress_id(long address_id) {
		this.address_id = address_id;
	}

	public Integer getHouse_no() {
		return house_no;
	}

	public void setHouse_no(Integer house_no) {
		this.house_no = house_no;
	}

	public String getStreet_add() {
		return street_add;
	}

	public void setStreet_add(String street_add) {
		this.street_add = street_add;
	}

	public String getState() {
		return state;
	}

	public void setState(String state) {
		this.state = state;
	}

	public String getCountry() {
		return country;
	}

	public void setCountry(String country) {
		this.country = country;
	}

	public String getPincode() {
		return pincode;
	}

	public void setPincode(String pincode) {
		this.pincode = pincode;
	}

}
