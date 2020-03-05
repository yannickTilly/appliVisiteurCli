package View.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.HBox;

import java.io.IOException;
import java.util.ArrayList;

public class RapportVisiteResumeView extends HBox {
    @FXML
    private Label label;

    @FXML
    private Button ouvrirRapport;

    public RapportVisiteResumeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/rapportVisiteResume.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public RapportVisiteResumeView setLabel(String label)
    {
        this.label.setText(label);
        return this;
    }

    public void setOnOuvrirRapport(EventHandler<ActionEvent> eventHandler)
    {
        ouvrirRapport.setOnAction(eventHandler);
    }
}
