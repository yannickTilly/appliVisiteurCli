import Controller.MainController;
import Model.Context;
import View.component.MainView;
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;


public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        StackPane root = new StackPane();
        MainView mainView = new MainView();
        root.getChildren().add(mainView);
        primaryStage.setTitle("appliVisiteur");
        primaryStage.setScene(new Scene(root, 800, 600));
        primaryStage.show();
        Context context = new Context();
        MainController mainController= new MainController(context, mainView);
    }

    public static void main(String[] args) {
        launch(args);
    }
}
