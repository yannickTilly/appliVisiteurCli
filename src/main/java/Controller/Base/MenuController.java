package Controller.Base;

import Listener.ContextListener;
import Listener.MenuListener;
import Listener.RouteListener;
import Model.Context;
import View.component.MenuView;

import java.io.IOException;

public class MenuController extends BaseController implements MenuListener, ContextListener {
    private MenuView visitorMenuView;
    public MenuController(Context context, RouteListener routeListener) {
        super(context, routeListener);
        try {
            this.visitorMenuView = new MenuView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        visitorMenuView.setListener(this);
        getContext().addListener(this);
    }

    public MenuView getView()
    {
        return visitorMenuView;
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
    public void onDisconect() {
        this.getRouteListener().onDisconnect();
    }

    @Override
    public void userLoginSucess() {
        this.visitorMenuView.setVisible(true);
    }
}
