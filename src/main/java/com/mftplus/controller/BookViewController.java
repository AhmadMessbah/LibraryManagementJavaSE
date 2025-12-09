package com.mftplus.controller;

import com.mftplus.model.bl.BookBl;
import com.mftplus.model.entity.Book;
import com.mftplus.model.entity.Gender;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class BookViewController implements Initializable {
    @FXML
    private TextField idTxt, titleTxt, authorTxt;

    @FXML
    private Button saveBtn, editBtn, removeBtn;

    @FXML
    private TableView<Book> bookTbl;

    @FXML
    private TableColumn<Book, Long> idCol;

    @FXML
    private TableColumn<Book, String> titleCol, authorCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        
        reset_form();

        saveBtn.setOnAction(event -> {
            try {
                Book book =
                        Book
                                .builder()
                                .title(titleTxt.getText())
                                .author(authorTxt.getText())
                                .build();
                BookBl.getInstance().save(book);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Saved", ButtonType.OK);
                alert.show();
                reset_form();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Saving Book\n" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        });

        editBtn.setOnAction(event -> {
            try {
                Book book =
                        Book
                                .builder()
                                .id(Long.valueOf(idTxt.getText()))
                                .title(titleTxt.getText())
                                .author(authorTxt.getText())
                                .build();
                BookBl.getInstance().update(book);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Updated", ButtonType.OK);
                alert.show();
                reset_form();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Updating Book\n" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        });

        removeBtn.setOnAction(event -> {
            try{
                BookBl.getInstance().deleteById(Long.valueOf(idTxt.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Deleted", ButtonType.OK);
                alert.show();
                reset_form();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Deleting Book\n" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        });

        bookTbl.setOnMouseReleased(event -> {
           Book selectedBook =  bookTbl.getSelectionModel().getSelectedItem();
           idTxt.setText(String.valueOf(selectedBook.getId()));
           titleTxt.setText(selectedBook.getTitle());
           authorTxt.setText(selectedBook.getAuthor());
        });
    }

    private void reset_form() {
        try {
            idTxt.clear();
            titleTxt.clear();
            authorTxt.clear();
            showDataOnTable(BookBl.getInstance().findAll());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error get data from database\n" + e.getMessage(), ButtonType.OK);
            alert.show();
        }
    }

    public void showDataOnTable(List<Book> bookList) {
//        bookList.clear();
        ObservableList<Book> observableList = FXCollections.observableList(bookList);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        titleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
        authorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
        bookTbl.setItems(observableList);
    }
}
