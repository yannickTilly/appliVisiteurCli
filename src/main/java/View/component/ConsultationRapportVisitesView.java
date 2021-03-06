package View.component;

import Listener.ConsultationRapportVisitesListener;
import Listener.ConsultationRapportVisitesModelListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisitesModel;
import Model.Report;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class ConsultationRapportVisitesView extends VBox implements Initializable, ConsultationRapportVisitesModelListener {

    @FXML
    private Button searchSubmit;

    @FXML
    private VBox rapportVisites;

    private Collection<ConsultationRapportVisitesListener> consultationRapportVisitesListeners;

    private ConsultationRapportVisitesModel consultationRapportVisitesModel;

    private RouteListener routeListener;

    // constructeur et initalisation
    public ConsultationRapportVisitesView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Visitor/consultationRapportVisites.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        consultationRapportVisitesListeners = new ArrayList<ConsultationRapportVisitesListener>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> searchHandler = e -> {
            fireSearchSubmit();
        };
        searchSubmit.setOnAction(searchHandler);
    }

    //getter setter
    public ConsultationRapportVisitesModel getConsultationRapportVisitesModel() {
        return consultationRapportVisitesModel;
    }

    public ConsultationRapportVisitesView setConsultationRapportVisitesModel(ConsultationRapportVisitesModel consultationRapportVisitesModel) {
        this.consultationRapportVisitesModel = consultationRapportVisitesModel;
        consultationRapportVisitesModel.addListener(this);
        return this;
    }

    public RouteListener getRouteListener() {
        return routeListener;
    }

    public ConsultationRapportVisitesView setRouteListener(RouteListener routeListener) {
        this.routeListener = routeListener;
        return this;
    }

    // gestion de l'écoute de la vue (this)
    public void addConsultationRapportVisitesListener(ConsultationRapportVisitesListener consultationRapportVisitesListener) {
        consultationRapportVisitesListeners.add(consultationRapportVisitesListener);
    }
    public void removeConsultationRapportVisitesListener(ConsultationRapportVisitesListener consultationRapportVisitesListener) {
        consultationRapportVisitesListeners.remove(consultationRapportVisitesListener);
    }
    private void fireSearchSubmit() {
        for (ConsultationRapportVisitesListener listener : consultationRapportVisitesListeners) {
            listener.onSearchSubmit();
        }
    }

    private void fireRequestConsultationRapportVisite(long id) {
        routeListener.onReportConsultation(id);
    }

    private void fireEditReport(long id)
    {
        routeListener.onReportEdit(id);
    }

    private void fireDeleteReport(long id)
    {
        for(ConsultationRapportVisitesListener consultationRapportVisitesListener :consultationRapportVisitesListeners){
            consultationRapportVisitesListener.deleteReport(id);
        }
    }


    //écoute du model
    @Override
    public void onRapportVisitesChange(Collection<Report> rapportVisites) {
        this.rapportVisites.getChildren().clear();
        rapportVisites.forEach(rapportVisite -> {
            try {
                VisitorRapportVisiteResumeView visitorRapportVisiteResumeView = new VisitorRapportVisiteResumeView();
                this.rapportVisites.getChildren().add(visitorRapportVisiteResumeView);
                visitorRapportVisiteResumeView.setLabel(rapportVisite.getLabel());
                visitorRapportVisiteResumeView.setOnOuvrirRapport(actionEvent -> fireRequestConsultationRapportVisite(rapportVisite.getId()));
                visitorRapportVisiteResumeView.setOnEditReport(actionEvent -> fireEditReport(rapportVisite.getId()));
                visitorRapportVisiteResumeView.setOnDeleteReport(actionEvent -> fireDeleteReport(rapportVisite.getId()));
            } catch (IOException e) {
                e.printStackTrace();
            }
        });
    }
}
