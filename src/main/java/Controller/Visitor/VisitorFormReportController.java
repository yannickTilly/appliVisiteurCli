package Controller.Visitor;


import Controller.Base.BaseController;
import Controller.Base.FormReportController;
import Listener.ContextListener;
import Listener.FormReportListener;
import Listener.RouteListener;
import Model.Context;
import Model.Drug;
import Model.Pratitionner;
import Model.Report;
import Model.RequestBody.ReportBody;
import View.component.FormReportView;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class VisitorFormReportController extends FormReportController {
    public VisitorFormReportController(Context context, RouteListener routeListener) {
        super(context, routeListener);
    }
}
