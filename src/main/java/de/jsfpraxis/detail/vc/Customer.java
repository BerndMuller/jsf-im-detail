package de.jsfpraxis.detail.vc;

import java.time.LocalDate;

import javax.validation.constraints.Email;
import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Einfacher Kunde.
 * 
 * @author Bernd Müller
 *
 */
public class Customer {
	
	@NotNull
	@Size(min=3, max=30)
	private String firstName;
	
	@NotNull
	@Size(min=3, max=30)
	private String lastName;
	
	@NotNull
	@Past
	private LocalDate dob;
	
	@NotNull
	@Positive
	@Max(1000)
	private Integer creditLine;
	
	@NotNull
	@Email
	private String email;
	
	public Customer() {
	}
	
	@Override
	public String toString() {
		return "Customer [firstName=" + firstName + ", lastName=" + lastName + ", dob=" + dob + ", creditLine=" + creditLine + ", email=" + email + "]";
	}

	// Getter und Setter
	public String getFirstName() {
		return firstName;
	}
	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}
	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public LocalDate getDob() {
		return dob;
	}
	public void setDob(LocalDate dob) {
		this.dob = dob;
	}

	public Integer getCreditLine() {
		return creditLine;
	}
	public void setCreditLine(Integer creditLine) {
		this.creditLine = creditLine;
	}

	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
