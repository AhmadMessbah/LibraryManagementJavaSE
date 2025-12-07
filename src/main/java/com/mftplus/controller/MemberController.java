package com.mftplus.controller;

import com.mftplus.model.bl.MemberBl;
import com.mftplus.model.entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberController implements Initializable {
    @FXML
    private TextField idTxt, nameTxt, familyTxt;

    @FXML
    private Button saveBtn, editBtn, removeBtn;

    @FXML
    private TableView<Member> memberTbl;

    @FXML
    private TableColumn<Member, Long> idCol;

    @FXML
    private TableColumn<Member, String> nameCol, familyCol;


    @Override
    public void initialize(URL location, ResourceBundle resources) {
        System.out.println("Window Opened");
        saveBtn.setOnAction(event -> {
            try {
                showMembersOnTable(MemberBl.getInstance().findAll());
            }catch (Exception e){

            }
        });
    }

    private void showMembersOnTable(List<Member> memberList) {
        ObservableList<Member> memberObservableList = FXCollections.observableList(memberList);

        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        familyCol.setCellValueFactory(new PropertyValueFactory<>("family"));

        memberTbl.setItems(memberObservableList);
        memberTbl.refresh();
    }
}
