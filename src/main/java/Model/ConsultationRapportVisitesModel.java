package Model;

import Listener.ConsultationRapportVisitesListener;
import Listener.ConsultationRapportVisitesModelListener;

import java.util.ArrayList;
import java.util.Collection;

public class ConsultationRapportVisitesModel {
    private Collection<Report> rapportVisites;
    private Collection<ConsultationRapportVisitesModelListener> listeners;

    public ConsultationRapportVisitesModel() {
        this.listeners = new ArrayList<ConsultationRapportVisitesModelListener>();
    }

    public Collection<Report> getRapportVisites() {
        return rapportVisites;
    }

    public ConsultationRapportVisitesModel setRapportVisites(Collection<Report> rapportVisites) {
        this.rapportVisites = rapportVisites;
        fireRapportVisitesModel();
        return this;
    }

    public void addListener(ConsultationRapportVisitesModelListener consultationRapportVisitesModelListener)
    {
        listeners.add(consultationRapportVisitesModelListener);
    }
    public void removeListener(ConsultationRapportVisitesModelListener consultationRapportVisitesModelListener)
    {
        listeners.remove(consultationRapportVisitesModelListener);
    }
    private void fireRapportVisitesModel()
    {
        for(ConsultationRapportVisitesModelListener listener : listeners) {
            listener.onRapportVisitesChange(rapportVisites);
        }
    }
}
