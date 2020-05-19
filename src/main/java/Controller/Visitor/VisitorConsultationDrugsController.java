package Controller.Visitor;

import Controller.Base.BaseController;
import Controller.Base.ConsultationDrugsController;
import Listener.ConsultationDrugsViewListener;
import Listener.RouteListener;
import Model.ConsultationDrugsModel;
import Model.Context;
import Model.Drug;
import View.component.ConsultationDrugsView;

import java.io.IOException;
import java.util.Collection;

public class VisitorConsultationDrugsController extends ConsultationDrugsController
{
    public VisitorConsultationDrugsController(Context context, RouteListener routeListener, ConsultationDrugsModel consultationDrugsModel) {
        super(context, routeListener, consultationDrugsModel);
    }
}
