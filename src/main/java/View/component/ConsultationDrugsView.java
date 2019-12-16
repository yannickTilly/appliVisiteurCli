package View.component;

import Listener.ConsultationDrugsModelListener;
import Listener.ConsultationRapportVisitesListener;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.util.ArrayList;

public class ConsultationDrugsView extends AnchorPane implements ConsultationDrugsModelListener {

    @FXML
    private VBox drugs;

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
}
