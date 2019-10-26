package View.component;

import Listener.MenuListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView extends AnchorPane implements Initializable{

    @FXML
    private ConsultationRapportVisiteView consultationRapportVisiteView;
    @FXML
    private ConsultationRapportVisitesView consultationRapportVisitesView;
    @FXML
    private LoginView loginView;
    @FXML
    private SaisirRapportVisiteView saisirRapportVisiteView;
    @FXML
    private MenuView menuView;

    public static final int saisirRapportVisite = 330;
    public static final int login = 11;
    public static final int consultationRapportVisite = 20;
    public static final int consultationRapportVisites = 121;

    public MainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/main.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        this.loginView.setVisible(false);
        this.saisirRapportVisiteView.setVisible(false);
        this.consultationRapportVisitesView.setVisible(false);
        this.consultationRapportVisiteView.setVisible(false);
    }

    public void display(int component)
    {
        switch (component)
        {
            case MainView.login:
                loginView.setVisible(true);
                consultationRapportVisiteView.setVisible(false);
                consultationRapportVisitesView.setVisible(false);
                saisirRapportVisiteView.setVisible(false);
                break;
            case MainView.consultationRapportVisites:
                consultationRapportVisitesView.setVisible(true);
                loginView.setVisible(false);
                consultationRapportVisiteView.setVisible(false);
                saisirRapportVisiteView.setVisible(false);
                break;
            case MainView.consultationRapportVisite:
                consultationRapportVisiteView.setVisible(true);
                consultationRapportVisitesView.setVisible(false);
                loginView.setVisible(false);
                saisirRapportVisiteView.setVisible(false);
                break;
            case MainView.saisirRapportVisite:
                saisirRapportVisiteView.setVisible(true);
                loginView.setVisible(false);
                consultationRapportVisiteView.setVisible(false);
                consultationRapportVisitesView.setVisible(false);
                break;
        }
    }

    public void addMenuViewListener(MenuListener menuListener)
    {
        menuView.addListener(menuListener);
    }

    public ConsultationRapportVisiteView getConsultationRapportVisiteView() {
        return consultationRapportVisiteView;
    }

    public ConsultationRapportVisitesView getConsultationRapportVisitesView() {
        return consultationRapportVisitesView;
    }

    public LoginView getLoginView() {
        return loginView;
    }

    public SaisirRapportVisiteView getSaisirRapportVisiteView() {
        return saisirRapportVisiteView;
    }

    public MenuView getMenuView() {
        return menuView;
    }
}
