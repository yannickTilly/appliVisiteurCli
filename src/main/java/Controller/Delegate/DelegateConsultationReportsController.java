package Controller.Delegate;

import Controller.Base.ConsultationReportsController;
import Listener.RouteListener;
import Model.Context;

public class DelegateConsultationReportsController extends ConsultationReportsController {
    public DelegateConsultationReportsController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        setRole("delegate");
    }
}
