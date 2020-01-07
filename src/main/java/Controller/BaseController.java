package Controller;

import Listener.RouteListener;
import Model.Context;
import Util.ApiClient;

public abstract class BaseController {
    private Context context;
    private static ApiClient apiClient= new ApiClient();
    private RouteListener routeListener;


    public BaseController(Context context, RouteListener routeListener) {
        this.context = context;
        this.routeListener = routeListener;
    }

    public Context getContext() {
        return context;
    }

    public BaseController setContext(Context context) {
        this.context = context;
        return this;
    }

    public static ApiClient getApiClient() {
        return apiClient;
    }

    public RouteListener getRouteListener() {
        return routeListener;
    }

    public BaseController setRouteListener(RouteListener routeListener) {
        this.routeListener = routeListener;
        return this;
    }
}
