package Controller;

import Listener.ConsultationPratitionnerViewListener;
import Listener.RouteListener;
import Model.*;
import Model.Execption.ServerError;
import View.component.ConsultationDrugsView;
import View.component.ConsultationPratitionnersView;

import java.util.Collection;

public class ConsultationPratitionnersController extends BaseController implements ConsultationPratitionnerViewListener {
    private ConsultationPratitionnersView view;
    private ConsultationPratitionnersModel consultationPratitionnersModel;
    public ConsultationPratitionnersController(Context context, RouteListener routeListener,
                                               ConsultationPratitionnersModel consultationPratitionnersModel,
                                               ConsultationPratitionnersView consultationPratitionnersView) {
        super(context, routeListener);
        this.view = consultationPratitionnersView;
        this.consultationPratitionnersModel = consultationPratitionnersModel;
        consultationPratitionnersView.setListener(this);
    }

    @Override
    public void onSearch(String keyWord) {
        try {
            Collection<Pratitionner> pratitionners = getApiClient().getPratitionners(getContext().getToken());
            for(Pratitionner pratitionner : pratitionners)
            {
                view.addPratitionner(pratitionner.getFirst_name());
            }
        } catch (ServerError serverError) {
            getRouteListener().onError();
        }
    }
}
