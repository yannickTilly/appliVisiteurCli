package Controller;

import Listener.MenuListener;
import Listener.RouteListener;
import Model.Context;
import View.component.MenuView;

public class MenuController extends BaseController implements MenuListener{
    private MenuView menuView;
    public MenuController(Context context, RouteListener routeListener, MenuView menuView) {
        super(context, routeListener);
        menuView.setListener(this);
    }

    @Override
    public void onConsulterClicked() {
        this.getRouteListener().onReportConsultations();
    }

    @Override
    public void onNewReportClicked() {
        this.getRouteListener().onNewReport();
    }

    @Override
    public void onDrugsClicked() {
        this.getRouteListener().onDrugConsultation();
    }
}
