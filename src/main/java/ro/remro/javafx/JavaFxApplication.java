package ro.remro.javafx;

import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;
import net.rgielen.fxweaver.core.FxWeaver;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.context.ConfigurableApplicationContext;
import ro.remro.Main;
import ro.remro.sample.Controller;

public class JavaFxApplication extends Application {
    private ConfigurableApplicationContext applicationContext;

    @Override
    public void init() {
        String[] args = getParameters().getRaw().toArray(new String[0]);

        this.applicationContext = new SpringApplicationBuilder()
                .sources(Main.class)
                .run(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        FxWeaver fxWeaver = applicationContext.getBean(FxWeaver.class);
        Parent root = fxWeaver.loadView(Controller.class);
//        Scene scene = new Scene(root);
        primaryStage.setTitle("REMRO FLEET MANAGEMENT");
        primaryStage.setScene(new Scene(root, 700, 500));
        primaryStage.setMinHeight(600);
        primaryStage.setMaxHeight(800);
        primaryStage.setMinWidth(1200);
        primaryStage.setMaxWidth(1200);

        primaryStage.show();

//        Parent root = fxmlLoader.load(getClass().getClassLoader().getResourceAsStream("sample.fxml"));

    }

    @Override
    public void stop() {
        this.applicationContext.close();
        Platform.exit();
    }
}
