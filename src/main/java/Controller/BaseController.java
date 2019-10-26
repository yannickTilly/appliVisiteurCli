package Controller;

import Model.Context;
import Util.ApiClient;

public abstract class BaseController {
    public Context context;
    public static ApiClient apiClient= new ApiClient();

    public BaseController(Context context) {
        this.context = context;
    }

    public BaseController() {

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

    public static void setApiClient(ApiClient apiClient) {
        BaseController.apiClient = apiClient;
    }
}
