import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex4 {
    public void start(Stage primaryStage) {
        HBox toolbar = new HBox(10);
        toolbar.setAlignment(Pos.CENTER);
        toolbar.getChildren().addAll(
            new Button("Novo"),
            new Button("Abrir"),
            new Button("Salvar")
        );

        Label content = new Label("Conteúdo principal aqui.");
        VBox root = new VBox(20);
        root.setPadding(new Insets(20));
        root.getChildren().addAll(toolbar, content);

        Scene scene = new Scene(root, 400, 200);
        primaryStage.setTitle("Exemplo 4  VBox com Toolbar e Conteúdo");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
