package Controller;

import Controller.Base.BaseController;
import Controller.Delegate.*;
import Controller.Visitor.*;
import Listener.ContextListener;
import Listener.RouteListener;
import Model.*;
import View.component.*;

import java.io.IOException;

public class MainController extends BaseController implements RouteListener, ContextListener{
    private VisitorConsultationPratitionnersController visitorConsultationPratitionnersController;
    private MainView view;
    private LoginController loginController;
    private Controller.Visitor.VisitorConsultationReportController visitorConsultationReportController;
    private VisitorFormReportController visitorReportController;
    private VisitorEditReportController visitorEditReportController;
    private VisitorConsultationDrugsController visitorConsultationDrugsController;
    private VisitorConsultationReportsController visitorConsultationReportsController;
    private VisitorMenuController visitorMenuController;
    private DelegateMenuController delegateMenuController;
    private DelegateConsultationReportsController delegateConsultationReportsController;
    private DelegateConsultationReportController delegateConsultationReportController;
    private DelegateFormReportController delegateFormReportController;
    private DelegateConsultationDrugsController delegateConsultationDrugsController;
    private DelegateConsultationPratitionnersController delegateConsultationPratitionnersController;
    private DelegateEditReportController delegateEditReportController;

    public MainController(Context context, MainView view) {
        super(context, null);
        context.addListener(this);
        // vue principale
        this.view = view;
        // partie login
        LoginView loginView = null;
        try {
            loginView = new LoginView();
        } catch (IOException e) {
            e.printStackTrace();
        }
        loginController = new LoginController(getContext(), this, loginView);
        //premiére vue affichée
        view.setContainerView(loginController.getView());
    }

    public void onLogin()
    {
        if (context.getRole().equals("ROLE_VISITOR")) {
            // partie menu
            visitorMenuController = new VisitorMenuController(context, this);
            view.setMenuView(visitorMenuController.getView());
            // partie consultation rapportvisites
            visitorConsultationReportsController =
                    new VisitorConsultationReportsController(
                            getContext(),
                            this);
            visitorConsultationReportsController
                    .setConsultationRapportVisitesModel(new ConsultationRapportVisitesModel());

            // partie consultation rapportvisite
            ConsultationRapportVisiteModel consultationRapportVisiteModel = new ConsultationRapportVisiteModel();
            visitorConsultationReportController =
                    new VisitorConsultationReportController(
                            context,
                            this);
            //partie saisie rapport

            visitorReportController = new VisitorFormReportController(context, this);

            //partie edition de rapport
            visitorEditReportController = new VisitorEditReportController(context, this);

            //partie consultationView
            ConsultationDrugsModel consultationDrugsModel = new ConsultationDrugsModel();
            visitorConsultationDrugsController = new VisitorConsultationDrugsController(context, this, consultationDrugsModel);

            //partie consultation pratitiens
            ConsultationPratitionnersModel consultationPratitionnersModel = new ConsultationPratitionnersModel();
            visitorConsultationPratitionnersController = new VisitorConsultationPratitionnersController(context, this, consultationPratitionnersModel);
            view.setContainerView(visitorConsultationReportController.getView());
        } else if(context.getRole().equals("ROLE_DELEGATE")){

            delegateMenuController = new DelegateMenuController(context, this);
            view.setMenuView(delegateMenuController.getView());

            delegateConsultationReportsController = new DelegateConsultationReportsController(context, this);
            delegateConsultationReportsController
                    .setConsultationRapportVisitesModel(new ConsultationRapportVisitesModel());

            delegateConsultationReportController = new DelegateConsultationReportController(context, this);
            view.setContainerView(delegateConsultationReportsController.getView());

            delegateFormReportController = new DelegateFormReportController(context, this);
            delegateConsultationPratitionnersController = new DelegateConsultationPratitionnersController(context, this, new ConsultationPratitionnersModel());

            delegateConsultationDrugsController = new DelegateConsultationDrugsController(context, this, new ConsultationDrugsModel());

            delegateEditReportController = new DelegateEditReportController(context, this);
        }
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
        if (context.getRole().equals("ROLE_VISITOR")) {
            view.setContainerView(visitorConsultationReportsController.getView());
        }
        else if (context.getRole().equals("ROLE_DELEGATE")) {
            view.setContainerView(delegateConsultationReportsController.getView());
        }
    }

    @Override
    public void onReportConsultation(Long idRapportVisite) {
        if (context.getRole().equals("ROLE_VISITOR")) {
            visitorConsultationReportController.loadRapportVisite(idRapportVisite);
            view.setContainerView(visitorConsultationReportController.getView());
        }
        else if (context.getRole().equals("ROLE_DELEGATE")) {
            delegateConsultationReportController.loadRapportVisite(idRapportVisite);
            view.setContainerView(delegateConsultationReportController.getView());
        }
    }

    @Override
    public void onNewReport() {
        if (context.getRole().equals("ROLE_VISITOR")) {
            view.setContainerView(visitorReportController.getView());
        }
        else if (context.getRole().equals("ROLE_DELEGATE")) {
            view.setContainerView(delegateFormReportController.getView());
        }
    }

    @Override
    public void onError() {
        System.out.println("erreur dectecté (gestion à faire)");
    }

    @Override
    public void onDrugConsultation() {
        if (context.getRole().equals("ROLE_VISITOR")) {
            view.setContainerView(visitorConsultationDrugsController.getView());
        }
        else if (context.getRole().equals("ROLE_DELEGATE")) {
            view.setContainerView(delegateConsultationDrugsController.getView());
        }
    }

    @Override
    public void onPratitionners() {
        if (context.getRole().equals("ROLE_VISITOR")) {
            view.setContainerView(visitorConsultationPratitionnersController.getView());
        }
        else if (context.getRole().equals("ROLE_DELEGATE")) {
            view.setContainerView(delegateConsultationPratitionnersController.getView());
        }
    }

    @Override
    public void onReportEdit(long id) {
        if (context.getRole().equals("ROLE_VISITOR")) {
            visitorEditReportController.loadReport(id);
            view.setContainerView(visitorEditReportController.getView());
        }
        else if (context.getRole().equals("ROLE_DELEGATE")) {
            delegateEditReportController.loadReport(id);
            view.setContainerView(delegateEditReportController.getView());
        }
    }

    @Override
    public void onDisconnect() {
        view.setContainerView(loginController.getView());
        view.setMenuView(null);
        context = new Context();
        context.addListener(this);
        loginController.setContext(context);
    }

    @Override
    public void userLoginSucess() {
        onLogin();
    }
}
