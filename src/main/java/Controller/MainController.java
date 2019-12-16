package Controller;

import Listener.RouteListener;
import Model.ConsultationRapportVisiteModel;
import Model.ConsultationRapportVisitesModel;
import Model.Context;
import View.component.*;

public class MainController extends BaseController implements RouteListener {
    private MainView view;
    private ConsultationReportController consultationReportController;
    private MenuController menuController;
    private NewReportController newReportController;

    public MainController(Context context, MainView view) {
        super(context, null);
        // vue principale
        this.view = view;
        // partie menu
        MenuController menuController = new MenuController(context, this, view.getMenuView());
        // partie consultation rapportvisites
        ConsultationRapportVisitesView consultationRapportVisitesView = view.getConsultationReportsView();
        ConsultationReportsController consultationReportsController =
                new ConsultationReportsController(
                        getContext(),
                        this,
                        consultationRapportVisitesView);
        consultationReportsController
                .setConsultationRapportVisitesModel(new ConsultationRapportVisitesModel());

        // partie consultation rapportvisite
        ConsultationRapportVisiteView consultationRapportVisiteView = view.getConsultationReportView();
        ConsultationRapportVisiteModel consultationRapportVisiteModel = new ConsultationRapportVisiteModel();
        consultationReportController =
                new ConsultationReportController(
                        context,
                        this,
                        consultationRapportVisiteModel,
                        consultationRapportVisiteView);
        //partie saisie rapport

        SaisirRapportVisiteView saisirRapportVisiteView = view.getNewReportView();
        newReportController = new NewReportController(context,this, saisirRapportVisiteView);
        // partie login
        LoginView loginView = view.getLoginView();
        LoginController loginController = new LoginController(getContext(), this, loginView);

        //premiére vue affichée
        view.display(MainView.login);
    }

    public MainView getView() {
        return view;
    }

    public MainController setView(MainView view) {
        this.view = view;
        return this;
    }


    // gestion des "routes "terme a revoir
    @Override
    public void onReportConsultations() {
        view.display(MainView.consultationRapportVisites);
    }

    @Override
    public void onReportConsultation(Long idRapportVisite) {
        view.display(MainView.consultationRapportVisite);
        consultationReportController.loadRapportVisite(idRapportVisite);
    }

    @Override
    public void onNewReport() {
        view.display(MainView.newReport);
    }

    @Override
    public void onError() {
        System.out.println("erreur dectecté (gestion à faire)");
    }

    @Override
    public void onDrugConsultation() {
        view.display(MainView.consultationDrugs);
    }
}
