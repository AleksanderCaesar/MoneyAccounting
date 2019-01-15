
package yan.algernon.moneyaccounting.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import yan.algernon.moneyaccounting.MainApp;
import yan.algernon.moneyaccounting.model.Expense;

public class ExpenseViewController {
    @FXML
    private TableView<Expense> expenseTable;
    @FXML
    private TableColumn<Expense,String> yearColumn;
    @FXML
    private TableColumn<Expense,String> monthColumn;
    @FXML
    private TableColumn<Expense,Integer> loansColumn;
    @FXML
    private TableColumn<Expense,Integer> telInternetColumn;
    @FXML
    private TableColumn<Expense,Integer> communalExpColumn;
    @FXML
    private TableColumn<Expense,Integer> foodColumn;
    @FXML
    private TableColumn<Expense,Integer> travelCardColumn;
    @FXML
    private TableColumn<Expense,Integer> otherExpColumn;
    @FXML
    private TableColumn<Expense,Integer> totalColumn;
    
    private Stage windowStage;
    private MainApp mainApp;
    
    
    public void initialize(){
        yearColumn.setCellValueFactory(cellData -> cellData.getValue().getYear());
        monthColumn.setCellValueFactory(cellData -> cellData.getValue().getMonth());
        loansColumn.setCellValueFactory(cellData -> cellData.getValue().getLoans().asObject());
        telInternetColumn.setCellValueFactory(cellData -> cellData.getValue().getTelephoneInternet().asObject());
        communalExpColumn.setCellValueFactory(cellData -> cellData.getValue().getCommunalExpenses().asObject());
        foodColumn.setCellValueFactory(cellData -> cellData.getValue().getFood().asObject());
        travelCardColumn.setCellValueFactory(cellData -> cellData.getValue().getTravelCard().asObject());
        otherExpColumn.setCellValueFactory(cellData -> cellData.getValue().getOtherExpense().asObject());
        totalColumn.setCellValueFactory(cellData -> cellData.getValue().getTotal().asObject());
    }
    
    public void setWindowStage(Stage windowStage){
        this.windowStage = windowStage;        
    }
    
    public void setMainApp(MainApp mainApp){
        this.mainApp = mainApp;
        expenseTable.setItems(mainApp.getExpenseList());        
    }
    
    @FXML
    private void closeWindow(ActionEvent event){
      ((Stage)(((Button)event.getSource()).getScene().getWindow())).close();
    }
    
    @FXML
    private void handleDelete(){
       
       int selectedIndex = expenseTable.getSelectionModel().getSelectedIndex();
       if(selectedIndex >= 0){
           expenseTable.getItems().remove(selectedIndex);
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
    private void addNewExpense(){
        Expense tempExpense = new Expense();
        boolean okClicked = mainApp.showNewExpenseWindow(tempExpense);
         if(okClicked){
             mainApp.getExpenseList().add(tempExpense);
         }
    }
    
    @FXML
     private void handleEdit(){
         
         Expense selectedExpensee = expenseTable.getSelectionModel().getSelectedItem();
         if (selectedExpensee != null) {
             boolean okClicked = mainApp.showNewExpenseWindow(selectedExpensee);
              
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
