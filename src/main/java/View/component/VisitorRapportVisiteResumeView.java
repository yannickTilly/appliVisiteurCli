package View.component;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;

import java.io.IOException;

public class VisitorRapportVisiteResumeView extends HBox {
    @FXML
    private Label label;

    @FXML
    private Button ouvrirRapport;

    @FXML
    private Button editReport;

    @FXML
    private Button deleteReport;


    public VisitorRapportVisiteResumeView() throws IOException
    {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Visitor/rapportVisiteResume.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public VisitorRapportVisiteResumeView setLabel(String label)
    {
        this.label.setText(label);
        return this;
    }

    public void setOnOuvrirRapport(EventHandler<ActionEvent> eventHandler)
    {
        ouvrirRapport.setOnAction(eventHandler);
    }

    public void setOnEditReport(EventHandler<ActionEvent> eventHandler)
    {
        editReport.setOnAction(eventHandler);
    }

    public void setOnDeleteReport(EventHandler<ActionEvent> eventHandler)
    {
        deleteReport.setOnAction(eventHandler);
    }
}
