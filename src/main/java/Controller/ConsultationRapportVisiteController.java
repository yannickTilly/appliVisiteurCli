package Controller;

import Listener.ContextListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisiteModel;
import Model.ConsultationRapportVisitesModel;
import Model.Context;
import Model.RapportVisite;
import Util.ApiClient;
import View.component.ConsultationRapportVisiteView;
import View.component.ConsultationRapportVisitesView;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Label;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class ConsultationRapportVisiteController extends BaseController {
    private RapportVisite rapportVisite;
    private ConsultationRapportVisiteView consultationRapportVisiteView;
    private ConsultationRapportVisiteModel consultationRapportVisiteModel;

    //constructeur
    public ConsultationRapportVisiteController(Context context,
                                               RouteListener routeListener,
                                               ConsultationRapportVisiteModel consultationRapportVisiteModel, ConsultationRapportVisiteView consultationRapportVisiteView) {
        super(context, routeListener);
        this.consultationRapportVisiteModel = consultationRapportVisiteModel;
        this.consultationRapportVisiteView = consultationRapportVisiteView;
        consultationRapportVisiteView.setConsultationRapportVisiteModel(consultationRapportVisiteModel);
    }

    // getter setter


    public RapportVisite getRapportVisite() {
        return rapportVisite;
    }

    public ConsultationRapportVisiteController setRapportVisite(RapportVisite rapportVisite) {
        this.rapportVisite = rapportVisite;
        return this;
    }

    public ConsultationRapportVisiteView getConsultationRapportVisiteView() {
        return consultationRapportVisiteView;
    }

    public ConsultationRapportVisiteController setConsultationRapportVisiteView(ConsultationRapportVisiteView consultationRapportVisiteView) {
        this.consultationRapportVisiteView = consultationRapportVisiteView;
        return this;
    }

    public ConsultationRapportVisiteModel getConsultationRapportVisiteModel() {
        return consultationRapportVisiteModel;
    }

    public ConsultationRapportVisiteController setConsultationRapportVisiteModel(ConsultationRapportVisiteModel consultationRapportVisiteModel) {
        this.consultationRapportVisiteModel = consultationRapportVisiteModel;
        return this;
    }

    //

    public void loadRapportVisite(long id)
    {
        try {
            consultationRapportVisiteModel.setRapportVisite(getApiClient().getRapportVisite(id, this.getContext().getToken()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
