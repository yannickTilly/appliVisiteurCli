package View.component;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class SaisirRapportVisiteView extends AnchorPane {
    public SaisirRapportVisiteView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/saisirRapportVisite.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        System.out.println("test");
    }
}
