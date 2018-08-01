package de.jsfpraxis.detail.vc;

import java.math.BigDecimal;
import java.util.Arrays;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("formattingNumber")
@RequestScoped
public class FormattingNumberController {
	
	private static final int MAX = 14;
	
	private BigDecimal[] numbers;

	public FormattingNumberController() {
		numbers = new BigDecimal[MAX];
		Arrays.setAll(numbers, i -> new BigDecimal("15233.573"));
	}

	public String submit() {
		return null;
	}
	
	
	// Getter und Setter
	public BigDecimal[] getNumbers() {
		return numbers;
	}
	public void setNumbers(BigDecimal[] numbers) {
		this.numbers = numbers;
	}
	
}
