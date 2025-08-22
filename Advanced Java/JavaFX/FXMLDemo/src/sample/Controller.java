package sample;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;

public class Controller {
    @FXML
    private Label label;

    @FXML
    private void handleButtonClick(ActionEvent event) {
        label.setText("Button Clicked!");
    }
}
