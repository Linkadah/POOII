import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.StackPane;
import javafx.scene.paint.Color;
import javafx.scene.shape.Rectangle;
import javafx.stage.Stage;

public class Ex9 {
    public void start(Stage primaryStage) {
        StackPane stack = new StackPane();

        // Imagem de fundo
        ImageView imageView = new ImageView(new Image("https://via.placeholder.com/400x200"));
        imageView.setFitWidth(400);
        imageView.setFitHeight(200);

        // Retângulo semitransparente
        Rectangle rect = new Rectangle(400, 200, Color.rgb(0, 0, 0, 0.4));

        // Label no centro
        Label label = new Label("Título Sobreposto");
        label.setTextFill(Color.WHITE);

        stack.getChildren().addAll(imageView, rect, label);

        Scene scene = new Scene(stack, 400, 200);
        primaryStage.setTitle("Exemplo 9  StackPane com Sobreposição");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
