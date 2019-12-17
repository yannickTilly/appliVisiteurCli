package Controller;

import Listener.ContextListener;
import Listener.MenuListener;
import Listener.RouteListener;
import Model.Context;
import View.component.MenuView;

public class MenuController extends BaseController implements MenuListener, ContextListener {
    private MenuView menuView;
    public MenuController(Context context, RouteListener routeListener, MenuView menuView) {
        super(context, routeListener);
        getContext().addListener(this);
        menuView.setListener(this);
        this.menuView = menuView;
        menuView.setVisible(false);
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

    @Override
    public void onPratitionnersClicked() {
        this.getRouteListener().onPratitionners();
    }

    @Override
    public void userLoginSucess() {
        this.menuView.setVisible(true);
    }
}
