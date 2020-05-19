package Controller.Delegate;

import Controller.Base.ConsultationDrugsController;
import Listener.RouteListener;
import Model.ConsultationDrugsModel;
import Model.Context;

public class DelegateConsultationDrugsController extends ConsultationDrugsController
{
    public DelegateConsultationDrugsController(Context context, RouteListener routeListener, ConsultationDrugsModel consultationDrugsModel) {
        super(context, routeListener, consultationDrugsModel);
        setRole("delegate");
    }
}
