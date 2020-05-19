package Controller.Visitor;

import Controller.Base.BaseController;
import Controller.Base.MenuController;
import Listener.ContextListener;
import Listener.MenuListener;
import Listener.RouteListener;
import Model.Context;
import View.component.MenuView;

import java.io.IOException;

public class VisitorMenuController extends MenuController {

    public VisitorMenuController(Context context, RouteListener routeListener) {
        super(context, routeListener);
    }
}
