package View.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView extends BorderPane implements Initializable{

    @FXML
    private ConsultationRapportVisiteView consultationReportView;
    @FXML
    private ConsultationRapportVisitesView consultationReportsView;
    @FXML
    private LoginView loginView;
    @FXML
    private SaisirRapportVisiteView newReportView;
    @FXML
    private MenuView menuView;
    @FXML
    private ConsultationDrugsView consultationDrugsView;
    @FXML
    private ConsultationPratitionnersView consultationPratitionnersView;

    public static final int newReport = 330;
    public static final int login = 11;
    public static final int consultationRapportVisite = 20;
    public static final int consultationRapportVisites = 121;
    public static final int consultationDrugs = 836;
    public static final int consultationPratitionners = 613;

    public MainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/main.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loginView.setVisible(false);
        this.newReportView.setVisible(false);
        this.consultationReportsView.setVisible(false);
        this.consultationReportView.setVisible(false);
    }

    public void display(int component)
    {
        switch (component)
        {
            case MainView.login:
                loginView.setVisible(true);
                consultationReportView.setVisible(false);
                consultationReportsView.setVisible(false);
                newReportView.setVisible(false);
                consultationDrugsView.setVisible(false);
                consultationPratitionnersView.setVisible(false);
                break;
            case MainView.consultationRapportVisites:
                consultationReportsView.setVisible(true);
                loginView.setVisible(false);
                consultationReportView.setVisible(false);
                newReportView.setVisible(false);
                consultationDrugsView.setVisible(false);
                consultationPratitionnersView.setVisible(false);
                break;
            case MainView.consultationRapportVisite:
                consultationReportView.setVisible(true);
                consultationReportsView.setVisible(false);
                loginView.setVisible(false);
                newReportView.setVisible(false);
                consultationDrugsView.setVisible(false);
                consultationPratitionnersView.setVisible(false);
                break;
            case MainView.newReport:
                newReportView.setVisible(true);
                loginView.setVisible(false);
                consultationReportView.setVisible(false);
                consultationReportsView.setVisible(false);
                consultationDrugsView.setVisible(false);
                consultationPratitionnersView.setVisible(false);
                break;
            case MainView.consultationDrugs:
                newReportView.setVisible(false);
                loginView.setVisible(false);
                consultationReportView.setVisible(false);
                consultationReportsView.setVisible(false);
                consultationDrugsView.setVisible(true);
                consultationPratitionnersView.setVisible(false);
                break;
            case MainView.consultationPratitionners:
                newReportView.setVisible(false);
                loginView.setVisible(false);
                consultationReportView.setVisible(false);
                consultationReportsView.setVisible(false);
                consultationDrugsView.setVisible(false);
                consultationPratitionnersView.setVisible(true);
                break;
        }
    }

    public ConsultationRapportVisiteView getConsultationReportView() {
        return consultationReportView;
    }

    public ConsultationRapportVisitesView getConsultationReportsView() {
        return consultationReportsView;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public SaisirRapportVisiteView getNewReportView() {
        return newReportView;
    }

    public MenuView getMenuView() {
        return menuView;
    }

    public ConsultationDrugsView getConsulatationDrugsView() {
        return consultationDrugsView;
    }

    public ConsultationPratitionnersView getConsultationPratitionnersView() {
        return consultationPratitionnersView;
    }
}
