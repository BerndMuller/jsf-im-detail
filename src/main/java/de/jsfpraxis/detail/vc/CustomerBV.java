package de.jsfpraxis.detail.vc;

import java.time.LocalDate;

import javax.validation.constraints.Max;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Past;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

/**
 * Einfacher Kunde für anwendungsdefinierte Constraints und Gruppenvalidierung.
 * 
 * @author Bernd Müller
 *
 */
public class CustomerBV {
	
	@NotNull
	@Size(min=3, max=30)
	private String name;
	
	@NotNull
	@Past(groups = NichtVolljaehrigGruppe.class)
	@Volljaehrig(groups = VolljaehrigGruppe.class)
	private LocalDate dob;
	
	@NotNull(groups = NichtVolljaehrigGruppe.class)
	@Positive(groups = NichtVolljaehrigGruppe.class)
	@Max(value = 1000, groups = NichtVolljaehrigGruppe.class)
	private Integer creditLine;
	
	public CustomerBV() {
	}
	
	
	
	// Getter und Setter
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
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

	
}
