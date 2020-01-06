package View.component;

import Controller.ConsultationDrugsController;
import Listener.ConsultationDrugsModelListener;
import Listener.ConsultationDrugsViewListener;
import Listener.ConsultationRapportVisitesListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConsultationDrugsView extends AnchorPane implements ConsultationDrugsModelListener, Initializable {

    @FXML
    private VBox drugs;
    @FXML
    private Button searchButton;

    private ConsultationDrugsViewListener listener;

    // constructeur et initalisation
    public ConsultationDrugsView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/consultationDrugs.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public void addDrug(String name)
    {
        try {
            DrugResumeView drugResumeView  = new DrugResumeView();
            drugResumeView.setName(name);
            drugs.getChildren().add(drugResumeView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
    @Override
    public void onChangeModel() {

    }

    public void setListener(ConsultationDrugsViewListener listener) {
        this.listener = listener;
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> searchHandler = e -> {
            fireSearch();
        };
        searchButton.setOnAction(searchHandler);
    }

    private void fireSearch() {
        listener.onSearch("test");
    }

    public void clearDrug() {
        drugs.getChildren().clear();
    }
}
