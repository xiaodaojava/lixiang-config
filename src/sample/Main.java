package sample;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //加载资源文件,用于定义界面
        Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        //整个窗体的设置
        primaryStage.setTitle("WorldToImage");
        primaryStage.setScene(new Scene(root, 300, 275));
        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
