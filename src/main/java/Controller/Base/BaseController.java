package Controller.Base;

import Listener.RouteListener;
import Model.Context;
import Util.ApiClient;

public abstract class BaseController {
    protected Context context;
    private static ApiClient apiClient = new ApiClient();
    private RouteListener routeListener;


    public BaseController(Context context, RouteListener routeListener) {
        this.context = context;
        this.routeListener = routeListener;
    }

    public Context getContext() {
        return context;
    }

    public void setContext(Context context) {
        this.context = context;
    }

    public static ApiClient getApiClient() {
        return apiClient;
    }

    public void setRole(String role){
        apiClient.setRole(role);
    }

    public RouteListener getRouteListener() {
        return routeListener;
    }

    public BaseController setRouteListener(RouteListener routeListener) {
        this.routeListener = routeListener;
        return this;
    }
}
