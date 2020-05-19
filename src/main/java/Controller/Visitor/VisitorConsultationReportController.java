package Controller.Visitor;

import Controller.Base.BaseController;
import Controller.Base.ConsultationReportController;
import Listener.ConsultationRapportVisiteListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisiteModel;
import Model.Context;
import Model.Report;
import View.component.ConsultationRapportVisiteView;

import java.io.IOException;

public class VisitorConsultationReportController extends ConsultationReportController {
    public VisitorConsultationReportController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        setRole("visitor");
    }
}
