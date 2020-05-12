package View.component;

import Listener.LoginListener;
import Listener.MenuListener;
import Model.Credential;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;


import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;

public class LoginView extends VBox implements Initializable {
    private Collection<LoginListener> listeners;
    @FXML
    private Button submit;
    @FXML
    private TextField gsbLogin;
    @FXML
    private PasswordField password;

    public LoginView() throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../resources/login.fxml"));
        loader.setController(this);
        loader.setRoot(this);
        loader.load();
        listeners = new ArrayList<LoginListener>();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        EventHandler<ActionEvent> eventHandler = e -> {
            fireSubmit();
        };
        submit.setOnAction(eventHandler);
    }

    public void addListener(LoginListener loginListener)
    {
        listeners.add(loginListener);
    }

    public void removeListener(LoginListener loginListener)
    {
        listeners.remove(loginListener);
    }

    private void fireSubmit()
    {
        Credential credential = new Credential();
        credential.setPassword(password.getText());
        credential.setLogin(gsbLogin.getText());
        for(LoginListener listener : listeners) {
            listener.onSubmit(credential);
        }
    }

}
