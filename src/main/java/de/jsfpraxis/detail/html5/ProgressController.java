package de.jsfpraxis.detail.html5;

import java.time.LocalTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

/**
 * Managed Bean für das Beipspiel mit <code>&lt;progress&gt;</code>
 * 
 * @author Bernd Müller
 *
 */
@Named
@RequestScoped
public class ProgressController {

	public ProgressController() {
	}

	public int getValue() {
		return LocalTime.now().getSecond();
	}
	
}
