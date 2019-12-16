package Listener;

import java.time.LocalDate;
import java.util.EventListener;
import java.util.List;

public interface NewReportListener extends EventListener {
    void onSubmitNewReport(LocalDate date, String description, List<Long> drugId, long prationerId);
}
