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
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class SaisirRapportVisiteView extends AnchorPane implements Initializable {
//    @FXML
//    private Pratitionner pratitionnerId;
//
//    @FXML
//    private Collection<Drug> drugs;
//
//    @FXML
//    private TextArea note;
//
//    @FXML
//    private Button submitNewReport;

    private Collection<NewReportListener> listeners;

    public void addListener(NewReportListener newReportListener)
    {
        listeners.add(newReportListener);
    }
    public void removeListener(NewReportListener newReportListener)
    {
        listeners.remove(newReportListener);
    }


    public SaisirRapportVisiteView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/saisirRapportVisite.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        listeners = new ArrayList<>();
        System.out.println("test");
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> submitReportHandler = e -> {
            onSubmit();
        };

//        submitNewReport.setOnAction(submitReportHandler);
    }

    public void onSubmit()
    {
        fireOnSubmitNewReport();
    }

    private void fireOnSubmitNewReport()
    {

        for(NewReportListener listener : listeners) {
            listener.onSubmitNewReport();
        }
    }
}
