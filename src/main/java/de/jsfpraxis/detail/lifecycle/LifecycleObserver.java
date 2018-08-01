package de.jsfpraxis.detail.lifecycle;

import java.util.logging.Logger;

import javax.faces.context.ExternalContext;
import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;
import javax.faces.event.PhaseListener;
import javax.inject.Inject;

public class LifecycleObserver implements PhaseListener {

	private static final long serialVersionUID = 1L;
	private static final Logger log = Logger.getLogger(LifecycleObserver.class.getCanonicalName());
	
	@Inject
	ExternalContext externalContext;

	@Override
	public void afterPhase(PhaseEvent pe) {
		log.info("after " + pe.getPhaseId().toString());
	}

	@Override
	public void beforePhase(PhaseEvent pe) {
		log.info("request locale: " + externalContext.getRequestLocale());
		log.info("before " + pe.getPhaseId().toString());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
