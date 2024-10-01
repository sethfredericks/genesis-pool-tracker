package org.genesis.genesispooltracker;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.image.Image;
import javafx.stage.Stage;

import java.io.IOException;
import java.sql.SQLException;
import java.util.Objects;

public class HelloApplication extends Application {

    private Db db = new Db();

    public HelloApplication() throws SQLException {
    }

    @Override
    public void start(Stage stage) throws IOException {
        FXMLLoader fxmlLoader = new FXMLLoader(HelloApplication.class.getResource("hello-view.fxml"));
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        Scene scene = new Scene(fxmlLoader.load(), 800, 500);

        Image icon = new Image("redpanda-logo.png");
        stage.getIcons().add(icon);
        stage.setTitle("Genesis Pool Tracker");

        stage.setScene(scene);
        stage.show();
        db.getConnection();
    }

    public static void main(String[] args) {
        launch();
    }
}