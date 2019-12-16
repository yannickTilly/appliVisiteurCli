package Controller;


import Listener.ContextListener;
import Listener.NewReportListener;
import Listener.RouteListener;
import Model.Context;
import Model.Drug;
import Model.Execption.ServerError;
import Model.Pratitionner;
import Model.Report;
import Model.RequestBody.ReportBody;
import View.Structure.Prationner;
import View.component.SaisirRapportVisiteView;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.util.List;

public class NewReportController extends BaseController implements NewReportListener, ContextListener {
    private SaisirRapportVisiteView view;

    public NewReportController(Context context, RouteListener routeListener, SaisirRapportVisiteView saisirRapportVisiteView) {
        super(context, routeListener);
        view = saisirRapportVisiteView;
        view.setListener(this);
        getContext().addListener(this);
    }

    public void onSubmit(ActionEvent actionEvent) {
        System.out.println("aaaaaaa");
    }

    @Override
    public void onSubmitNewReport(LocalDate date, String description, List<Long> drugIds, long prationerId) {
        System.out.println("Soumission rapport ...");
        ReportBody reportBody = new ReportBody();
        reportBody.setMedicamentIds(drugIds)
                .setNote(description)
                .setPraticienId(prationerId);
        try {
            Report report = getApiClient().postReport(reportBody, getContext().getToken());
            getRouteListener().onReportConsultation(report.getId());
            System.out.println("redirection vers consultationReport");
        } catch (ServerError serverError) {
            getRouteListener().onError();
        }
    }

    public void loadDrugsInView() {
        try {
            for (Drug drug : getApiClient().getDrugs(getContext().getToken())) {
                view.addDrug(drug.getName(), drug.getId());
            }
        } catch (ServerError serverError) {
            getRouteListener().onError();
        }
    }

    public void loadPratitionnerInView() {
        try {
            for (Pratitionner pratitionner : getApiClient().getPratitionners(getContext().getToken())) {
                view.addPratitionners(pratitionner.getFirst_name(), pratitionner.getId());
            }
        } catch (ServerError serverError) {
            getRouteListener().onError();
        }
    }


    @Override
    public void userLoginSucess() {
        loadDrugsInView();
        loadPratitionnerInView();
    }
}
