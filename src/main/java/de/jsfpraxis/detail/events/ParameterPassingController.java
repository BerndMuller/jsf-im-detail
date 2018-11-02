package de.jsfpraxis.detail.events;

import java.util.Map;

import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.enterprise.context.RequestScoped;
import javax.faces.annotation.RequestParameterMap;
import javax.faces.context.FacesContext;
import javax.faces.event.ActionEvent;
import javax.inject.Inject;
import javax.inject.Named;


/**
 * Verschiede Arten der Parameterübergabe.
 * 
 * @author Bernd Müller
 *
 */
@Named("pp")
@RequestScoped
public class ParameterPassingController {

	private static final int ROWS = 4;
	
	private Integer[] operands1;
	private Integer[] operands2;
	private Integer[] results;
	
	private String operator; // injected by <f:setPropertyActionListener>
	
	@Inject
	FacesContext facesContext;
	
	@Inject
	@RequestParameterMap
	Map<String, String> requestParams;
	
	public ParameterPassingController() {
		operands1 = new Integer[ROWS];
		operands2 = new Integer[ROWS];
		results = new Integer[ROWS];
	}
	
	/**
	 * The method called with simple EL method parameter.
	 * 
	 * @param operator The operatator to use
	 * @throws Exception If EL syntax is wrong.
	 */
	public void actionWithMethodParam(String operator) throws Exception {
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[0] + operator + operands2[0] + "}", Object.class).getValue(el);
		results[0] = value.intValue();
	}
	
	public void actionWithFSetPropertyActionListener() {
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[1] + operator + operands2[1] + "}", Object.class).getValue(el);
		results[1] = value.intValue();
	}
	
	public void actionWithFParam() throws Exception {
		String operator = requestParams.get("operator");
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[2] + operator + operands2[2] + "}", Object.class).getValue(el);
		results[2] = value.intValue();
	}
	
	public void actionListenerWithFAttribute(ActionEvent ae) {
		String operator = (String) ae.getComponent().getAttributes().get("operator");
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[3] + operator + operands2[3] + "}", Object.class).getValue(el);
		results[3] = value.intValue();
	}
	

	
	// Getter und Setter
	public Integer[] getOperands1() {
		return operands1;
	}
	public void setOperands1(Integer[] operands1) {
		this.operands1 = operands1;
	}

	public Integer[] getOperands2() {
		return operands2;
	}
	public void setOperands2(Integer[] operands2) {
		this.operands2 = operands2;
	}

	public Integer[] getResults() {
		return results;
	}
	public void setResults(Integer[] results) {
		this.results = results;
	}

	public String getOperator() {
		return operator;
	}
	public void setOperator(String operator) {
		this.operator = operator;
	}
	
}
