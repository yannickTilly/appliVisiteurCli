package Controller;

import Listener.ConsultationRapportVisiteListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisiteModel;
import Model.Context;
import Model.Report;
import View.component.ConsultationRapportVisiteView;

import java.io.IOException;

public class ConsultationReportController extends BaseController implements ConsultationRapportVisiteListener {
    private Report rapportVisite;
    private ConsultationRapportVisiteView consultationRapportVisiteView;
    private ConsultationRapportVisiteModel consultationRapportVisiteModel;

    //constructeur
    public ConsultationReportController(Context context,
                                        RouteListener routeListener,
                                        ConsultationRapportVisiteModel consultationRapportVisiteModel, ConsultationRapportVisiteView consultationRapportVisiteView) {
        super(context, routeListener);
        this.consultationRapportVisiteModel = consultationRapportVisiteModel;
        this.setConsultationRapportVisiteView(consultationRapportVisiteView);
        consultationRapportVisiteView.setConsultationRapportVisiteModel(consultationRapportVisiteModel);
    }

    // getter setter


    public Report getRapportVisite() {
        return rapportVisite;
    }

    public ConsultationReportController setRapportVisite(Report rapportVisite) {
        this.rapportVisite = rapportVisite;
        return this;
    }

    public ConsultationRapportVisiteView getConsultationRapportVisiteView() {
        return consultationRapportVisiteView;
    }

    public ConsultationReportController setConsultationRapportVisiteView(ConsultationRapportVisiteView consultationRapportVisiteView) {
        this.consultationRapportVisiteView = consultationRapportVisiteView;
        consultationRapportVisiteView.setListener(this);
        return this;
    }

    public ConsultationRapportVisiteModel getConsultationRapportVisiteModel() {
        return consultationRapportVisiteModel;
    }

    public ConsultationReportController setConsultationRapportVisiteModel(ConsultationRapportVisiteModel consultationRapportVisiteModel) {
        this.consultationRapportVisiteModel = consultationRapportVisiteModel;
        return this;
    }

    //

    public void loadRapportVisite(long id)
    {
        try {
            consultationRapportVisiteModel.setRapportVisite(getApiClient().getRapportVisite(id, this.getContext().getToken()));
        } catch (IOException | InterruptedException e) {
            getRouteListener().onError();
        }
    }

    @Override
    public void onBackSubmit() {
        System.out.println("JE REVIENS EN ARRIERE");
        this.getRouteListener().onReportConsultations();
    }
}
