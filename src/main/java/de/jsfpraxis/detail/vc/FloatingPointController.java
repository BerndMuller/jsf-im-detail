package de.jsfpraxis.detail.vc;

import java.math.BigDecimal;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("floats")
@RequestScoped
public class FloatingPointController {
	
	private Float floatValue;
	private Double doubleValue;
	private BigDecimal bigDecimalValue;
	
	public FloatingPointController() {
		floatValue = 0.0F;
		doubleValue = 0.0;
		bigDecimalValue = new BigDecimal("0.0");
	}

	public String submit() {
		return null;
	}
	
	public Float getFloatValueSquare() {
		return floatValue * floatValue;
	}
	
	public Double getDoubleValueSquare() {
		return doubleValue * doubleValue;
	}
	
	public BigDecimal getBigDecimalValueSquare() {
		return bigDecimalValue.multiply(bigDecimalValue);
	}
	
	
	// Getter und Setter
	public BigDecimal getBigDecimalValue() {
		return bigDecimalValue;
	}

	public void setBigDecimalValue(BigDecimal bigDecimalValue) {
		this.bigDecimalValue = bigDecimalValue;
	}

	public Double getDoubleValue() {
		return doubleValue;
	}

	public void setDoubleValue(Double doubleValue) {
		this.doubleValue = doubleValue;
	}

	public Float getFloatValue() {
		return floatValue;
	}

	public void setFloatValue(Float floatValue) {
		this.floatValue = floatValue;
	}



}
