package Controller.Base;

import Listener.ConsultationRapportVisitesListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisitesModel;
import Model.Context;
import View.component.ConsultationRapportVisitesView;

import java.io.IOException;
import java.util.Collection;

public class ConsultationReportsController extends BaseController implements ConsultationRapportVisitesListener{
    private ConsultationRapportVisitesView consultationRapportVisitesView;
    private ConsultationRapportVisitesModel consultationRapportVisitesModel;
    private Collection<ConsultationRapportVisitesListener> listeners;

    public ConsultationReportsController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        try {
            consultationRapportVisitesView = new ConsultationRapportVisitesView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.consultationRapportVisitesView = consultationRapportVisitesView;
        consultationRapportVisitesView.addConsultationRapportVisitesListener(this);
        this.setRole("visitor");
    }

    public ConsultationRapportVisitesView getView() {
        onSearchSubmit();
        return consultationRapportVisitesView;
    }

    public ConsultationReportsController setConsultationRapportVisitesView(ConsultationRapportVisitesView consultationRapportVisitesView) {
        this.consultationRapportVisitesView = consultationRapportVisitesView;
        this.consultationRapportVisitesView.setRouteListener(this.getRouteListener());
        return this;
    }

    public ConsultationRapportVisitesModel getConsultationRapportVisitesModel() {
        return consultationRapportVisitesModel;
    }

    public ConsultationReportsController setConsultationRapportVisitesModel(ConsultationRapportVisitesModel consultationRapportVisitesModel) {
        this.consultationRapportVisitesModel = consultationRapportVisitesModel;
        consultationRapportVisitesView
                .setConsultationRapportVisitesModel(consultationRapportVisitesModel)
                .setRouteListener(this.getRouteListener());
        return this;
    }

    @Override
    public void onSearchSubmit() {
        try {
            consultationRapportVisitesModel.setRapportVisites(getApiClient().getRapportVisites(getContext().getToken()));
        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    @Override
    public void deleteReport(long id) {
        try {
            getApiClient().deleteReport(id, context.getToken());
            onSearchSubmit();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
