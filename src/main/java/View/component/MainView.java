package View.component;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class MainView extends BorderPane implements Initializable{

    @FXML
    private StackPane container;

    public static final int newReport = 330;
    public static final int editReport = 616;
    public static final int login = 11;
    public static final int consultationRapportVisite = 20;
    public static final int consultationRapportVisites = 121;
    public static final int consultationDrugs = 836;
    public static final int consultationPratitionners = 613;

    public MainView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/main.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
    }

    public void setContainerView(Node e){
        container.getChildren().clear();
        container.getChildren().add(e);
    }
    public void display(int consultationRapportVisites) {
    }

    public void setMenuView(Node node)
    {
        this.setTop(node);
    }
}
