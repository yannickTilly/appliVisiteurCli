package View.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class VisitorPrationnerResumeView extends AnchorPane {
    @FXML
    private Label name;

    public VisitorPrationnerResumeView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/Visitor/pratitionnerResume.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    public VisitorPrationnerResumeView setName(String drugName)
    {
        this.name.setText(drugName);
        return this;
    }
}
