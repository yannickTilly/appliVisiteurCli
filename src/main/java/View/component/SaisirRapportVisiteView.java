package View.component;

import Listener.NewReportListener;
import Model.Drug;
import Model.Pratitionner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ResourceBundle;

public class SaisirRapportVisiteView extends AnchorPane implements Initializable {
    @FXML
    private ComboBox<Pratitionner> pratitionner;

    @FXML
    private ComboBox<Drug> drug;

    @FXML
    private TextArea description;

    @FXML
    private Button submit;

    @FXML
    private DatePicker date;

    private NewReportListener listener;

    public SaisirRapportVisiteView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/saisirRapportVisite.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        System.out.println("test");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> submitReportHandler = e -> {
            onSubmit();
        };

        submit.setOnAction(submitReportHandler);
    }

    public long getPrationerId() {
        return Long.parseLong(String.valueOf(pratitionner.getValue()));
    }

    public long getDrugId() {
        return Long.parseLong(String.valueOf(drug.getValue()));
    }

    public String getDescription() {
        return description.getText();
    }

    public LocalDate getDate() {
        return date.getValue();
    }

    public void onSubmit()
    {
        listener.onSubmitNewReport(getDate(), getDescription(), getDrugId(), getPrationerId());
    }

    public NewReportListener getListener() {
        return listener;
    }

    public void setListener(NewReportListener listener) {
        this.listener = listener;
    }
}
