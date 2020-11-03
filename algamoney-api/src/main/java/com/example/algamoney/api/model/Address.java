package com.example.algamoney.api.model;

import javax.persistence.Embeddable;
import javax.validation.constraints.Size;

@Embeddable
public class Address {
	@Size(max = 30)
	private String number;
	
	private String place;
	
	private String complement;
	
	private String neighborhood;
	
	@Size(min  = 8, max = 8)
	private String cep;
	
	@Size(min  = 3, max = 30)
	private String city;
	
	@Size(min  = 2, max = 30)
	private String state;
	
	public String getNumber() {
		return number;
	}
	
	public void setNumber(String number) {
		this.number = number;
	}
	
	public String getPlace() {
		return place;
	}
	
	public void setPlace(String place) {
		this.place = place;
	}
	
	public String getComplement() {
		return complement;
	}
	
	public void setComplement(String complement) {
		this.complement = complement;
	}
	
	public String getNeighborhood() {
		return neighborhood;
	}
	
	public void setNeighborhood(String neighborhood) {
		this.neighborhood = neighborhood;
	}
	
	public String getCep() {
		return cep;
	}
	
	public void setCep(String cep) {
		this.cep = cep;
	}
	
	public String getCity() {
		return city;
	}
	
	public void setCity(String city) {
		this.city = city;
	}
	
	public String getState() {
		return state;
	}
	
	public void setState(String state) {
		this.state = state;
	}
	
}
