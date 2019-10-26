package View.component;

import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class ConsultationRapportVisiteView extends AnchorPane{
    public ConsultationRapportVisiteView() throws IOException {
            FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/consultationRapportVisite.fxml"));
            loader.setController(this);
            loader.setRoot(this);
            loader.load();
            System.out.println("test");
    }
    public static void main(String[] args) throws IOException, InterruptedException {
    ConsultationRapportVisiteView consultationRapportVisiteComponent = new ConsultationRapportVisiteView();
    }
}
