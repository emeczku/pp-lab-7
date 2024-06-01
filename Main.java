import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.HBox;
import javafx.scene.layout.VBox;
import javafx.stage.DirectoryChooser;
import javafx.stage.Stage;
import java.io.File;

public class Main extends Application {

    private TextField directoryPathField;
    private TextField searchField;
    private TextArea resultArea;

    @Override
    public void start(Stage primaryStage) {
        primaryStage.setTitle("File Browser and Search");

        directoryPathField = new TextField();
        directoryPathField.setPromptText("Enter directory path");

        searchField = new TextField();
        searchField.setPromptText("Enter search phrase");

        Button browseButton = new Button("Browse");
        browseButton.setOnAction(e -> browseDirectory());

        Button searchButton = new Button("Search");

        resultArea = new TextArea();
        resultArea.setPrefHeight(400);

        HBox hBox = new HBox(15);
        hBox.getChildren().addAll(directoryPathField, browseButton);

        VBox vBox = new VBox(15);
        vBox.getChildren().addAll(hBox, searchField, searchButton);

        VBox vBox = new VBox(10);
        vBox.getChildren().addAll(hBox, searchField, searchButton, resultArea);

        Scene scene = new Scene(vBox, 700, 300);
        primaryStage.setScene(scene);

        primaryStage.show();
    }

    private void browseDirectory() {
        DirectoryChooser directoryChooser = new DirectoryChooser();

        File selectedDirectory = directoryChooser.showDialog(null);

        if (selectedDirectory != null) {
            directoryPathField.setText(selectedDirectory.getAbsolutePath());
        }
    }

    public static void main(String[] args) {
        launch(args);
    }
}
