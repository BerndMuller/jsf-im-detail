package de.jsfpraxis.detail.vc;

import java.text.MessageFormat;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class MessageController {
	
	private String text;

	@Inject
	FacesContext context;

	public Map<String, String> bundleForLocaleAsMap(Locale locale) {
		ResourceBundle bundle = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), locale);
		Enumeration<String> keys = ResourceBundle.getBundle(context.getApplication().getMessageBundle(), locale).getKeys();
		Map<String, String> map = new HashMap<>();
		while (keys.hasMoreElements()) {
			String key = (String) keys.nextElement();
			map.put(key, bundle.getString(key));
		}
		return map;
	}
	
	/**
	 * Liste der von Mojarra unterstützten Locales.
	 * 
	 * <p>
	 * Für Payara 5 im Verzeichnis <code>&lt;PAYARA5&gt;/glassfish/modules</code> den Befehl
	 * <code>unzip -l javax.faces.jar | grep javax/faces/Messages_</code> ausführen.
	 * 
	 * <p>
	 * Für WildFly 13 im Verzeichnis <code>&lt;WILDFLY13&gt;/modules/system/layers/base/javax/faces/api/main</code> den Befehl
	 * <code>unzip -l jboss-jsf-api_2.3_spec-2.3.5.SP1.jar | grep javax/faces/Messages_</code> ausführen.
	 * 
	 * @return Liste der von Mojarra unterstützen Locales
	 */
	public List<Locale> supportedLocales() {
		List<Locale> locales = new ArrayList<>();
		locales.add(new Locale("de"));
		locales.add(new Locale("en"));
		locales.add(new Locale("es"));
		locales.add(new Locale("fr"));
		locales.add(new Locale("ja"));
		locales.add(new Locale("ko"));
		locales.add(new Locale("pt", "BR"));
		locales.add(new Locale("zh", "CN"));
		locales.add(new Locale("zh", "HK"));
		locales.add(new Locale("zh", "TW"));
		return locales;
	}

	
	public void addMessage() {
		String messageWithParameters = "Das ist eine {0} Nachricht {1}";
		
		MessageFormat messageFormat = new MessageFormat(messageWithParameters);
		String message = messageFormat.format(new String[] {"parametrisierte", "!"});
		
		System.out.println("message: " + message);

		FacesMessage facesMessage = new FacesMessage(FacesMessage.SEVERITY_INFO, message, message + " und zwar detailliert");
		
		context.addMessage("form:label", facesMessage);

	}

	// Getter und Setter
	public String getText() {
		return text;
	}
	public void setText(String text) {
		this.text = text;
	}

}
