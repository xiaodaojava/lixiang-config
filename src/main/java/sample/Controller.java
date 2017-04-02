package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;

public class Controller {

    //货号
    @FXML
    private TextField sysNo;

    //颜色
    @FXML
    private TextField color;

    //尺码
    @FXML
    private TextField size;

    //数量，只在提交入库的时候使用
    @FXML
    private TextField number;

    //价格
    @FXML
    private TextField price;

    //提交打印
    @FXML
    private Button submitPrint;

    @FXML
    private Button submitStock;

    @FXML
    private void submitPrintMethod(ActionEvent event){
        System.out.println("submitPrint has been clicked!!");

        System.out.println(price.getText());
    }

}
