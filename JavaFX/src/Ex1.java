import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

public class Ex1 {


    public void start(Stage primaryStage) {
        Label label = new Label(
            "Layouts no JavaFX organizam os componentes visuais na tela.\n" +
            "Eles permitem alinhar e distribuir elementos de forma prática."
        );

        StackPane root = new StackPane();
        root.getChildren().add(label);

        Scene scene = new Scene(root, 400, 200);

        primaryStage.setTitle("Exemplo 1 - Conceito de Layouts");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
