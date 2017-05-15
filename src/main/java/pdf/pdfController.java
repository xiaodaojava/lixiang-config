package pdf;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.ScrollPane;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import utils.ReadPdf;



/**
 * Created by ASUS on 2017/5/15.
 */
public class pdfController {

    @FXML
    private TextArea pdfText;

    @FXML
    private Button readPdf;

    @FXML
    private void readPdf(ActionEvent event){
        pdfText.setText(ReadPdf.read(""));

    }
}
