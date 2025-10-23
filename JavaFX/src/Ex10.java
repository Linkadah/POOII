import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class Ex10 {
    public void start(Stage primaryStage) {
        TextArea textArea = new TextArea();

        AnchorPane root = new AnchorPane(textArea);
        AnchorPane.setTopAnchor(textArea, 10.0);
        AnchorPane.setRightAnchor(textArea, 10.0);
        AnchorPane.setBottomAnchor(textArea, 10.0);
        AnchorPane.setLeftAnchor(textArea, 10.0);

        Scene scene = new Scene(root, 400, 300);
        primaryStage.setTitle("Exemplo 10  AnchorPane com Margem");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
