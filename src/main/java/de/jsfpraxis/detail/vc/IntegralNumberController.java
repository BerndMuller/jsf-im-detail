package de.jsfpraxis.detail.vc;

import java.math.BigInteger;
import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named("integralNumbers")
@RequestScoped
public class IntegralNumberController {
	
	private static Logger log = Logger.getLogger(IntegralNumberController.class.getCanonicalName());
	
	private Byte byteValue;
	private Short shortValue;
	private Integer intValue;
	private Long longValue;
	private BigInteger bigIntValue;
	
	public IntegralNumberController() {
	}


	public String submit() {
		log.info("byteValue:     " + byteValue + "\n" 
				   	+ "shortValue:  " + shortValue + "\n" 
				   	+ "intValue:    " + intValue + "\n" 
				   	+ "longValue:   " + longValue + "\n" 
					+ "bigIntValue: " + bigIntValue);
		return null;
	}

	
	// ab hier nur Getter und Setter
	public Byte getByteValue() {
		return byteValue;
	}

	public void setByteValue(Byte byteValue) {
		this.byteValue = byteValue;
	}
	
	public Integer getIntValue() {
		return intValue;
	}

	public void setIntValue(Integer intValue) {
		this.intValue = intValue;
	}

	public Long getLongValue() {
		return longValue;
	}

	public void setLongValue(Long longValue) {
		this.longValue = longValue;
	}

	public Short getShortValue() {
		return shortValue;
	}

	public void setShortValue(Short shortValue) {
		this.shortValue = shortValue;
	}


	public BigInteger getBigIntValue() {
		return bigIntValue;
	}


	public void setBigIntValue(BigInteger bigIntValue) {
		this.bigIntValue = bigIntValue;
	}

}
