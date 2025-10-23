import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex11 {
    private int contador = 0;

    public void start(Stage primaryStage) {
        Label label = new Label("Cliques: 0");
        Button button = new Button("Conta Cliques");

        button.setOnAction(e -> {
            contador++;
            label.setText("Cliques: " + contador);
        });

        VBox vbox = new VBox(10, label, button);
        vbox.setPadding(new javafx.geometry.Insets(20));
        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setTitle("Exemplo 11 Contador de Cliques");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
