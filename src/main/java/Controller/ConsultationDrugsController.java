package Controller;

import Listener.RouteListener;
import Model.ConsultationDrugModel;
import Model.Context;
import View.component.ConsultationDrugsView;

public class ConsultationDrugsController extends BaseController
{

    public ConsultationDrugsController(Context context, RouteListener routeListener,
                                       ConsultationDrugModel consultationDrugModel,
                                       ConsultationDrugsView consultationDrugsView) {
        super(context, routeListener);
    }
}
