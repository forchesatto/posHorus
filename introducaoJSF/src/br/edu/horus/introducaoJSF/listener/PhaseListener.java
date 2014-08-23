package br.edu.horus.introducaoJSF.listener;

import javax.faces.event.PhaseEvent;
import javax.faces.event.PhaseId;


public class PhaseListener implements javax.faces.event.PhaseListener{

	private static final long serialVersionUID = 5963026264417183550L;

	@Override
	public void afterPhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext()
				.log("Depois de: "+event.getPhaseId());
	}

	@Override
	public void beforePhase(PhaseEvent event) {
		event.getFacesContext().getExternalContext()
				.log("Antes de: "+event.getPhaseId());
	}

	@Override
	public PhaseId getPhaseId() {
		return PhaseId.ANY_PHASE;
	}

}
