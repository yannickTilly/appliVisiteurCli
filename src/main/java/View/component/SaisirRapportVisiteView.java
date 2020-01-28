package View.component;

import Listener.NewReportListener;
import View.Structure.Prationner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class SaisirRapportVisiteView extends VBox implements Initializable {
    @FXML
    private ComboBox<Prationner> pratitionners;

    @FXML
    private MenuButton drugs;

    @FXML
    private TextArea description;

    @FXML
    private Button submit;

    @FXML
    private DatePicker date;

    private NewReportListener listener;

    List<Long> selectedDrugIds = new ArrayList<>();
    Hashtable<Long, String> pratitionnersIdName = new Hashtable<>();

    public SaisirRapportVisiteView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/saisirRapportVisite.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> submitReportHandler = e -> {
            onSubmit();
        };
        submit.setOnAction(submitReportHandler);
        List<CheckMenuItem> items = Arrays.asList(
        );
        drugs.getItems().addAll(items);
    }

    public long getPrationerId() {
        return pratitionners.getValue().getId();
    }

    public List<Long> getDrugIds() {
        return selectedDrugIds;
    }

    public String getDescription() {
        return description.getText();
    }

    public LocalDate getDate() {
        return date.getValue();
    }

    public void onSubmit()
    {
        listener.onSubmitNewReport(getDescription(), getDrugIds(), getPrationerId(), date.getValue());
    }

    public NewReportListener getListener() {
        return listener;
    }

    public void setListener(NewReportListener listener) {
        this.listener = listener;
    }

    public void addDrug(String name, Long id)
    {
        CheckMenuItem checkMenuItem = new CheckMenuItem();
        checkMenuItem.setText(name);
        drugs.getItems().add(checkMenuItem);
        checkMenuItem.selectedProperty().addListener((observableValue, oldValue, newValue) -> {
            if (newValue) {
                selectedDrugIds.add(id);
            } else {
                selectedDrugIds.remove(id);
            }
        });
    }

    public void addPratitionners(String name, Long id)
    {
        Prationner prationner = new Prationner();
        prationner
                .setId(id)
                .setName(name);
        pratitionners.getItems().add(prationner);
    }
}
