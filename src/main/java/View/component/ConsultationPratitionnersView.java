package View.component;

import Listener.ConsultationDrugsViewListener;
import Listener.ConsultationPratitionnerViewListener;
import View.Structure.Prationner;
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
import java.util.ResourceBundle;

public class ConsultationPratitionnersView extends AnchorPane implements Initializable {
    @FXML
    private VBox pratitionners;
    @FXML
    private Button searchButton;

    private ConsultationPratitionnerViewListener listener;

    // constructeur et initalisation
    public ConsultationPratitionnersView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/consultationPratitionners.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public void addPratitionner(String name)
    {
        try {
            PrationnerResumeView prationnerResumeView  = new PrationnerResumeView();
            prationnerResumeView.setName(name);
            pratitionners.getChildren().add(prationnerResumeView);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public void setListener(ConsultationPratitionnerViewListener listener) {
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
}
