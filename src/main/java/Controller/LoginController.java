package Controller;

import Listener.LoginListener;
import Model.Context;
import Model.Credential;
import Util.ApiClient;
import View.component.LoginView;
import View.component.MenuView;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class LoginController extends BaseController implements LoginListener {

    private static ApiClient apiClient =  new ApiClient();
    private LoginView loginView;
    @FXML
    private PasswordField password;

    @FXML
    private TextField gsbLogin;


    public LoginController(Context context, LoginView loginView) {
        super(context);
        this.loginView = loginView;
        loginView.addListener(this);
    }

    @Override
    public void onSubmit(Credential credential)
    {
        System.out.println("get token");
        try {
            String response = apiClient.getToken(credential.getLogin(),credential.getPassword());
            getContext().setToken(response);

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}