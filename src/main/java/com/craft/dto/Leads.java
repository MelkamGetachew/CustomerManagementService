package com.craft.dto;

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
public class Leads {
	private String leadId;
	private String firstName;
	private String lastName;
	private String email;
	private String phoneNumber;
	private String company;
	private String status;
	private String source;
	private String industry;
	private int leadScore;

}
