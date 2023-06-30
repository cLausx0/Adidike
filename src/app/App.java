package app;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

public class App extends Application {

    private static Stage stage;
    private static Scene produtosScene;
    private static Scene clientesScene;
    private static Scene vendasScene;
    private static Scene relatoriosScene;

    public static void main(String[] args) throws Exception {
        launch(args);
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        stage = primaryStage;

        Image icon = new Image(getClass().getResourceAsStream("/view/Adidike.jpg"));
        primaryStage.getIcons().add(icon);

        Parent fxmlProdutos = FXMLLoader.load(getClass().getResource("/view/telaProdutos.fxml"));
        produtosScene = new Scene(fxmlProdutos, 900, 600);

        Parent fxmlClientes = FXMLLoader.load(getClass().getResource("/view/telaClientes.fxml"));
        clientesScene = new Scene(fxmlClientes, 900, 600);

        Parent fxmlVendas = FXMLLoader.load(getClass().getResource("/view/telaVendas.fxml"));
        vendasScene = new Scene(fxmlVendas, 900, 600);

        Parent fxmlRelatorios = FXMLLoader.load(getClass().getResource("/view/telaRelatorios.fxml"));
        relatoriosScene = new Scene(fxmlRelatorios, 900, 600);


        primaryStage.setTitle("ADIDIKE");
        primaryStage.setResizable(false);
        primaryStage.setScene(produtosScene);
        primaryStage.show();

    }

    public static void mudarTela(String tela) {
        switch (tela) {
            case "produtos":
                stage.setScene(produtosScene);
                break;
            case "clientes":
                stage.setScene(clientesScene);
                break;
            case "vendas":
                stage.setScene(vendasScene);
                break;
            case "relatorios":
                stage.setScene(relatoriosScene);
                break;
        }
    }
}
