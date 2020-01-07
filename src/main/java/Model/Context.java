package Model;

import Listener.ContextListener;

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
        return token;
    }
    public Context setToken(String token) {
        this.token = token;
        fireUserLoginSucess();
        return this;
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
