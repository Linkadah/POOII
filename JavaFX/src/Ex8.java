import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.*;
import javafx.scene.layout.*;
import javafx.stage.Stage;

public class Ex8 {
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Observações:"), 0, 0);
        TextArea textArea = new TextArea();
        grid.add(textArea, 0, 1, 2, 1); 

        // Botão  à direita
        HBox hbox = new HBox();
        hbox.setPadding(new Insets(10, 0, 0, 0));
        hbox.setAlignment(javafx.geometry.Pos.CENTER_RIGHT);
        hbox.getChildren().add(new Button("Salvar"));
        grid.add(hbox, 0, 2, 2, 1); 

        Scene scene = new Scene(grid, 400, 250);
        primaryStage.setTitle("Exemplo 8 - GridPane com Span");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
