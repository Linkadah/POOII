import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex6 {
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();
        Label centerLabel = new Label("Conteúdo Inicial");
        borderPane.setCenter(centerLabel);

        VBox menu = new VBox(10);
        for (int i = 1; i <= 4; i++) {
            int index = i;
            Button btn = new Button("Menu " + index);
            btn.setOnAction(e -> borderPane.setCenter(new Label("Conteúdo " + index)));
            menu.getChildren().add(btn);
        }

        borderPane.setLeft(menu);
        borderPane.setTop(new Label("Toolbar"));
        borderPane.setBottom(new Label("Status"));

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("Exemplo 6 - BorderPane Dinâmico");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
