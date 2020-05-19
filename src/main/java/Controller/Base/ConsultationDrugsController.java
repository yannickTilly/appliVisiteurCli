package Controller.Base;

import Listener.ConsultationDrugsViewListener;
import Listener.RouteListener;
import Model.ConsultationDrugsModel;
import Model.Context;
import Model.Drug;
import View.component.ConsultationDrugsView;

import java.io.IOException;
import java.util.Collection;

public class ConsultationDrugsController extends BaseController implements ConsultationDrugsViewListener
{
    private ConsultationDrugsView view;
    private ConsultationDrugsModel consultationDrugsModel;
    public ConsultationDrugsController(Context context, RouteListener routeListener,
                                       ConsultationDrugsModel consultationDrugsModel) {
        super(context, routeListener);
        try {
            this.view = new ConsultationDrugsView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.consultationDrugsModel = consultationDrugsModel;
        view.setListener(this);
    }

    public ConsultationDrugsView getView(){
        return view;
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
        } catch (IOException serverError) {
            getRouteListener().onError();
        }
    }
}
