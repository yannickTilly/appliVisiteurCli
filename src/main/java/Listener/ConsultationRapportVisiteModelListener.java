package Listener;

import Model.Report;

import java.util.EventListener;

public interface ConsultationRapportVisiteModelListener extends EventListener {
    void onRapportVisiteChange(Report rapportVisite);
}
