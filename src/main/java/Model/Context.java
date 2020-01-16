package Model;

import Listener.ContextListener;
import com.auth0.jwt.JWT;
import com.auth0.jwt.interfaces.DecodedJWT;

import javax.swing.event.EventListenerList;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.Collection;
import java.util.List;
import java.util.Observable;

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
        for(ContextListener listener : contextListeners) {
            listener.userLoginSucess();
        }
    }
}
