package de.jsfpraxis.detail.ajax;

import java.io.Serializable;
import java.util.List;
import java.util.Locale;
import java.util.logging.Logger;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import javax.annotation.PostConstruct;
import javax.faces.event.AjaxBehaviorEvent;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named("lsc")
@ViewScoped
public class LocalizationSelectionController implements Serializable {
	
	private static final Logger logger = Logger.getLogger(LocalizationSelectionController.class.getCanonicalName());
	private static final long serialVersionUID = 1L;
	
	private List<String> locales;
	
	private String language; // UI selected language
	private String locale;   // UI selected locale
	
	
	public LocalizationSelectionController() {

	}
	
	public void languageChanged(AjaxBehaviorEvent event) {
		logger.info("Language selection changed: " + language);
	}
	
	public void localeChanged(AjaxBehaviorEvent event) {
		logger.info("Locale selection changed: " + locale);
	}
	

	/**
	 * All languages from available locales.
	 * 
	 * @return All languages
	 */
	public List<String> languages() {
		return locales.stream().filter(str -> str.length() == 2).collect(Collectors.toList());
	}
	
	/**
	 * All locales for a language.
	 * 
	 * @param language The language of the locale to search for
	 * @return All locales
	 */
	public List<String> locales(String language) {
		logger.info("language: >" + language + "<");
		if (language.isEmpty()) {
			return List.of("zuerst Sprache wählen");
		}
		return locales.stream().filter(str -> str.startsWith(language)).collect(Collectors.toList());
	}

	@PostConstruct
	public void init() {
		locales = Stream.of(Locale.getAvailableLocales())
			.map(l -> l.toString())
			.filter(s -> !s.isEmpty())
			.sorted()
			.collect(Collectors.toList());
	}

	
	// Getter and Setter
	public String getLanguage() {
		return language;
	}
	public void setLanguage(String language) {
		this.language = language;
	}

	public String getLocale() {
		return locale;
	}
	public void setLocale(String locale) {
		this.locale = locale;
	}
	
}
