package Listener;

import java.time.LocalDate;
import java.util.EventListener;
import java.util.List;

public interface FormReportListener extends EventListener {
    void onSubmitReport(String description, List<Long> drugId, long prationerId, LocalDate value, String label);
}
