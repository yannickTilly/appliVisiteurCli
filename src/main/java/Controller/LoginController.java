package Controller;

import Listener.LoginListener;
import Listener.RouteListener;
import Model.Context;
import Model.Credential;
import Model.ResponseBody.AuthResponse;
import Util.ApiClient;
import View.component.LoginView;
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

    public LoginController(Context context, RouteListener routeListener, LoginView loginView) {
        super(context, routeListener);
        this.loginView = loginView;
        loginView.addListener(this);
    }

    @Override
    public void onSubmit(Credential credential)
    {
        System.out.println("Authentification ...");
        try {
            AuthResponse authResponse = apiClient.getToken(credential.getLogin(),credential.getPassword());
            getContext().setToken(authResponse.getToken());
            System.out.println(authResponse.toString());

        } catch (IOException e) {
            e.printStackTrace();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}