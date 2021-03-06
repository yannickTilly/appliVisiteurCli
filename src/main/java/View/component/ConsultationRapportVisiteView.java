package View.component;

import Listener.ConsultationRapportVisiteListener;
import Listener.ConsultationRapportVisiteModelListener;
import Model.ConsultationRapportVisiteModel;
import Model.DrugPresentation;
import Model.Report;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;

import java.io.IOException;

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

    @FXML
    private Button editReport;

    @FXML
    private Button deleteReport;

    private ConsultationRapportVisiteListener listener;

    private ConsultationRapportVisiteModel consultationRapportVisiteModel;

    public ConsultationRapportVisiteView() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Visitor/consultationRapportVisite.fxml"));
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
        EventHandler<ActionEvent> deleteHandler = e -> {
            listener.onDelete();
        };
        EventHandler<ActionEvent> editHandler = e -> {
            listener.onEdit();
        };

        backSubmit.setOnAction(backHandler);
        editReport.setOnAction(editHandler);
        deleteReport.setOnAction(deleteHandler);
    }
}
