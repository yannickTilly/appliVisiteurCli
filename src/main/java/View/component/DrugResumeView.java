package View.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class DrugResumeView extends AnchorPane {
    @FXML
    private Label name;

    public DrugResumeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/drugResume.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public DrugResumeView setName(String drugName)
    {
        this.name.setText(drugName);
        return this;
    }
}
