import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class Aula1809 {
    public void start(Stage primaryStage) {
        try {
            //Criar botões
            Button btnInfo = new Button("Mostrar Informação");
            btnInfo.setOnAction(event -> mostrarAlerta(AlertType.INFORMATION, "Informação", "Alerta de Mensagem"));
            
            Button btnWarn = new Button("Mostrar Aviso");
            btnInfo.setOnAction(event -> mostrarAlerta(AlertType.WARNING, "Aviso", "Alerta de aviso!"));

            Button btnError = new Button("Mostrar Erro");
            btnInfo.setOnAction(event -> mostrarAlerta(AlertType.ERROR, "Erro", "Alerta de erro!!!"));

            Button btnConfirmation = new Button("Mostrar Confirmação");
            btnInfo.setOnAction(event -> mostrarAlerta(AlertType.CONFIRMATION, "Confirmação", "Alerta de Comfirmação!!!"));

            //Layout Vbox
            VBox vbox = new VBox(10);

            vbox.getChildren().addAll(btnInfo, btnWarn, btnError, btnConfirmation);

            //Cria a cena
            Scene scene = new Scene(vbox, 400, 400);

            //STAGE
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    private void mostrarAlerta(AlertType alertType, String titulo, String msg){
        Alert alerta = new Alert(alertType);

        alerta.setTitle(titulo);
        alerta.setHeaderText(null);
        alerta.setContentText(msg);
        alerta.showAndWait();
    }
}
