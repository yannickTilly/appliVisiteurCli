package Model;

import Listener.ConsultationRapportVisiteModelListener;

import java.util.ArrayList;
import java.util.Collection;

public class ConsultationRapportVisiteModel {
    private Report rapportVisite;
    private Collection<ConsultationRapportVisiteModelListener> listeners;

    public ConsultationRapportVisiteModel() {
        this.listeners = new ArrayList<>();
    }

    public Report getRapportVisite() {
        return rapportVisite;
    }

    public ConsultationRapportVisiteModel setRapportVisite(Report rapportVisite) {
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