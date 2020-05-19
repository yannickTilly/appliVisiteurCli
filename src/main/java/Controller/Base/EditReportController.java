package Controller.Base;

import Listener.ContextListener;
import Listener.FormReportListener;
import Listener.RouteListener;
import Model.*;
import Model.RequestBody.ReportBody;
import Util.ApiClient;
import View.component.FormReportView;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class EditReportController extends BaseController implements FormReportListener, ContextListener {
    private Report report;
    private FormReportView formView;
    private static ApiClient apiClient = new ApiClient();

    //constructeur
    public EditReportController(Context context, RouteListener routeListener)
    {
        super(context, routeListener);
        try {
            formView = new FormReportView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        this.setFormView(formView);
        formView.setListener(this);

    }

    //getters and setters

    public FormReportView getView(){
        formView.removePratitionners();
        formView.removeDrugs();
        this.loadPratitionnerInView();
        this.loadDrugsInView();
        formView.setSelectedPratitionnersId(report.getPratitionner().getId());
        List<Long> drugsId = new ArrayList<>();
        for(DrugPresentation drugPresentation : report.getDrugPresentations())
        {
            drugsId.add(drugPresentation.getDrug().getId());
        }
        formView.setSelectedDrugsId(drugsId);
        return formView;
    }
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
        } catch (IOException serverError) {
            getRouteListener().onError();
        }
    }

    public void loadDrugsInView() {
        try {
            for (Drug drug : getApiClient().getDrugs(getContext().getToken())) {
                formView.addDrug(drug.getName(), drug.getId());
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public void loadReport(long id)
    {
        try {
            this.loadPratitionnerInView();
            report = getApiClient().getRapportVisite(id, this.getContext().getToken());
            formView.setReport(report.getLabel(), report.getDate(), report.getPratitionner().getId(), new ArrayList<Long>(), report.getDescription());
        } catch (IOException | InterruptedException e) {
            getRouteListener().onError();
        }
    }

    @Override
    public void onSubmitReport(String description, List<Long> drugId, long prationerId, LocalDate value, String label) {
        ReportBody reportBody = new ReportBody();
        reportBody.setDate(value.toString());
        reportBody.setLabel(label);
        reportBody.setMedicamentIds(drugId);
        reportBody.setPraticienId(prationerId);
        reportBody.setNote(description);
        getApiClient().patchReport(reportBody, report.getId(), getContext().getToken());
    }

    @Override
    public void userLoginSucess() {
    }
}
