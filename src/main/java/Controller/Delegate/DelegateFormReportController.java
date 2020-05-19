package Controller.Delegate;


import Controller.Base.FormReportController;
import Listener.RouteListener;
import Model.Context;

public class DelegateFormReportController extends FormReportController {
    public DelegateFormReportController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        setRole("delegate");
    }
}
