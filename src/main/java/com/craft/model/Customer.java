package com.craft.model;

import java.util.Date;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@AllArgsConstructor
@ToString
@NoArgsConstructor
@Entity
public class Customer {
	@Id
	private String customerId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String street;
	private String city;
	private String state;
	private String zipcode;
	private String notes;
	private String birthday;
	private String company;

}
