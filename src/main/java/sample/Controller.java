package sample;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import utils.GenerateDoc;

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

    //提交入库
    @FXML
    private Button submitStock;

    @FXML
    private void submitPrintMethod(ActionEvent event){
        System.out.println("submitPrint has been clicked!!");
        String sysNoText = sysNo.getText();
        String priceText = price.getText();
        String colorText = color.getText();
        String sizeText = size.getText();
        try {
            GenerateDoc.createDoc(sysNoText,priceText,colorText,sizeText);
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
