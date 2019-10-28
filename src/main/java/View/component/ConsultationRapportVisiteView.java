package View.component;

import Listener.ConsultationRapportVisiteModelListener;
import Model.ConsultationRapportVisiteModel;
import Model.RapportVisite;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ConsultationRapportVisiteView extends AnchorPane implements ConsultationRapportVisiteModelListener {

    @FXML
    private Label note;

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
    public void onRapportVisiteChange(RapportVisite rapportVisite) {
        note.setText(rapportVisite.getNote());
    }
}
