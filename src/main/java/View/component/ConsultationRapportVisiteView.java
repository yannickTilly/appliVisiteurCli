package View.component;

import Listener.ConsultationRapportVisiteListener;
import Listener.ConsultationRapportVisiteModelListener;
import Listener.LoginListener;
import Model.ConsultationRapportVisiteModel;
import Model.DrugPresentation;
import Model.Report;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class ConsultationRapportVisiteView extends VBox implements ConsultationRapportVisiteModelListener {

    @FXML
    private Label description;

    @FXML
    private Label pratitionner;

    @FXML
    private Label region;

    @FXML
    private Label date;

    @FXML
    private HBox drugPresentations;

    @FXML
    private Button backSubmit;

    private ConsultationRapportVisiteListener listener;

    private ConsultationRapportVisiteModel consultationRapportVisiteModel;

    public ConsultationRapportVisiteView() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/consultationRapportVisite.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();

    }

    //getteur setteur


    public ConsultationRapportVisiteModel getConsultationRapportVisiteModel() {
        return consultationRapportVisiteModel;
    }

    public ConsultationRapportVisiteView setConsultationRapportVisiteModel(ConsultationRapportVisiteModel consultationRapportVisiteModel) {
        this.consultationRapportVisiteModel = consultationRapportVisiteModel;
        consultationRapportVisiteModel.addListener(this);
        return this;
    }

    public void onBackClick()
    {
        listener.onBackSubmit();
    }

    @Override
    public void onRapportVisiteChange(Report rapportVisite) {
        description.setText(rapportVisite.getDescription());
        pratitionner.setText(String.valueOf(rapportVisite.getPratitionner().getFirstName()));
        region.setText(rapportVisite.getRegion().getName());
        date.setText(rapportVisite.getDate().toString());
        drugPresentations.getChildren().clear();
        for(DrugPresentation drugPresentation : rapportVisite.getDrugPresentations())
        {
            try {
                DrugPresentationResumeView drugPresentationResumeView = new DrugPresentationResumeView();
                drugPresentationResumeView.setDrugName(drugPresentation.getDrug().getName());
                drugPresentations.getChildren().add(drugPresentationResumeView);
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }


    public ConsultationRapportVisiteListener getListener() {
        return listener;
    }

    public void setListener(ConsultationRapportVisiteListener listener) {
        this.listener = listener;
        EventHandler<ActionEvent> backHandler = e -> {
            onBackClick();
        };

        backSubmit.setOnAction(backHandler);
    }
}
