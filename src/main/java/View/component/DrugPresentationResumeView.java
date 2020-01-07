package View.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;


public class DrugPresentationResumeView extends HBox {
    @FXML
    private Label drugName;

    public DrugPresentationResumeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/drugPresentationResume.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public DrugPresentationResumeView setDrugName(String drugName)
    {
        this.drugName.setText(drugName);
        return this;
    }
}
