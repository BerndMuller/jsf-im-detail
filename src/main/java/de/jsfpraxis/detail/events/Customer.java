package de.jsfpraxis.detail.events;

import javax.validation.constraints.NotNull;

public class Customer {

	@NotNull
	private String firstname;
	
	@NotNull
	private String lastname;

	public Customer() {
	}

	
	// Getter und Setter
	public String getFirstname() {
		return firstname;
	}
	public void setFirstname(String firstname) {
		this.firstname = firstname;
	}

	public String getLastname() {
		return lastname;
	}
	public void setLastname(String lastname) {
		this.lastname = lastname;
	}
	
}
