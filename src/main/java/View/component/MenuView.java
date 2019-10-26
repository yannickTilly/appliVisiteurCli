package View.component;

import Listener.MenuListener;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.MenuItem;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class MenuView extends AnchorPane implements Initializable{

    @FXML
    private MenuItem consulter;
    @FXML
    private MenuItem saisir;
    private Collection<MenuListener> listeners;

    public void addListener(MenuListener menuListener)
    {
        listeners.add(menuListener);
    }
    public void removeListener(MenuListener menuListener)
    {
        listeners.remove(menuListener);
    }

    public MenuView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/menu.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        listeners = new ArrayList<MenuListener>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> eventHandler = e -> {
            onConsulterClick();
        };
        consulter.setOnAction(eventHandler);
    }

    public void onConsulterClick()
    {
        fireConsulterCliked();
    }

    private void fireConsulterCliked()
    {
        for(MenuListener listener : listeners) {
            listener.onConsulterClicked();
        }
    }
}
