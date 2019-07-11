package de.jsfpraxis.detail.el;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.logging.Logger;

import javax.annotation.PreDestroy;
import javax.el.ELContext;
import javax.el.ExpressionFactory;
import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;
import javax.script.ScriptEngine;
import javax.script.ScriptEngineManager;
import javax.script.ScriptException;

@Named("elController")
@RequestScoped
public class ExpressionLanguageController {
	
	private static final Logger log = Logger.getLogger(ExpressionLanguageController.class.getCanonicalName());
	
	private String name = "Übungen mit der Expression-Language";
	
	private Integer year = LocalDate.now().getYear();
	
	private String[] array = new String[]{ "eins", "zwei", "drei" };
	
	private List<Integer> list = Arrays.asList(0, 1, 2, 3, 4, 5, 6, 7, 8, 9);
	
	@SuppressWarnings("serial")
	private Map<String, String> map = new HashMap<String, String>() {{
		put("eins", "Erster Map-Eintrag");
		put("zwei", "Zweiter Map-Eintrag");
		put("drei", "Dritter Map-Eintrag");
	}};
	
	private int i;
	private double d;
	
	private String elInput; // Eingabe eines beliebigen EL-Ausdrucks
	private String elOutput; // und das Ergebnis
	
	private String javascriptInput; // Eingabe eines beliebigen Javascript-Ausdrucks
	private String javascriptOutput; // und das Ergebnis
	
	@Inject
	FacesContext facesContext;

	
	public ExpressionLanguageController() {
	}

	
	public String overloadedMethod(int i) {
		return "overloadMethod(int " + i + ")";
	}
	
	public String overloadedMethod(String str) {
		return "overloadMethod(String " + str + ")";
	}
	
	public String overloadedMethod(String str, int i) {
		return "overloadMethod(String " + str + ", int " + i + ")";
	}
	
	
	public Integer evalEl() {
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		return (Integer) expressionFactory.createValueExpression(el, "#{17 + 4}", Integer.class).getValue(el);
	}
	
	public void evalELInput() {
		if (elInput == null) {
			return;
		}
		Object value = facesContext.getApplication().evaluateExpressionGet(facesContext, "#{" + elInput + "}", Object.class);
		elOutput = value + " vom Typ " + value.getClass().getSimpleName();
	}

	/* Alternative */
	public void evalELInput2() {
		if (elInput == null) {
			return;
		}
		ExpressionFactory expressionFactory = facesContext.getApplication().getExpressionFactory();
		ELContext el = facesContext.getELContext();
		Object value = expressionFactory.createValueExpression(el, "#{" + elInput + "}", Object.class).getValue(el);
		elOutput = value + " vom Typ " + value.getClass().getSimpleName();
	}

	public void evalJavaScriptInput() {
		if (javascriptInput == null) {
			return;
		}
		ScriptEngine engine = new ScriptEngineManager().getEngineByName("nashorn");
		try {
			Object value = engine.eval(javascriptInput);
			javascriptOutput = value + " vom Typ " + value.getClass().getSimpleName();
		} catch (ScriptException e) {
			// TODO Fehlermeldung
			e.printStackTrace();
		}
	}

	
	@PreDestroy
	public void cleanUp() {
		log.info("Wert von 'i' ist jetzt: " + i);
	}
	
	public String getName() {
		return name;
	}

	public Integer getYear() {
		return year;
	}

	public String[] getArray() {
		return array;
	}

	public List<Integer> getList() {
		return list;
	}

	public Map<String, String> getMap() {
		return map;
	}

	public int getI() { 
		return i;
	}
	public void setI(int i) {
		this.i = i;
	}

	public double getD() {
		return d;
	}
	public void setD(double d) {
		this.d = d;
	}

	public String getElInput() {
		return elInput;
	}
	public void setElInput(String elInput) {
		this.elInput = elInput;
	}

	public String getElOutput() {
		return elOutput;
	}

	public String getJavascriptInput() {
		return javascriptInput;
	}
	public void setJavascriptInput(String javascriptInput) {
		this.javascriptInput = javascriptInput;
	}

	public String getJavascriptOutput() {
		return javascriptOutput;
	}
	
}
