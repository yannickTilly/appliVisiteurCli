package Controller;

import Listener.MenuListener;
import Model.ConsultationRapportVisitesModel;
import Model.Context;
import View.component.ConsultationRapportVisitesView;
import View.component.LoginView;
import View.component.MainView;
import View.component.SaisirRapportVisiteView;

public class MainController extends BaseController implements MenuListener {
    private LoginController loginController;
    private MainView view;

    private LoginView loginView;

    private ConsultationRapportVisitesController consultationRapportVisitesController;

    private ConsultationRapportVisitesView consultationRapportVisitesView;

    private SaisirRapportVisiteView newReportView;

    private SaisieRapportVisiteController newReportController;

    public MainController(Context context, MainView view) {
        super(context);
        this.view = view;

        this.consultationRapportVisitesView = view.getConsultationReportsView();
        this.loginView = view.getLoginView();
        this.newReportView = view.getNewReportView();

        consultationRapportVisitesController = new ConsultationRapportVisitesController(getContext(),consultationRapportVisitesView);
        consultationRapportVisitesController.setConsultationRapportVisitesModel(new ConsultationRapportVisitesModel());
        loginController = new LoginController(getContext(),loginView);
        newReportController = new SaisieRapportVisiteController(getContext());
        newReportController.setNewReportView(newReportView);
        view.display(MainView.login);
        view.addMenuViewListener(this);
    }

    public MainView getView() {
        return view;
    }

    public MainController setView(MainView view) {
        this.view = view;
        return this;
    }

    @Override
    public void onConsulterClicked() {
        view.display(MainView.consultationRapportVisites);
    }

    @Override
    public void onNewReportClicked()
    {
        view.display(MainView.newReport);
    }
}
