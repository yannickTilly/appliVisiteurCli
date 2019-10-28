package Controller;


import Listener.RouteListener;
import Model.Context;
import javafx.event.ActionEvent;

public class SaisieRapportVisiteController extends BaseController{
    public SaisieRapportVisiteController(Context context, RouteListener routeListener) {
        super(context, routeListener);
    }

    public void onSubmit(ActionEvent actionEvent)
    {
        System.out.println("aaaaaaa");
    }
}
