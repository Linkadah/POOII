import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex5 {
    public void start(Stage primaryStage) {
        BorderPane borderPane = new BorderPane();

        // Top
        VBox toolbar = new VBox(new Button("Toolbar"));
        toolbar.setPadding(new Insets(10));
        borderPane.setTop(toolbar);


        VBox menu = new VBox(10);
        menu.setPadding(new Insets(10));
        menu.getChildren().addAll(
            new Button("Menu 1"),
            new Button("Menu 2"),
            new Button("Menu 3"),
            new Button("Menu 4")
        );
        borderPane.setLeft(menu);

   
        borderPane.setCenter(new Label("Área de trabalho"));
        borderPane.setBottom(new Label("Status"));

        Scene scene = new Scene(borderPane, 400, 300);
        primaryStage.setTitle("Exemplo 5 - BorderPane Esqueleto");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
