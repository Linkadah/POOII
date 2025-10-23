import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex13 {
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();
        Label contador = new Label("0/140");

        textArea.textProperty().addListener((obs, oldVal, newVal) -> {
            if (newVal.length() > 140) {
                textArea.setText(oldVal); // bloqueia entrada extra
            } else {
                contador.setText(newVal.length() + "/140");
            }
        });

        VBox vbox = new VBox(10, contador, textArea);
        vbox.setPadding(new javafx.geometry.Insets(20));

        Scene scene = new Scene(vbox, 400, 200);
        primaryStage.setTitle("Exemplo 13 - Limite de Caracteres");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
