package View.component;

import Listener.MenuListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class MenuView extends AnchorPane implements Initializable{

    @FXML
    private MenuItem consulter;
    @FXML
    private MenuItem newReport;
    @FXML
    private MenuItem drugs;

    private MenuListener listener;


    public MenuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/menu.fxml"));
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

        consulter.setOnAction(consultHandler);
        newReport.setOnAction(newReportHandler);
        drugs.setOnAction(drugsHandler);
    }

    public MenuListener getListener() {
        return listener;
    }

    public void setListener(MenuListener listener) {
        this.listener = listener;
    }

    public void onConsulterClick()
    {
        listener.onConsulterClicked();
    }

    public void onNewReportClick()
    {
        listener.onNewReportClicked();
    }

    private void onDrugsClick() {
        listener.onDrugsClicked();
    }
}
