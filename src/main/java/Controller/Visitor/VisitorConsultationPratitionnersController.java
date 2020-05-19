package Controller.Visitor;

import Controller.Base.BaseController;
import Controller.Base.ConsultationPratitionnersController;
import Controller.Base.ConsultationReportController;
import Listener.ConsultationPratitionnerViewListener;
import Listener.RouteListener;
import Model.*;
import View.component.ConsultationPratitionnersView;

import java.io.IOException;
import java.util.Collection;

public class VisitorConsultationPratitionnersController extends ConsultationPratitionnersController {
    public VisitorConsultationPratitionnersController(Context context, RouteListener routeListener, ConsultationPratitionnersModel consultationPratitionnersModel) {
        super(context, routeListener, consultationPratitionnersModel);
    }
}
