package Controller.Visitor;

import Controller.Base.BaseController;
import Controller.Base.ConsultationReportsController;
import Listener.ConsultationRapportVisitesListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisitesModel;
import Model.Context;
import View.component.ConsultationRapportVisitesView;

import java.io.IOException;
import java.util.Collection;

public class VisitorConsultationReportsController extends ConsultationReportsController {
    public VisitorConsultationReportsController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        setRole("visitor");
    }
}
