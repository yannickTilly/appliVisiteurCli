package Controller.Delegate;

import Controller.Base.ConsultationReportController;
import Listener.RouteListener;
import Model.Context;

public class DelegateConsultationReportController extends ConsultationReportController {
    public DelegateConsultationReportController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        setRole("delegate");
    }
}
