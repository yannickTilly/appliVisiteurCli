package Controller;

import Listener.ContextListener;
import Listener.FormReportListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisiteModel;
import Model.Context;
import Model.Execption.ServerError;
import Model.Pratitionner;
import Model.Report;
import Util.ApiClient;
import View.component.FormReportView;
import javafx.fxml.Initializable;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class EditReportController extends BaseController implements FormReportListener, ContextListener {
    private Report report;
    private FormReportView formView;
    private static ApiClient apiClient = new ApiClient();

    //constructeur
    public EditReportController(Context context, RouteListener routeListener,
                                FormReportView formView)
    {
        super(context, routeListener);
        this.setFormView(formView);

    }

    //getters and setters

    public Report getReport() {
        return report;
    }

    public EditReportController setReport(Report report) {
        this.report = report;
        return this;
    }

    public FormReportView getFormView() {
        return formView;
    }

    public EditReportController setFormView(FormReportView formView) {
        this.formView = formView;
        return this;
    }

    public void loadPratitionnerInView() {
        try {
            for (Pratitionner pratitionner : getApiClient().getPratitionners(getContext().getToken())) {
                formView.addPratitionners(pratitionner.getFirstName(), pratitionner.getId());
            }
        } catch (ServerError serverError) {
            getRouteListener().onError();
        }
    }

    public void loadReport(long id)
    {
        try {
            report = getApiClient().getRapportVisite(id, this.getContext().getToken());
            formView.setReport(report.getLabel(), report.getDate(), report.getPratitionner().getId(), new ArrayList<Long>(), report.getDescription());
        } catch (IOException | InterruptedException e) {
            getRouteListener().onError();
        }
    }

    @Override
    public void onSubmitReport(String description, List<Long> drugId, long prationerId, LocalDate value, String label) {
        //TODO
    }

    @Override
    public void userLoginSucess() {
        this.loadPratitionnerInView();
    }
}
