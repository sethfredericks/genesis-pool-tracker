package org.genesis.genesispooltracker;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.Objects;
import java.util.ResourceBundle;

public class LogController implements Initializable {
    private Stage stage;
    private Scene scene;
    @FXML
    private ComboBox<String> winnerBox;
    @FXML
    private ComboBox<String> loserBox;
    @FXML
    void setWinnerBox(ActionEvent event){
        String winner = winnerBox.getSelectionModel().getSelectedItem();
    }
    @FXML
    void setLoserBox(ActionEvent event){
        String loser = loserBox.getSelectionModel().getSelectedItem();
    }

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {
        ObservableList<String> team = FXCollections.observableArrayList("Jacques", "Tefo", "Daniel", "Willem", "Tiaan", "Cameron", "Geurschom", "Tumiso", "Mariam", "Taylan", "Mpho", "Nuriyah", "Kelsy-Ann", "Seth", "Other");
        winnerBox.setItems(team);
        loserBox.setItems(team);
    }

    public void switchToHelloScene(ActionEvent event) throws IOException {
        Parent root = FXMLLoader.load(Objects.requireNonNull(getClass().getResource("hello-view.fxml")));
        stage = (Stage)((Node)event.getSource()).getScene().getWindow();
        scene = new Scene(root);
        stage.setScene(scene);
        stage.show();
    }
}
