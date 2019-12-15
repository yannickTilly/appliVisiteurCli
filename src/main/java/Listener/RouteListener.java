package Listener;

public interface RouteListener {
    void onReportConsultations();
    void onReportConsultation(Long idRapportVisite);
    void onNewReport();
}
