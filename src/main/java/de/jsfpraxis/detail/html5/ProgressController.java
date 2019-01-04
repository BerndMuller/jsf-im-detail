package de.jsfpraxis.detail.html5;

import java.time.LocalTime;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class ProgressController {

	public ProgressController() {
	}

	public int getValue() {
		return LocalTime.now().getSecond();
	}
	
}
