package Controller;

import Listener.ConsultationRapportVisitesListener;
import Model.ConsultationRapportVisitesModel;
import Model.Context;
import Model.RapportVisite;
import Util.ApiClient;
import View.component.ConsultationRapportVisitesView;
import View.component.MainView;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.Arrays;
import java.util.Collection;

public class ConsultationRapportVisitesController extends BaseController implements ConsultationRapportVisitesListener{
    private ConsultationRapportVisitesView consultationRapportVisitesView;
    private ConsultationRapportVisitesModel consultationRapportVisitesModel;
    private Collection<ConsultationRapportVisitesListener> listeners;

    public ConsultationRapportVisitesController(Context context, ConsultationRapportVisitesView consultationRapportVisitesView) {
        super(context);
        this.consultationRapportVisitesView = consultationRapportVisitesView;
        consultationRapportVisitesView.addConsultationRapportVisitesListener(this);
    }

    public ConsultationRapportVisitesView getConsultationRapportVisitesView() {
        return consultationRapportVisitesView;
    }

    public ConsultationRapportVisitesController setConsultationRapportVisitesView(ConsultationRapportVisitesView consultationRapportVisitesView) {
        this.consultationRapportVisitesView = consultationRapportVisitesView;
        return this;
    }

    public ConsultationRapportVisitesModel getConsultationRapportVisitesModel() {
        return consultationRapportVisitesModel;
    }

    public ConsultationRapportVisitesController setConsultationRapportVisitesModel(ConsultationRapportVisitesModel consultationRapportVisitesModel) {
        this.consultationRapportVisitesModel = consultationRapportVisitesModel;
        consultationRapportVisitesView.setConsultationRapportVisitesModel(consultationRapportVisitesModel);
        return this;
    }

    @Override
    public void onSearchSubmit() {
        try {
            consultationRapportVisitesModel.setRapportVisites(apiClient.getRapportVisites(getContext().getToken()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
