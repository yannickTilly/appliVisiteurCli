package View.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.util.ArrayList;

public class RapportVisiteResumeView extends AnchorPane {
    @FXML
    private Label note;

    @FXML
    private Button ouvrirRapport;

    public RapportVisiteResumeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/rapportVisiteResume.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public RapportVisiteResumeView setNote(String note)
    {
        this.note.setText(note);
        return this;
    }

    public void setOnOuvrirRapport(EventHandler<ActionEvent> eventHandler)
    {
        ouvrirRapport.setOnAction(eventHandler);
    }
}
