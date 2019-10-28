package Controller;

import Listener.MenuListener;
import Listener.RouteListener;
import Model.ConsultationRapportVisiteModel;
import Model.ConsultationRapportVisitesModel;
import Model.Context;
import View.component.ConsultationRapportVisiteView;
import View.component.ConsultationRapportVisitesView;
import View.component.LoginView;
import View.component.MainView;

public class MainController extends BaseController implements MenuListener, RouteListener {
    private MainView view;
    private ConsultationRapportVisiteController consultationRapportVisiteController;

    public MainController(Context context, MainView view) {
        super(context, null);
        // vue principale
        this.view = view;

        // partie consultation rapportvisites
        ConsultationRapportVisitesView consultationRapportVisitesView = view.getConsultationRapportVisitesView();
        ConsultationRapportVisitesController consultationRapportVisitesController =
                new ConsultationRapportVisitesController(
                        getContext(),
                        this,
                        consultationRapportVisitesView);
        consultationRapportVisitesController
                .setConsultationRapportVisitesModel(new ConsultationRapportVisitesModel());

        // partie consultation rapportvisite
        ConsultationRapportVisiteView consultationRapportVisiteView = view.getConsultationRapportVisiteView();
        ConsultationRapportVisiteModel consultationRapportVisiteModel = new ConsultationRapportVisiteModel();
        consultationRapportVisiteController=
                new ConsultationRapportVisiteController(
                        context,
                        this,
                        consultationRapportVisiteModel,
                        consultationRapportVisiteView);

        // partie login
        LoginView loginView = view.getLoginView();
        LoginController loginController = new LoginController(getContext(), this, loginView);

        //premiére vue affichée
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
    public void onRequestConsultationRapportVisites() {
    }

    @Override
    public void onRequestConsultationRapport(Long idRapportVisite) {
        view.display(MainView.consultationRapportVisite);
        consultationRapportVisiteController.loadRapportVisite(idRapportVisite);
    }
}
