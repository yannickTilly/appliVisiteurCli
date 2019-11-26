package Controller;


import Listener.NewReportListener;
import Model.Context;
import View.component.SaisirRapportVisiteView;
import javafx.event.ActionEvent;

public class SaisieRapportVisiteController extends BaseController implements NewReportListener {

    private SaisirRapportVisiteView newReportView;

    public SaisieRapportVisiteController(Context context) {
        super(context);
    }


    @Override
    public void onSubmitNewReport() {
        System.out.println("Clicked");
    }

    public SaisirRapportVisiteView getNewReportView() {
        return newReportView;
    }

    public SaisieRapportVisiteController setNewReportView(SaisirRapportVisiteView newReportView) {
        this.newReportView = newReportView;
        this.newReportView.addListener(this);
        return this;
    }
}
