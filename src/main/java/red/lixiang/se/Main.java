package red.lixiang.se;


import javafx.application.Application;
import javafx.stage.Stage;

/**
 * 启动参数添加： --module-path /Users/lixiang/soft/javafx-sdk-11/lib --add-modules=javafx.controls
 */
public class Main extends Application {

    public static void main(String[] args) {
        launch(args);
    }

    @Override
    public void start(Stage stage) throws Exception {
        stage.show();
    }
}