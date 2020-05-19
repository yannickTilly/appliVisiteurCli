package View.component;

import Listener.MenuListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Menu;
import javafx.scene.control.MenuBar;
import javafx.scene.control.MenuItem;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MenuView extends MenuBar implements Initializable{

    @FXML
    private MenuItem consulter;
    @FXML
    private MenuItem newReport;
    @FXML
    private MenuItem drugs;
    @FXML
    private MenuItem pratitionners;
    @FXML
    private MenuItem disconnect;

    private MenuListener listener;


    public MenuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Visitor/menu.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> consultHandler = e -> {
            onConsulterClick();
        };

        EventHandler<ActionEvent> newReportHandler = e -> {
            onNewReportClick();
        };
        EventHandler<ActionEvent> drugsHandler = e -> {
            onDrugsClick();
        };
        EventHandler<ActionEvent> pratitionnersHandler = e -> {
            onPraticionnersClick();
        };
        EventHandler<ActionEvent> disconnectHandler = e -> {
            onDisconnect();
        };

        pratitionners.setOnAction(pratitionnersHandler);
        consulter.setOnAction(consultHandler);
        newReport.setOnAction(newReportHandler);
        drugs.setOnAction(drugsHandler);
        disconnect.setOnAction(disconnectHandler);
    }

    public MenuListener getListener() {
        return listener;
    }

    public void setListener(MenuListener listener) {
        this.listener = listener;
    }

    public void onConsulterClick()
    {
        this.listener.onConsulterClicked();
    }

    public void onNewReportClick()
    {
        listener.onNewReportClicked();
    }

    private void onDrugsClick() {
        listener.onDrugsClicked();
    }

    private void onPraticionnersClick() {
        listener.onPratitionnersClicked();
    }

    private void onDisconnect(){ listener.onDisconect();}
}
