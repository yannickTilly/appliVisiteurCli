package Model;

import Listener.ContextListener;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.sun.javafx.property.adapter.PropertyDescriptor;

import javax.swing.event.EventListenerList;
import java.awt.event.ActionListener;
import java.util.*;

public class Context {
    private List<ContextListener> contextListeners;

    private String token;

    public Context()
    {
        contextListeners = new ArrayList<>();
    }
    public String getToken() {
        return token.toString();
    }
    public Context setToken(String token) {
        this.token = token;
        fireUserLoginSucess();
        return this;
    }
    public String getRole()
    {
        DecodedJWT decodedJWT = JWT.decode(token);
        return decodedJWT.getClaim("role").asString();
    }
    public void addListener(ContextListener contextListener)
    {
        contextListeners.add(contextListener);
    }
    public void removeListener(ContextListener contextListener)
    {
        contextListeners.remove(contextListener);
    }
    private void fireUserLoginSucess()
    {
        List<ContextListener> copyContextListeners = new ArrayList<>(contextListeners);
        for (ContextListener contextListener : copyContextListeners) {
            contextListener.userLoginSucess();
        }
    }
}
