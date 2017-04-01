package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

public class Controller {
    @FXML
    private Button submitPrint;

    @FXML
    private void submitPrintMethod(ActionEvent event){
        System.out.println("submitPrint has been clicked");
    }

}
