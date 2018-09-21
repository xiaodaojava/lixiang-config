package sample;

import javafx.event.ActionEvent;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;


import java.util.HashMap;
import java.util.Map;

public class Controller {

    //货号
    private TextField sysNo;

    //颜色
    private TextField color;

    //尺码
    private TextField size;

    //数量，只在提交入库的时候使用
    private TextField number;

    //价格
    private TextField price;

    //提交打印
    private Button submitPrint;

    //提交入库
    private Button submitStock;

    private void submitPrintMethod(ActionEvent event){
        System.out.println("submitPrint has been clicked!!");
        String sysNoText = sysNo.getText();
        String priceText = price.getText();
        String colorText = color.getText();
        String sizeText = size.getText();
        String scanUrl = "http://m.admin.bbgkh.shop/sale/scanSale?" +
                "price="+priceText
                +"&sysNo="+sysNoText
                +"&size="+sizeText
                +"&color="+colorText;
        Map<String,String> map = new HashMap<>();
        map.put("sysNo",sysNoText);
        map.put("price",priceText);
        map.put("color",colorText);
        map.put("size",sizeText);
        map.put("scanUrl",scanUrl);

        try {
           // FreeToWord.createDoc(map,"tag");
        } catch (Exception e) {
            e.printStackTrace();
        }

    }

}
