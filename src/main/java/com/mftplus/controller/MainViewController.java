package com.mftplus.controller;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Scene;
import javafx.scene.control.MenuItem;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

public class MainViewController implements Initializable {
    @FXML
    private MenuItem memberMnu, bookMnu, borrowMnu, returnMnu;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        memberMnu.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/MemberView.fxml")));

                stage.setResizable(false);
                stage.setTitle("Members");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {

            }
        });

        bookMnu.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/BookView.fxml")));

                stage.setResizable(false);
                stage.setTitle("Books");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {

            }
        });

        borrowMnu.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/BorrowView.fxml")));

                stage.setResizable(false);
                stage.setTitle("Books");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {

            }
        });

        returnMnu.setOnAction(event -> {
            try {
                Stage stage = new Stage();
                Scene scene = new Scene(FXMLLoader.load(getClass().getResource("/view/ReturnView.fxml")));

                stage.setResizable(false);
                stage.setTitle("Books");
                stage.setScene(scene);
                stage.show();

            } catch (Exception e) {

            }
        });
    }
}
