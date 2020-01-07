package Controller;

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

    public ConsultationReportsController(Context context, RouteListener routeListener, ConsultationRapportVisitesView consultationRapportVisitesView) {
        super(context, routeListener);
        this.consultationRapportVisitesView = consultationRapportVisitesView;
        consultationRapportVisitesView.addConsultationRapportVisitesListener(this);
    }

    public ConsultationRapportVisitesView getConsultationRapportVisitesView() {
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
}
