package de.jsfpraxis.detail.events;

import java.util.Map;
import java.util.logging.Logger;

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

	private static final Logger logger = Logger.getLogger(ParameterPassingController.class.getCanonicalName());
	private static final int ROWS = 4;
	
	private Integer[] operands1;
	private Integer[] operands2;
	private Integer[] results;
	
	private String operator; // injected by <f:setPropertyActionListener>
	
	private ParameterPassingController ppc;
	
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
	 * Method called with simple EL method parameter.
	 * 
	 * @param operator The operatator to use
	 * @throws Exception If EL syntax error.
	 */
	public void actionWithMethodParam(String operator) throws Exception {
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[0] + operator + operands2[0] + "}", Long.class).getValue(el);
		results[0] = value.intValue();
	}
	
	/**
	 * Method called with {@code <f:setPropertyActionListener>}.
	 */
	public void actionWithFSetPropertyActionListener() {
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[1] + operator + operands2[1] + "}", Long.class).getValue(el);
		results[1] = value.intValue();
	}

	/**
	 * Method called with {@code <f:param>}.
	 */
	public void actionWithFParam() throws Exception {
		String operator = requestParams.get("operator");
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[2] + operator + operands2[2] + "}", Long.class).getValue(el);
		results[2] = value.intValue();
	}
	
	/**
	 * Method called with {@code <f:attribute>}.
	 */
	public void actionListenerWithFAttribute(ActionEvent ae) {
		String operator = (String) ae.getComponent().getAttributes().get("operator");
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Long value = (Long) expressionFactory.createValueExpression(el, "#{" + operands1[3] + operator + operands2[3] + "}", Long.class).getValue(el);
		results[3] = value.intValue();
	}
	
	
	/**
	 * Method called with EL-Method param, {@code <f:attribute>} and {@code <f:setPropertyActionListener>}.
	 * 
	 * @param ppc The parameter.
	 */
	public void actionMethodWithComplexType(ParameterPassingController ppc)  {
		logger.info("method parameter passed: " + ppc);
		logger.info("property passed: " + this.ppc);
	}
	
	public void actionListenerWithComplexType(ActionEvent ae)  {
		logger.info("attribute passed: " + ae.getComponent().getAttributes().get("ppc"));
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

	public ParameterPassingController getPpc() {
		return ppc;
	}
	public void setPpc(ParameterPassingController ppc) {
		this.ppc = ppc;
	}
	
}
