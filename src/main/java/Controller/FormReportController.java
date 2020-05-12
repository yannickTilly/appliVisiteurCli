package Controller;


import Listener.ContextListener;
import Listener.FormReportListener;
import Listener.RouteListener;
import Model.Context;
import Model.Drug;
import Model.Execption.ClientError;
import Model.Execption.ServerError;
import Model.Pratitionner;
import Model.Report;
import Model.RequestBody.ReportBody;
import View.component.FormReportView;
import javafx.event.ActionEvent;

import java.time.LocalDate;
import java.util.List;

public class FormReportController extends BaseController implements FormReportListener, ContextListener {
    private FormReportView view;

    public FormReportController(Context context, RouteListener routeListener, FormReportView formReportView)
    {
        super(context, routeListener);
        view = formReportView;
        view.setListener(this);
        getContext().addListener(this);
    }

    public void onSubmit(ActionEvent actionEvent) {
        System.out.println("aaaaaaa");
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
                view.addPratitionners(pratitionner.getFirstName(), pratitionner.getId());
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

    @Override
    public void onSubmitReport(String description, List<Long> drugIds, long prationerId, LocalDate date, String label) {
        System.out.println("Soumission rapport ...");
        ReportBody reportBody = new ReportBody();
        reportBody.setMedicamentIds(drugIds)
                .setNote(description)
                .setPraticienId(prationerId)
                .setDate(date.toString())
                .setLabel(label);
        try {
            Report report = getApiClient().postReport(reportBody, getContext().getToken());
            getRouteListener().onReportConsultation(report.getId());
            System.out.println("redirection vers consultationReport");
        } catch (ServerError | ClientError serverError) {
            getRouteListener().onError();
        }
    }
}
