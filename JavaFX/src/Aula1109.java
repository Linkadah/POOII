import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;

public class Aula1109 {
    public void start(Stage primaryStage) {
        try {
            Label lblbt01 = new Label("Clique no botão para ver o resultado");
            Button btn01 = new Button("Clique aqui");

            // Evento do botão
            btn01.setOnAction(event -> {
                lblbt01.setText("Você clicou no botão");
            });

            VBox root = new VBox(10); // Espaçamento entre os elementos
            root.getChildren().addAll(lblbt01, btn01);

            Scene scene = new Scene(root, 400, 400);

            primaryStage.setTitle("Aula 11/09");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
