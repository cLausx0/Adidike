import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        Image icon = new Image(getClass().getResourceAsStream("/view/Adidike.jpg"));
        primaryStage.getIcons().add(icon);

        FXMLLoader fxmlLoader = new FXMLLoader(getClass().getResource("/view/telaProdutos.fxml"));
        Parent root = fxmlLoader.load();
        Scene tela = new Scene(root, 900, 600);

        primaryStage.setTitle("ADIDIKE");
        primaryStage.setResizable(false);
        primaryStage.setScene(tela);
        primaryStage.show();

    }
}
