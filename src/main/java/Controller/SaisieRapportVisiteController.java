package Controller;


import Listener.NewReportListener;
import Listener.RouteListener;
import Model.Context;
import Model.RequestBody.ReportBody;
import View.component.SaisirRapportVisiteView;
import javafx.event.ActionEvent;

import java.time.LocalDate;

public class SaisieRapportVisiteController extends BaseController implements NewReportListener {
    private SaisirRapportVisiteView view;
    public SaisieRapportVisiteController(Context context, RouteListener routeListener, SaisirRapportVisiteView saisirRapportVisiteView) {
        super(context, routeListener);
        view = saisirRapportVisiteView;
        view.setListener(this);
    }

    public void onSubmit(ActionEvent actionEvent)
    {
        System.out.println("aaaaaaa");
    }

    @Override
    public void onSubmitNewReport(LocalDate date, String description, long drugId, long prationerId) {
        System.out.println("soumission rapport ...");
        ReportBody reportBody = new ReportBody();
    }
}
