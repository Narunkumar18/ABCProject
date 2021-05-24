package com.airbus.pojos;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;


/**
 * The persistent class for the UNAUTHORIZEDTICKET database table.
 * 
 */
@Entity
@Table(name="unauthorizedticket")
public class UnAuthorizedTicket  {

	@Id
	//@GeneratedValue
	@Column(name="UNAUTHID")
	private Integer unAuthId;
	
	@Column(name="EMAIL")
	private String email;
	
	@Column(name="PHONE")
	private Long phone;
	
	
	@ManyToOne
	@JoinColumn(name="TICKETNUMBER")
	private Reservation reservation;
	

	
	public UnAuthorizedTicket() {
		super();
		System.out.println("unAuthorized ticket is called");
	}
	
	public void setUnAuthId(Integer unAuthId) {
		this.unAuthId = unAuthId;
	}
	
	public Integer getUnAuthId() {
		return this.unAuthId;
	}


	public String getEmail() {
		return email;
	}


	public void setEmail(String email) {
		this.email = email;
	}


	public Long getPhone() {
		return phone;
	}

	public void setPhone(Long phone) {
		this.phone = phone;
	}
@JsonIgnore
	public Reservation getReservation() {
		return reservation;
	}

	public void setReservation(Reservation reservation) {
		this.reservation = reservation;
	}

}