package com.mftplus.controller;

import com.mftplus.model.bl.BookBl;
import com.mftplus.model.bl.BorrowBl;
import com.mftplus.model.bl.MemberBl;
import com.mftplus.model.dto.BorrowDto;
import com.mftplus.model.entity.Book;
import com.mftplus.model.entity.Borrow;
import com.mftplus.model.entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;
import java.util.stream.Collectors;

public class ReturnViewController implements Initializable {

    @FXML
    private TableView<BorrowDto> borrowTbl;

    @FXML
    private TableColumn<BorrowDto, Long> idCol;

    @FXML
    private TableColumn<BorrowDto, String> memberNameCol, memberFamilyCol, bookTitleCol, bookAuthorCol;

    @FXML
    private TableColumn<BorrowDto, LocalDate> borrowDateCol;


    @FXML
    private Button returnBtn;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        showDataOnTable();

        returnBtn.setOnAction(event -> {
            try {
                BorrowDto borrowDto = borrowTbl.getSelectionModel().getSelectedItem();
                BorrowBl.getInstance().returnBookById(borrowDto.getId(), LocalDate.now());
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Book Borrowed to Member", ButtonType.OK);
                alert.show();
                showDataOnTable();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Borrowing Book\n" + e.getMessage(), ButtonType.OK);
                alert.show();

            }
        });

    }

    public void showDataOnTable() {
        try {
            List<Borrow> borrowList = BorrowBl.getInstance().findUnreturned();
            System.out.println("DATA : ");
            System.out.println(borrowList);
            List<BorrowDto> borrowDtoList =
                    borrowList
                            .stream()
                            .map(BorrowDto::new)
                            .collect(Collectors.toList());


            ObservableList<BorrowDto> observableList = FXCollections.observableList(borrowDtoList);
            idCol.setCellValueFactory(new PropertyValueFactory<>("borrowId"));
            memberNameCol.setCellValueFactory(new PropertyValueFactory<>("memberName"));
            memberFamilyCol.setCellValueFactory(new PropertyValueFactory<>("memberFamily"));
            bookTitleCol.setCellValueFactory(new PropertyValueFactory<>("bookTitle"));
            bookAuthorCol.setCellValueFactory(new PropertyValueFactory<>("bookAuthor"));
            borrowDateCol.setCellValueFactory(new PropertyValueFactory<>("borrowDate"));
            borrowTbl.setItems(observableList);

        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error Loading Borrows\n" + e.getMessage(), ButtonType.OK);
            alert.show();
        }
    }


}
