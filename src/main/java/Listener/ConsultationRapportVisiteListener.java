package Listener;

import java.util.EventListener;

public interface ConsultationRapportVisiteListener extends EventListener {
    void onBackSubmit();

    void onDelete();

    void onEdit();
}
