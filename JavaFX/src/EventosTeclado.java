import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class EventosTeclado {
     public void start(Stage primaryStage) {
        try {
            Label lblbt01 = new Label("Interaja com o teclado");

            //Layout
            StackPane root = new StackPane();
            root.getChildren().addAll(lblbt01);

            //capturar evento teclado:

            root.setOnKeyPressed(event -> {
                String key = event.getCode().toString();

                lblbt01.setText("Tecla pressionada: " + key);
            });

            //Evento Mouse

            root.setOnMouseClicked(event ->{
                double x = event.getSceneX();
                double y = event.getSceneY();

                lblbt01.setText("Mouse clicado em X: " + x + " em Y: " + y);
            });

            Scene scene = new Scene(root, 400, 400);
            scene.setOnKeyPressed(root.getOnKeyPressed());


            primaryStage.setTitle("Evento Teclado");
            primaryStage.setScene(scene);
            primaryStage.show();

        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
