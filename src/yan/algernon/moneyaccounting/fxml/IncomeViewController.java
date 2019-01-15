
package yan.algernon.moneyaccounting.fxml;

import java.io.IOException;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import yan.algernon.moneyaccounting.MainApp;
import yan.algernon.moneyaccounting.model.Income;

/**
 *
 * @author Alexander
 */
public class IncomeViewController {
    @FXML
    private TableView<Income> incomeTable;
    @FXML
    private TableColumn<Income,String> yearColumn;
    @FXML 
    private TableColumn<Income,String> monthColumn;
    @FXML
    private TableColumn<Income,Integer> salaryColumn; 
    @FXML
    private TableColumn<Income,Integer> prepaymentColumn;
    @FXML
    private TableColumn<Income,Integer> otherIncomeColumn;
    @FXML
    private TableColumn<Income,Integer> totalColumn;
    
    private Stage windowStage;    
    private MainApp mainApp;
    
    
    public void initialize(){
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        monthColumn.setCellValueFactory(cellData -> cellData.getValue().getMonth());
        salaryColumn.setCellValueFactory(cellData -> cellData.getValue().getSalary().asObject());
        prepaymentColumn.setCellValueFactory(cellData -> cellData.getValue().getPrepayment().asObject());
        otherIncomeColumn.setCellValueFactory(cellData -> cellData.getValue().getOtherIncome().asObject());
        totalColumn.setCellValueFactory(cellData -> cellData.getValue().getTotal().asObject());
    }
    
       
    public void setWindowStage(Stage windowStage){
        this.windowStage = windowStage;
        
    }
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        incomeTable.setItems(mainApp.getIncomeList());
    }
    
    @FXML
    private void closeWindow(ActionEvent event){
      ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
        
   
    @FXML
    private void addNewIncome(){
        Income tempIncome = new Income();
        boolean okClicked = mainApp.showNewIncomeWindow(tempIncome);
          if (okClicked) {
            mainApp.getIncomeList().add(tempIncome);
            
          }
    }            
    
    @FXML
    private void handleDelete(){
       
       int selectedIndex = incomeTable.getSelectionModel().getSelectedIndex();
       if(selectedIndex >= 0){
           incomeTable.getItems().remove(selectedIndex);
       } else {           
           Alert alert = new Alert(Alert.AlertType.WARNING);
           alert.initOwner(mainApp.getPrimaryStage());
           alert.setTitle("Ничего не выбрано");
           alert.setHeaderText("Нет объекта для удаления");
           alert.setContentText("Пожалуйста, выберите объект для удаления");
           alert.showAndWait();       
       }
   }
    
    @FXML
     private void handleEdit(){
         
         Income selectedIncome = incomeTable.getSelectionModel().getSelectedItem();
         if (selectedIncome != null) {
             boolean okClicked = mainApp.showNewIncomeWindow(selectedIncome);
              
         } else {             
            Alert alert = new Alert(Alert.AlertType.WARNING);
            alert.initOwner(mainApp.getPrimaryStage());
            alert.setTitle("No Selection");
            alert.setHeaderText("No Person Selected");
            alert.setContentText("Please select a person in the table.");
            alert.showAndWait();
           }
     }
      
}
