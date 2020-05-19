package Controller.Base;


import Listener.ContextListener;
import Listener.FormReportListener;
import Listener.RouteListener;
import Model.Context;
import Model.Drug;
import Model.Pratitionner;
import Model.Report;
import Model.RequestBody.ReportBody;
import View.component.FormReportView;
import javafx.event.ActionEvent;

import java.io.IOException;
import java.time.LocalDate;
import java.util.List;

public class FormReportController extends BaseController implements FormReportListener, ContextListener {
    private FormReportView view;

    public FormReportController(Context context, RouteListener routeListener)
    {
        super(context, routeListener);
        getContext().addListener(this);
        try {
            view = new FormReportView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        view.setListener(this);
    }

    public void onSubmit(ActionEvent actionEvent) {
        System.out.println("aaaaaaa");
    }

    public FormReportView getView(){
        loadDrugsInView();
        loadPratitionnerInView();
        return view;
    }
    public void loadDrugsInView() {
        try {
            for (Drug drug : getApiClient().getDrugs(getContext().getToken())) {
                view.addDrug(drug.getName(), drug.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadPratitionnerInView() {
        try {
            for (Pratitionner pratitionner : getApiClient().getPratitionners(getContext().getToken())) {
                view.addPratitionners(pratitionner.getFirstName(), pratitionner.getId());
            }
        } catch (IOException serverError) {
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
            Report report = getApiClient().postReport(reportBody, getContext().getToken());
            getRouteListener().onReportConsultation(report.getId());
            System.out.println("redirection vers consultationReport");
    }
}
