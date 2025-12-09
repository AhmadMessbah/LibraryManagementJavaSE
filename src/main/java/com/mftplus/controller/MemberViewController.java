package com.mftplus.controller;

import com.mftplus.model.entity.City;
import com.mftplus.model.entity.Member;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;


import java.net.URL;
import java.util.ResourceBundle;

public class MemberViewController implements Initializable {
    @FXML
    private TextField idTxt, nameTxt,familyTxt;

    @FXML
    private DatePicker birthDate;

    @FXML
    private ToggleGroup genderToggleGroup;

    @FXML
    private RadioButton maleRdo, femaleRdo;

    @FXML
    private ComboBox<City> cityCombo;

    @FXML
    private Button saveBtn,editBtn,removeBtn;

    @FXML
    private TableView<Member> memberTbl;

    @FXML
    private TableColumn<Member,Long> idCol;

    @FXML
    private TableColumn<Member,String> nameCol, familyCol;

    @Override
    public void initialize(URL location, ResourceBundle resources) {

        for (City value : City.values()) {
            cityCombo.getItems().add(value);
        }

        reset_form();

        saveBtn.setOnAction(event -> {

        });

        editBtn.setOnAction(event -> {});

        removeBtn.setOnAction(event -> {});

        memberTbl.setOnMouseReleased(event -> {});
    }

    private void reset_form(){
        idTxt.clear();
        nameTxt.clear();
        familyTxt.clear();
        birthDate.setValue(null);
        maleRdo.setSelected(true);
        cityCombo.getSelectionModel().select(0);
    }
}
