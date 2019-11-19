package Listener;

import Model.Report;

import java.util.Collection;
import java.util.EventListener;

public interface ConsultationRapportVisitesModelListener extends EventListener {
    void onRapportVisitesChange(Collection<Report> rapportVisites);
}
