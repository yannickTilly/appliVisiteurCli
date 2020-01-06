package View.component;

import Listener.ConsultationRapportVisiteModelListener;
import Model.ConsultationRapportVisiteModel;
import Model.DrugPresentation;
import Model.Report;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class ConsultationRapportVisiteView extends AnchorPane implements ConsultationRapportVisiteModelListener {

    @FXML
    private Label description;

    @FXML
    private Label pratitionner;

    @FXML
    private Label region;

    @FXML
    private HBox drugPresentations;

    private ConsultationRapportVisiteModel consultationRapportVisiteModel;

    public ConsultationRapportVisiteView() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/consultationRapportVisite.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
            System.out.println("test");
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

    @Override
    public void onRapportVisiteChange(Report rapportVisite) {
        description.setText(rapportVisite.getDescription());
        pratitionner.setText(String.valueOf(rapportVisite.getPratitionner().getFirstName()));
        region.setText(rapportVisite.getRegion().getName());
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
}
