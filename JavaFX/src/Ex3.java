import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.HBox;
import javafx.stage.Stage;

public class Ex3 {
    public void start(Stage primaryStage) {
        Button btnNovo = new Button("Novo");
        Button btnAbrir = new Button("Abrir");
        Button btnSalvar = new Button("Salvar");

        HBox hbox = new HBox(15);
        hbox.setAlignment(Pos.CENTER);
        hbox.setPadding(new Insets(20));
        hbox.getChildren().addAll(btnNovo, btnAbrir, btnSalvar);

        Scene scene = new Scene(hbox, 300, 100);
        primaryStage.setTitle("Exemplo 3 - Toolbar com HBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
