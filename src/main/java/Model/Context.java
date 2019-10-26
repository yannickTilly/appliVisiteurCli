package Model;

import Listener.ContextListener;

import javax.swing.event.EventListenerList;
import java.awt.event.ActionListener;
import java.util.Collection;
import java.util.Observable;

public class Context {
    private final EventListenerList listeners = new EventListenerList();

    private String token;

    private boolean userIslog;

    private Long rapportVisteCourantId;

    public boolean isUserIslog() {
        return userIslog;
    }

    public Context setUserIslog(boolean userIslog) {
        this.userIslog = userIslog;
        return this;
    }

    public Long getRapportVisteCourantId() {
        return rapportVisteCourantId;
    }

    public Context setRapportVisteCourantId(Long rapportVisteCourantId) {
        this.rapportVisteCourantId = rapportVisteCourantId;
        fireRapportVisiteCourantChange();
        return this;
    }

    public Context()
    {
        userIslog = false;
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
        listeners.add(ContextListener.class, contextListener);
    }
    public void removeListener(ContextListener contextListener)
    {
        listeners.remove(ContextListener.class, contextListener);
    }
    private void fireUserLoginSucess()
    {
        for(ContextListener listener : listeners.getListeners(ContextListener.class)) {
            listener.userLoginSucess();
        }
    }
    private void fireRapportVisiteCourantChange()
    {
        for(ContextListener listener : listeners.getListeners(ContextListener.class)) {
            listener.rapportVisiteCourantChange();
        }
    }
}
