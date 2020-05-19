package Controller.Delegate;

import Controller.Base.EditReportController;
import Listener.RouteListener;
import Model.Context;

public class DelegateEditReportController extends EditReportController {
    public DelegateEditReportController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        setRole("delegate");
    }
}
