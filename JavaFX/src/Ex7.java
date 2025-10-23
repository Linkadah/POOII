import javafx.geometry.Insets;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class Ex7 {
    public void start(Stage primaryStage) {
        GridPane grid = new GridPane();
        grid.setHgap(10);
        grid.setVgap(10);
        grid.setPadding(new Insets(20));

        grid.add(new Label("Nome:"), 0, 0);
        grid.add(new TextField(), 1, 0);

        grid.add(new Label("E-mail:"), 0, 1);
        grid.add(new TextField(), 1, 1);

        grid.add(new Label("Telefone:"), 0, 2);
        grid.add(new TextField(), 1, 2);

        grid.add(new Label("Cidade:"), 0, 3);
        grid.add(new TextField(), 1, 3);

        Scene scene = new Scene(grid, 350, 250);
        primaryStage.setTitle("Exemplo 7 - Formulário com GridPane");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
