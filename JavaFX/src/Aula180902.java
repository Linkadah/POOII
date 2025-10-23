import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.VBox;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

public class Aula180902 {
    public void start(Stage primaryStage) {
        try {
            Image img01 = new Image("file:/home/aluno/Downloads/JavaFX/src/gatinho.png");

            ImageView imgView = new ImageView(img01);
            imgView.setFitWidth(200);
            imgView.setFitHeight(200);

            //Layout Vbox
            VBox vbox = new VBox(10);
            vbox.getChildren().add(imgView);

            //Cria a cena
            Scene scene = new Scene(vbox, 400, 400);

            //STAGE
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}


