package View.component;

import Listener.FormReportListener;
import View.Structure.Pratitionner;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.layout.VBox;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.*;

public class FormReportView extends VBox implements Initializable {

    @FXML
    private TextField label;

    @FXML
    private ComboBox<Pratitionner> pratitionners;

    @FXML
    private MenuButton drugs;

    @FXML
    private TextArea description;

    @FXML
    private Button submit;

    @FXML
    private DatePicker date;

    private FormReportListener listener;

    List<Long> selectedDrugIds = new ArrayList<>();
    Hashtable<Long, String> pratitionnersIdName = new Hashtable<>();

    public FormReportView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Visitor/saisirRapportVisite.fxml"));
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

    public String getLabel() {
        return label.getText();
    }

    public FormReportView setLabel(TextField label) {
        this.label = label;
        return this;
    }

    public void removePratitionners(){
        pratitionners.getItems().clear();
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
        listener.onSubmitReport(getDescription(), getDrugIds(), getPrationerId(), date.getValue(), getLabel().toString());
    }

    public FormReportListener getListener() {
        return listener;
    }

    public void setListener(FormReportListener listener) {
        this.listener = listener;
    }

    public void addDrug(String name, Long id)
    {
        CheckMenuItem checkMenuItem = new CheckMenuItem();
        checkMenuItem.setText(name);
        checkMenuItem.setId(String.valueOf(id));
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
        Pratitionner prationner = new Pratitionner();
        prationner
                .setId(id)
                .setName(name);
        pratitionners.getItems().add(prationner);
    }

    public void setSelectedPratitionnersId(long id)
    {
        for (Pratitionner pratitionner :pratitionners.getItems())
        {
            if(id == pratitionner.getId())
            {
                pratitionners.setValue(pratitionner);
            }
        };
    }

    public void setReport(String label, LocalDate date, long practitionerId, ArrayList<Long> drugsId, String description)
    {
        this.label.setText(label);
        this.date.setValue(date);
        this.description.setText(description);
        setSelectedPratitionnersId(practitionerId);

    }

    public void removeDrugs() {
        drugs.getItems().clear();
    }

    public void setSelectedDrugsId(List<Long> drugsId) {
        for(MenuItem menuItem :drugs.getItems())
        {
            for (Long drugId : drugsId)
            {
                if(drugId.equals(Long.valueOf(menuItem.getId())))
                {
                    ((CheckMenuItem)menuItem).setSelected(true);
                    selectedDrugIds.add(drugId);
                }
            }
        }
    }
}
