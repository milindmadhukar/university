
import javafx.application.Application;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;

public class MyFirstJavaFX extends Application {

  @Override
  public void start(Stage primaryStage) {
    Button btOK = new Button("Ok");
    Scene scene = new Scene(btOK, 200, 500);
    primaryStage.setTitle("MyJavaFx");
    primaryStage.setScene(scene);
    primaryStage.show();
  }

  public static void main(String[] args) {
    launch(args);
  }
  
}
