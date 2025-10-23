import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;
import javafx.scene.control.SelectionMode;

public class Aula0409 {

    public void show(Stage primaryStage) {
        try {
            // ComboBox
            ComboBox<String> cmbBox = new ComboBox<>();
            cmbBox.getItems().addAll("Opção 1", "Opção 2", "Opção 3");
            cmbBox.setPromptText("Selecione uma opção:");

            Label cmbBoxlbl = new Label("Seleção ComboBox:");

            cmbBox.setOnAction(evento -> {
                String selecionado = cmbBox.getValue();
                cmbBoxlbl.setText("Seleção ComboBox: " + selecionado);
            });

            // ListView
            ObservableList<String> items = FXCollections.observableArrayList(
                "Item A", "Item B", "Item C", "Item D"
            );
            ListView<String> lstView = new ListView<>(items);

            lstView.setPrefHeight(100);


            Label lstViewlbl = new Label("Seleção de List View: ");

            lstView.getSelectionModel().selectedItemProperty().addListener(
                (observable, oldValue, newValue) -> {
                    lstViewlbl.setText("Seleção de List View: " + newValue);
                }
            );

            lstView.getSelectionModel().setSelectionMode(SelectionMode.MULTIPLE);

            Label label = new Label(
                "Layouts no JavaFX organizam os componentes visuais na tela.\n" +
                "Eles permitem alinhar e distribuir elementos de forma prática."
            );



            VBox root = new VBox(10); // 10 px de espaçamento
            root.getChildren().addAll(label, cmbBox, cmbBoxlbl, lstView, lstViewlbl);

            Scene scene = new Scene(root, 400, 300); // aumentei a altura para caber tudo

            primaryStage.setTitle("Exemplo 1 - ComboBox e ListView");
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
