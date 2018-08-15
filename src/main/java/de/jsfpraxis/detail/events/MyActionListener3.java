package de.jsfpraxis.detail.events;

import java.util.logging.Logger;

import javax.enterprise.context.RequestScoped;
import javax.inject.Named;

@Named
@RequestScoped
public class MyActionListener3 extends MyActionListener {
	
	
	public MyActionListener3() {
		Logger.getLogger(MyActionListener3.class.getCanonicalName()).info("Konstruktor aufgerufen");
	}

	public void foo() {
		Logger.getLogger(MyActionListener3.class.getCanonicalName()).info("foo() aufgerufen");
	}
}
