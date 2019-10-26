package Controller;

import Listener.ContextListener;
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

public class ConsultationRapportVisiteController extends BaseController
{
    private RapportVisite rapportVisite;
    private ConsultationRapportVisiteView consultationRapportVisiteView;

    public ConsultationRapportVisiteController(Context context, RapportVisite rapportVisite, ConsultationRapportVisiteView consultationRapportVisiteView) {
        super(context);
        this.rapportVisite = rapportVisite;
        this.consultationRapportVisiteView = consultationRapportVisiteView;
    }

    public RapportVisite getRapportVisite() {
        return rapportVisite;
    }

    public ConsultationRapportVisiteController setRapportVisite(RapportVisite rapportVisite) {
        this.rapportVisite = rapportVisite;
        return this;
    }
}
