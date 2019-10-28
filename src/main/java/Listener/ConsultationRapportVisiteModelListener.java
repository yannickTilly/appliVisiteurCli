package Listener;

import Model.RapportVisite;

import java.util.EventListener;

public interface ConsultationRapportVisiteModelListener extends EventListener {
    void onRapportVisiteChange(RapportVisite rapportVisite);
}
