package Controller.Base;

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
                                        RouteListener routeListener) {
        super(context, routeListener);
        this.consultationRapportVisiteModel = new ConsultationRapportVisiteModel();
        try {
            consultationRapportVisiteView = new ConsultationRapportVisiteView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setConsultationRapportVisiteView(consultationRapportVisiteView);
        consultationRapportVisiteView.setConsultationRapportVisiteModel(consultationRapportVisiteModel);
        this.setRole("visitor");
    }

    // getter setter


    public Report getRapportVisite() {
        return rapportVisite;
    }

    public ConsultationReportController setRapportVisite(Report rapportVisite) {
        this.rapportVisite = rapportVisite;
        return this;
    }

    public ConsultationRapportVisiteView getView() {
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

    @Override
    public void onDelete() {
        try {
            getApiClient().deleteReport(consultationRapportVisiteModel.getRapportVisite().getId(), getContext().getToken());
            getRouteListener().onReportConsultations();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void onEdit() {
        getRouteListener().onReportEdit(consultationRapportVisiteModel.getRapportVisite().getId());
    }
}
