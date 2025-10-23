import javafx.beans.binding.Bindings;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex14 {
    public void start(Stage primaryStage) {
        Label label1 = new Label("Item 1");
        Label label2 = new Label("Item 2");
        Label label3 = new Label("Item 3");

        VBox vbox = new VBox(10, label1, label2, label3);
        HBox hbox = new HBox(10, label1, label2, label3);

        VBox root = new VBox();
        Scene scene = new Scene(root, 600, 200);

        root.getChildren().add(hbox);

        scene.widthProperty().addListener((obs, oldVal, newVal) -> {
            root.getChildren().clear();
            if (newVal.doubleValue() < 600) {
                root.getChildren().add(new VBox(10, label1, label2, label3));
            } else {
                root.getChildren().add(new HBox(10, label1, label2, label3));
            }
        });

        primaryStage.setTitle("Exemplo 14 - Layout Responsivo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
