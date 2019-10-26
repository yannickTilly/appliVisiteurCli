package Listener;

import Model.Credential;

import java.util.EventListener;

public interface LoginListener extends EventListener{
    void onSubmit(Credential credential);
}
