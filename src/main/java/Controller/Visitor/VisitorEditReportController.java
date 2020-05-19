package Controller.Visitor;

import Controller.Base.BaseController;
import Controller.Base.EditReportController;
import Listener.ContextListener;
import Listener.FormReportListener;
import Listener.RouteListener;
import Model.Context;
import Model.Pratitionner;
import Model.Report;
import Util.ApiClient;
import View.component.FormReportView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class VisitorEditReportController extends EditReportController {
    public VisitorEditReportController(Context context, RouteListener routeListener) {
        super(context, routeListener);
    }
}
