package View.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class PrationnerResumeView extends AnchorPane {
    @FXML
    private Label name;

    public PrationnerResumeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/pratitionnerResume.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public PrationnerResumeView setName(String drugName)
    {
        this.name.setText(drugName);
        return this;
    }
}
