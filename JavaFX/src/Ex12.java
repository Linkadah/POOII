import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex12 {
    public void start(Stage primaryStage) {
        Label aviso = new Label("números");
        TextField textField = new TextField();

        textField.textProperty().addListener((obs, oldVal, newVal) -> {
            if (!newVal.matches("\\d*")) {
                textField.setText(newVal.replaceAll("[^\\d]", ""));
            }
        });

        VBox vbox = new VBox(10, aviso, textField);
        vbox.setPadding(new javafx.geometry.Insets(20));
        vbox.setAlignment(javafx.geometry.Pos.CENTER);

        Scene scene = new Scene(vbox, 300, 150);
        primaryStage.setTitle("Exemplo 12 Validação Numérica");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
