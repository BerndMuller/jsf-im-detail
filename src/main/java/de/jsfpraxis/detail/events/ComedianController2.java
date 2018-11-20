package de.jsfpraxis.detail.events;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

/**
 * Managed Bean für das Data-Model-Event-Beispiel und nur einer JSF-Seite (comedians2.xhtml).
 * 
 * @author Bernd Müller
 *
 */
@Named("cc2")
@ViewScoped
public class ComedianController2 implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ComedianController2.class.getCanonicalName());
	
	private DataModel<Comedian> comedians;
	private Comedian comedian;

	public ComedianController2() {
		comedians = new ListDataModel<>();
		comedians.setWrappedData(Comedian.sample());
		comedian = new Comedian();
	}
	
	public void edit() {
		comedian = comedians.getRowData();
		logger.info("Selektierter Comedian: " + comedian);
	}
	
	public void save() {
		logger.info("speichern");
	}
	
	@SuppressWarnings("unchecked")
	public void sortByFirstname() {
		((List<Comedian>) comedians.getWrappedData()).sort((c1, c2) -> c1.getFirstname().compareTo(c2.getFirstname()));
	}

	@SuppressWarnings("unchecked")
	public void sortByLastname() {
		((List<Comedian>) comedians.getWrappedData()).sort((c1, c2) -> c1.getLastname().compareTo(c2.getLastname()));
	}

	@SuppressWarnings("unchecked")
	public void sortByDob() {
		((List<Comedian>) comedians.getWrappedData()).sort((c1, c2) -> (int) (c1.getDob().toEpochDay() - c2.getDob().toEpochDay()));
	}

	// Getter und Setter
	public DataModel<Comedian> getComedians() {
		return comedians;
	}
	public void setComedians(DataModel<Comedian> comedians) {
		this.comedians = comedians;
	}

	public Comedian getComedian() {
		return comedian;
	}
	public void setComedian(Comedian comedian) {
		this.comedian = comedian;
	}
	
	
	@PostConstruct
	public void init() {
		logger.info("ComedianController erzeugt");
	}
	
	@PreDestroy
	public void clean() {
		logger.info("ComedianController zerstört");
	}
}
