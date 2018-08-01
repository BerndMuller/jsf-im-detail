package de.jsfpraxis.detail.vc;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.util.Arrays;
import java.util.Date;
import java.util.Locale;

import javax.annotation.PostConstruct;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.inject.Named;

import de.jsfpraxis.detail.i18n.LocaleController;

import java.io.Serializable;

@Named("formattingDateTime")
@RequestScoped
public class FormattingDateTimeController implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private static final int MAX = 10;
	
	private LocalDate[] dates;
	private LocalTime[] times;
	private LocalDateTime[] dateTimes;
	private Date date;
	private Locale locale;

	@Inject
	LocaleController localeController;
	
	public FormattingDateTimeController() {
		dates = new LocalDate[MAX];
		times = new LocalTime[MAX];
		dateTimes = new LocalDateTime[MAX];
		Arrays.setAll(dates, i -> LocalDate.now());
		Arrays.setAll(times, i -> LocalTime.now());
		Arrays.setAll(dateTimes, i -> LocalDateTime.now());
		date = new Date();
	}

	public String submit() {
		localeController.changeLocaleTo(locale);
		return null;
	}
	
	@PostConstruct
	public void init() {
		locale = localeController.getLocale();
	}
	
	
	// Getter und Setter
	public LocalDate[] getDates() {
		return dates;
	}
	public void setDates(LocalDate[] dates) {
		this.dates = dates;
	}

	public LocalTime[] getTimes() {
		return times;
	}
	public void setTimes(LocalTime[] times) {
		this.times = times;
	}

	public LocalDateTime[] getDateTimes() {
		return dateTimes;
	}
	public void setDateTimes(LocalDateTime[] dateTimes) {
		this.dateTimes = dateTimes;
	}

	public Date getDate() {
		return date;
	}
	public void setDate(Date date) {
		this.date = date;
	}

	public Locale getLocale() {
		return locale;
	}
	public void setLocale(Locale locale) {
		System.out.println("setLocale: " + locale);
		this.locale = locale;
	}

}
