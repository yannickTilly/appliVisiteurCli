package Controller.Base;

import Listener.ConsultationPratitionnerViewListener;
import Listener.RouteListener;
import Model.ConsultationPratitionnersModel;
import Model.Context;
import Model.Pratitionner;
import View.component.ConsultationPratitionnersView;

import java.io.IOException;
import java.util.Collection;

public class ConsultationPratitionnersController extends BaseController implements ConsultationPratitionnerViewListener {
    private ConsultationPratitionnersView view;
    private ConsultationPratitionnersModel consultationPratitionnersModel;
    public ConsultationPratitionnersController(Context context, RouteListener routeListener,
                                               ConsultationPratitionnersModel consultationPratitionnersModel) {
        super(context, routeListener);
        try {
            this.view = new ConsultationPratitionnersView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.consultationPratitionnersModel = consultationPratitionnersModel;
        view.setListener(this);
    }

    public ConsultationPratitionnersView getView(){
        return view;
    }
    @Override
    public void onSearch(String keyWord) {
        try {
            Collection<Pratitionner> pratitionners = getApiClient().getPratitionners(getContext().getToken());
            view.clearPratitionners();
            for(Pratitionner pratitionner : pratitionners)
            {
                view.addPratitionner(pratitionner.getFirstName());
            }
        } catch (IOException serverError) {
            getRouteListener().onError();
        }
    }
}
