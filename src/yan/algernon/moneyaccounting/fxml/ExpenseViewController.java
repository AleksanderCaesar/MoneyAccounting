
package yan.algernon.moneyaccounting.fxml;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
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
        yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
        monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
        loansColumn.setCellValueFactory(new PropertyValueFactory<>("loans"));
        telInternetColumn.setCellValueFactory(new PropertyValueFactory<>("telephoneInternet"));
        communalExpColumn.setCellValueFactory(new PropertyValueFactory<>("communalExpenses"));
        foodColumn.setCellValueFactory(new PropertyValueFactory<>("food"));
        travelCardColumn.setCellValueFactory(new PropertyValueFactory<>("travelCard"));
        otherExpColumn.setCellValueFactory(new PropertyValueFactory<>("otherExpense"));
        totalColumn.setCellValueFactory(new PropertyValueFactory<>("total"));
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
