package Controller.Delegate;

import Controller.Base.MenuController;
import Listener.RouteListener;
import Model.Context;


public class DelegateMenuController extends MenuController{
    public DelegateMenuController(Context context, RouteListener routeListener) {
        super(context, routeListener);
    }
}
