package com.mftplus.controller;

import com.mftplus.model.bl.BookBl;
import com.mftplus.model.bl.BorrowBl;
import com.mftplus.model.bl.MemberBl;
import com.mftplus.model.entity.*;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.List;
import java.util.ResourceBundle;

public class BorrowViewController implements Initializable {

    @FXML
    private TableView<Book> bookTbl;

    @FXML
    private TableColumn<Book, Long> bookIdCol;

    @FXML
    private TableColumn<Book, String> bookTitleCol, bookAuthorCol;

    @FXML
    private TableView<Member> memberTbl;

    @FXML
    private TableColumn<Member, Long> memberIdCol;

    @FXML
    private TableColumn<Member, String> memberNameCol, memberFamilyCol;

    @FXML
    private Button borrowBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showMemberDataOnTable();
        showBookDataOnTable();

        borrowBtn.setOnAction(event -> {
            try {
                Member member = memberTbl.getSelectionModel().getSelectedItem();
                Book book = bookTbl.getSelectionModel().getSelectedItem();

                Borrow borrow =
                        Borrow
                                .builder()
                                .book(book)
                                .member(member)
                                .borrowDate(LocalDate.now())
                                .build();
                BorrowBl.getInstance().save(borrow);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Borrowed to Member", ButtonType.OK);
                alert.show();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Borrowing Book\n" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        });

    }

    public void showMemberDataOnTable() {
        try {
            ObservableList<Member> memberObservableList = FXCollections.observableList(
                    MemberBl.getInstance().findAll()
            );
            memberIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            memberNameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
            memberFamilyCol.setCellValueFactory(new PropertyValueFactory<>("family"));
            memberTbl.setItems(memberObservableList);
        } catch (Exception e) {

        }
    }

    public void showBookDataOnTable() {
        try {
            ObservableList<Book> observableList = FXCollections.observableList(
                    BookBl.getInstance().findAll()
            );
            bookIdCol.setCellValueFactory(new PropertyValueFactory<>("id"));
            bookTitleCol.setCellValueFactory(new PropertyValueFactory<>("title"));
            bookAuthorCol.setCellValueFactory(new PropertyValueFactory<>("author"));
            bookTbl.setItems(observableList);
        } catch (Exception e) {

        }
    }
}
