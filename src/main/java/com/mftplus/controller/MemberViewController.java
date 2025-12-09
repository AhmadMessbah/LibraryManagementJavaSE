package com.mftplus.controller;

import com.mftplus.model.bl.MemberBl;
import com.mftplus.model.entity.City;
import com.mftplus.model.entity.Gender;
import com.mftplus.model.entity.Member;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;
import javafx.scene.control.cell.PropertyValueFactory;


import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

public class MemberViewController implements Initializable {
    @FXML
    private TextField idTxt, nameTxt, familyTxt;

    @FXML
    private DatePicker birthDate;

    @FXML
    private ToggleGroup genderToggleGroup;

    @FXML
    private RadioButton maleRdo, femaleRdo;

    @FXML
    private ComboBox<City> cityCombo;

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

        for (City value : City.values()) {
            cityCombo.getItems().add(value);
        }

        reset_form();

        saveBtn.setOnAction(event -> {
            try {
                Member member =
                        Member
                                .builder()
                                .name(nameTxt.getText())
                                .family(familyTxt.getText())
                                .birthDate(birthDate.getValue())
                                .gender((maleRdo.isSelected()) ? Gender.Male : Gender.Female)
                                .city(cityCombo.getValue())
                                .build();
                MemberBl.getInstance().save(member);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Member Saved", ButtonType.OK);
                alert.show();
                reset_form();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Saving Member\n" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        });

        editBtn.setOnAction(event -> {
            try {
                Member member =
                        Member
                                .builder()
                                .id(Long.valueOf(idTxt.getText()))
                                .name(nameTxt.getText())
                                .family(familyTxt.getText())
                                .birthDate(birthDate.getValue())
                                .gender((maleRdo.isSelected()) ? Gender.Male : Gender.Female)
                                .city(cityCombo.getValue())
                                .build();
                MemberBl.getInstance().update(member);
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Member Updated", ButtonType.OK);
                alert.show();
                reset_form();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Updating Member\n" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        });

        removeBtn.setOnAction(event -> {
            try{
                MemberBl.getInstance().deleteById(Long.valueOf(idTxt.getText()));
                Alert alert = new Alert(Alert.AlertType.INFORMATION, "Member Deleted", ButtonType.OK);
                alert.show();
                reset_form();
            } catch (Exception e) {
                Alert alert = new Alert(Alert.AlertType.ERROR, "Error Deleting Member\n" + e.getMessage(), ButtonType.OK);
                alert.show();
            }
        });

        memberTbl.setOnMouseReleased(event -> {
           Member selectedMember =  memberTbl.getSelectionModel().getSelectedItem();
           idTxt.setText(String.valueOf(selectedMember.getId()));
           nameTxt.setText(selectedMember.getName());
           familyTxt.setText(selectedMember.getFamily());
           birthDate.setValue(selectedMember.getBirthDate());
           if(selectedMember.getGender().equals(Gender.Male)){
               maleRdo.setSelected(true);
           }else{
               femaleRdo.setSelected(true);
           }
           cityCombo.setValue(selectedMember.getCity());
        });
    }

    private void reset_form() {
        try {
            idTxt.clear();
            nameTxt.clear();
            familyTxt.clear();
            birthDate.setValue(null);
            maleRdo.setSelected(true);
            cityCombo.getSelectionModel().select(0);
            showDataOnTable(MemberBl.getInstance().findAll());
        } catch (Exception e) {
            Alert alert = new Alert(Alert.AlertType.ERROR, "Error get data from database\n" + e.getMessage(), ButtonType.OK);
            alert.show();
        }
    }

    public void showDataOnTable(List<Member> memberList) {
//        memberList.clear();
        ObservableList<Member> observableList = FXCollections.observableList(memberList);
        idCol.setCellValueFactory(new PropertyValueFactory<>("id"));
        nameCol.setCellValueFactory(new PropertyValueFactory<>("name"));
        familyCol.setCellValueFactory(new PropertyValueFactory<>("family"));
        memberTbl.setItems(observableList);
    }
}
