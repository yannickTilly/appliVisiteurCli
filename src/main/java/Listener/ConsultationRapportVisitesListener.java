package Listener;

import java.io.IOException;
import java.util.EventListener;

public interface ConsultationRapportVisitesListener extends EventListener {
    void onSearchSubmit();
    void deleteReport(long id);
}
