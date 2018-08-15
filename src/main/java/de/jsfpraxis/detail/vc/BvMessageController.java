package de.jsfpraxis.detail.vc;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Enumeration;
import java.util.HashMap;
import java.util.List;
import java.util.Locale;
import java.util.Map;
import java.util.ResourceBundle;

import javax.enterprise.context.RequestScoped;
import javax.faces.context.FacesContext;
import javax.inject.Inject;
import javax.inject.Named;

@Named
@RequestScoped
public class BvMessageController {
	
	private static final List<String> keys = Arrays.asList(new String[] { // Quelle: Appendix B: Standard ResourceBundle messages, BV 2.0, JSR 380
			"javax.validation.constraints.AssertFalse.message",
			"javax.validation.constraints.AssertTrue.message",
			"javax.validation.constraints.DecimalMax.message",
			"javax.validation.constraints.DecimalMin.message",
			"javax.validation.constraints.Digits.message",
			"javax.validation.constraints.Email.message",
			"javax.validation.constraints.Future.message",
			"javax.validation.constraints.FutureOrPresent.message",
			"javax.validation.constraints.Max.message",
			"javax.validation.constraints.Min.message",
			"javax.validation.constraints.Negative.message",
			"javax.validation.constraints.NegativeOrZero.message",
			"javax.validation.constraints.NotBlank.message",
			"javax.validation.constraints.NotEmpty.message",
			"javax.validation.constraints.NotNull.message",
			"javax.validation.constraints.Null.message",
			"javax.validation.constraints.Past.message",
			"javax.validation.constraints.PastOrPresent.message",
			"javax.validation.constraints.Pattern.message",
			"javax.validation.constraints.Positive.message",
			"javax.validation.constraints.PositiveOrZero.message",
			"javax.validation.constraints.Size.message"
		});

	
	
	@Inject
	FacesContext context;

	
	public BvMessageController() {
	}


	public Map<String, String> bundleForLocaleAsMap(Locale locale) {
		ResourceBundle bvBundle = ResourceBundle.getBundle("org.hibernate.validator.ValidationMessages", locale);
		Enumeration<String> bvKeys = bvBundle.getKeys();
		Map<String, String> map = new HashMap<>();
		while (bvKeys.hasMoreElements()) {
			String key = bvKeys.nextElement();
			if (keys.contains(key)) {
				map.put(key, bvBundle.getString(key));
			}
		}
		return map;
	}
	
	
	/**
	 * Liste der von Hibernate-Validator unterstützten Locales.
	 * 
	 * <p>
	 * Für Payara 5 im Verzeichnis <code>&lt;PAYARA5&gt;/glassfish/modules</code> den Befehl
	 * <code>unzip -l hibernate-validator.jar | grep org/hibernate/validator/ValidationMessages_</code> ausführen.
	 * 
	 * <p>
	 * Für WildFly 13 im Verzeichnis <code>&lt;WILDFLY13&gt;/modules/system/layers/base/org/hibernate/validator/main</code> den Befehl
	 * <code>unzip -l hibernate-validator-6.0.10.Final.jar | grep org/hibernate/validator/ValidationMessages_</code> ausführen.
	 * 
	 * @return Liste der von Hibernate-Validator unterstützen Locales
	 */
	public List<Locale> supportedLocales() {
		List<Locale> locales = new ArrayList<>();
		locales.add(new Locale("de"));
		locales.add(new Locale("en"));
		locales.add(new Locale("uk"));
		locales.add(new Locale("ko"));
		locales.add(new Locale("es"));
		locales.add(new Locale("fr"));
		locales.add(new Locale("sk"));
		locales.add(new Locale("tr"));
		locales.add(new Locale("nl"));
		locales.add(new Locale("cs"));
		locales.add(new Locale("pt"));
		locales.add(new Locale("fa"));
		locales.add(new Locale("hu"));
		locales.add(new Locale("ar"));
		locales.add(new Locale("ru"));
		locales.add(new Locale("pt", "BR"));
		locales.add(new Locale("mn", "MN"));
		locales.add(new Locale("zh", "CN"));
		return locales;
	}

}
