package Listener;

import java.util.EventListener;

public interface MenuListener extends EventListener {
    void onConsulterClicked();
    void onNewReportClicked();
    void onDrugsClicked();
    void onPratitionnersClicked();
    void onDisconect();
}
