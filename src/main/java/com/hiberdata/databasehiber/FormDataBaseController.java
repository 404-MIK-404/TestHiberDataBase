package com.hiberdata.databasehiber;

import com.hiberdata.databasehiber.domain.RepositoryTestHiber;
import com.hiberdata.databasehiber.domain.TEST_SPR;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

public class FormDataBaseController implements Initializable {

   private final RepositoryTestHiber repositoryTestHiber = new RepositoryTestHiber();

   @FXML
   private TableView<TEST_SPR> tableViewHiberTest;

    @FXML
    public TableColumn<TEST_SPR, Integer> id;

    @FXML
    public TableColumn<TEST_SPR, String> testName;

    public List<TEST_SPR> selectRow = new ArrayList<>();

    ObservableList<TEST_SPR> observableTestSpr = FXCollections.observableArrayList();;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        id.setCellValueFactory(new PropertyValueFactory<>("id"));
        testName.setCellValueFactory(new PropertyValueFactory<>("nameTest"));
        updateTableData();
        initTableView();
    }

    private void initTableView(){
        tableViewHiberTest.getSelectionModel().selectedItemProperty().addListener((obs, oldSelection, newSelection) -> {
            selectRow.clear();
            if (newSelection != null) {
                selectRow.add(newSelection);
            }
        });
    }

    @FXML
    protected void updateData(){
        this.updateTableData();
    }

    @FXML
    protected void changeDataEvent(){
        TEST_SPR test = new TEST_SPR(null,"Я фантом");
        this.repositoryTestHiber.changeRecord(test);
        this.updateTableData();
    }

    @FXML
    protected void removeDataEvent(){
        if (!this.selectRow.isEmpty()){
            this.repositoryTestHiber.removeRecord(this.selectRow.get(0));
            this.updateTableData();
        }
    }

    private void updateTableData(){
        observableTestSpr.clear();
        observableTestSpr.addAll(repositoryTestHiber.listTestSpr());
        tableViewHiberTest.setItems(observableTestSpr);
    }

}
