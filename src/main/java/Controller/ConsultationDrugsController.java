package Controller;

import Listener.ConsultationDrugsViewListener;
import Listener.RouteListener;
import Model.ConsultationDrugsModel;
import Model.Context;
import Model.Drug;
import Model.Execption.ServerError;
import View.component.ConsultationDrugsView;

import java.util.Collection;

public class ConsultationDrugsController extends BaseController implements ConsultationDrugsViewListener
{
    private ConsultationDrugsView view;
    private ConsultationDrugsModel consultationDrugsModel;
    public ConsultationDrugsController(Context context, RouteListener routeListener,
                                       ConsultationDrugsModel consultationDrugsModel,
                                       ConsultationDrugsView consultationDrugsView) {
        super(context, routeListener);
        this.view = consultationDrugsView;
        this.consultationDrugsModel = consultationDrugsModel;
        consultationDrugsView.setListener(this);
    }

    @Override
    public void onSearch(String keyWord) {
        try {
            Collection<Drug> drugs = getApiClient().getDrugs(getContext().getToken());
            view.clearDrug();
            for(Drug drug : drugs)
            {
                view.addDrug(drug.getName());
            }
        } catch (ServerError serverError) {
            getRouteListener().onError();
        }
    }
}
