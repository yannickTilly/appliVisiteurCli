package Controller;

import Listener.ContextListener;
import Model.Context;
import Model.Report;
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
    private Report rapportVisite;
    private ConsultationRapportVisiteView consultationRapportVisiteView;

    public ConsultationRapportVisiteController(Context context, Report rapportVisite, ConsultationRapportVisiteView consultationRapportVisiteView) {
        super(context);
        this.rapportVisite = rapportVisite;
        this.consultationRapportVisiteView = consultationRapportVisiteView;
    }

    public Report getRapportVisite() {
        return rapportVisite;
    }

    public ConsultationRapportVisiteController setRapportVisite(Report rapportVisite) {
        this.rapportVisite = rapportVisite;
        return this;
    }
}
