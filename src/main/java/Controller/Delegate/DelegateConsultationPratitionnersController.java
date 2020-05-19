package Controller.Delegate;

import Controller.Base.ConsultationPratitionnersController;
import Listener.RouteListener;
import Model.ConsultationPratitionnersModel;
import Model.Context;

public class DelegateConsultationPratitionnersController extends ConsultationPratitionnersController {
    public DelegateConsultationPratitionnersController(Context context, RouteListener routeListener, ConsultationPratitionnersModel consultationPratitionnersModel) {
        super(context, routeListener, consultationPratitionnersModel);
        setRole("delegate");
    }
}
