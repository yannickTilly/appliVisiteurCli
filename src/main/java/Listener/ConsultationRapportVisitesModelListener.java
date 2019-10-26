package Listener;

import Model.RapportVisite;

import java.util.Collection;
import java.util.EventListener;

public interface ConsultationRapportVisitesModelListener extends EventListener {
    void onRapportVisitesChange(Collection<RapportVisite> rapportVisites);
}
