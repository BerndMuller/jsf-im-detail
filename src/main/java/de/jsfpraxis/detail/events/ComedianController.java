package de.jsfpraxis.detail.events;

import java.io.Serializable;
import java.util.List;
import java.util.logging.Logger;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.enterprise.context.Conversation;
import javax.enterprise.context.ConversationScoped;
import javax.faces.model.DataModel;
import javax.faces.model.ListDataModel;
import javax.inject.Inject;
import javax.inject.Named;

/**
 * Managed Bean für das Data-Model-Event-Beispiel.
 * 
 * Das Sortieren funktioniert nur auf der Übersichtsseite. Damit es auch im
 * Zusammenspiel mit der Ändern-Seite funktioniert, muss die Bean session-scoped sein.
 * 
 * @author Bernd Müller
 *
 */
@Named
@ConversationScoped
public class ComedianController implements Serializable {

	private static final long serialVersionUID = 1L;
	private static final Logger logger = Logger.getLogger(ComedianController.class.getCanonicalName());
	
	@Inject
	Conversation conversation;
	
	private DataModel<Comedian> comedians;
	private Comedian comedian;

	public ComedianController() {
		comedians = new ListDataModel<>();
		comedians.setWrappedData(Comedian.sample());
	}
	
	public String edit() {
		conversation.begin();
		comedian = comedians.getRowData();
		return "comedian.xhtml";
	}
	
	public String save() {
		System.out.println("Comedian in save: " + comedian);
		conversation.end();
		return "comedians.xhtml";
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
