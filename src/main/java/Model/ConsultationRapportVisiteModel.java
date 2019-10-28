package Model;

import Listener.ConsultationRapportVisiteModelListener;

import java.util.ArrayList;
import java.util.Collection;

public class ConsultationRapportVisiteModel {
    private RapportVisite rapportVisite;
    private Collection<ConsultationRapportVisiteModelListener> listeners;

    public ConsultationRapportVisiteModel() {
        this.listeners = new ArrayList<>();
    }

    public RapportVisite getRapportVisite() {
        return rapportVisite;
    }

    public ConsultationRapportVisiteModel setRapportVisite(RapportVisite rapportVisite) {
        this.rapportVisite = rapportVisite;
        fireRapportVisiteChange();
        return this;
    }

    public void addListener(ConsultationRapportVisiteModelListener consultationRapportVisitesModelListener)
    {
        listeners.add(consultationRapportVisitesModelListener);
    }
    public void removeListener(ConsultationRapportVisiteModelListener consultationRapportVisitesModelListener)
    {
        listeners.remove(consultationRapportVisitesModelListener);
    }
    private void fireRapportVisiteChange()
    {
        for(ConsultationRapportVisiteModelListener listener : listeners) {
            listener.onRapportVisiteChange(rapportVisite);
        }
    }
}