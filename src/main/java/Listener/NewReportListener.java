package Listener;

import java.time.LocalDate;
import java.util.EventListener;

public interface NewReportListener extends EventListener {
    void onSubmitNewReport(LocalDate date, String description, long drugId, long prationerId);
}
