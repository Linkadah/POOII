import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class Ex2 {

    public void start(Stage primaryStage) {
        //  componentes
        Label lblUsuario = new Label("Usuário:");
        TextField txtUsuario = new TextField();

        Label lblSenha = new Label("Senha:");
        TextField txtSenha = new TextField();

        Button btnEntrar = new Button("Entrar");
        VBox vbox = new VBox(10); 
        vbox.setAlignment(Pos.CENTER);
        vbox.setPadding(new Insets(20));
        vbox.getChildren().addAll(lblUsuario, txtUsuario, lblSenha, txtSenha, btnEntrar);

        // Cena
        Scene scene = new Scene(vbox, 300, 250);
        primaryStage.setTitle("Exemplo 2 - Login com VBox");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
