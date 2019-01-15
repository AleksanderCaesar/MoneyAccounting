
package yan.algernon.moneyaccounting.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yan.algernon.moneyaccounting.model.Expense;

public class NewWindowExpense {
    @FXML
    private TextField yearField;
    @FXML
    private TextField monthField;
    @FXML
    private TextField loansField;
    @FXML
    private TextField telInternetField;
    @FXML
    private TextField communalExpField;
    @FXML
    private TextField foodField;
    @FXML
    private TextField travelCardField;
    @FXML
    private TextField otherExpField;
    
    private Stage windowStage;
    private Expense expense;
    private boolean okClicked = false;
    
    
  @FXML
  private void initialize() {
  }
  
  public void setWindowStage(Stage windowStage){
        this.windowStage = windowStage;
  }
  
  public void setExpenseData(Expense expense){
      this.expense = expense;
      yearField.setText(expense.getYearString());
      monthField.setText(expense.getMonthString());
      loansField.setText(Integer.toString(expense.getLoansInt()));
      telInternetField.setText(Integer.toString(expense.getTelInternetInt()));
      communalExpField.setText(Integer.toString(expense.getCommunalExpensesInt()));
      foodField.setText(Integer.toString(expense.getFoodInt()));
      travelCardField.setText(Integer.toString(expense.getTravelCardInt()));
      otherExpField.setText(Integer.toString(expense.getOtherExpenseInt()));
  }
  
  public boolean isOkClicked() {
        return okClicked;
    }
  
  @FXML
    private void handleOk(){
        expense.setYear(yearField.getText());
        expense.setMonth(monthField.getText());
        expense.setLoans(Integer.parseInt(loansField.getText()));
        expense.setTelephoneInternet(Integer.parseInt(telInternetField.getText()));
        expense.setCommunalExpenses(Integer.parseInt(communalExpField.getText()));
        expense.setFood(Integer.parseInt(foodField.getText()));
        expense.setTravelCard(Integer.parseInt(travelCardField.getText()));
        expense.setOtherExpense(Integer.parseInt(otherExpField.getText()));
        expense.getTotal();
        okClicked = true;
        windowStage.close();
    }
    
    @FXML
    private void handleCancel() {
        windowStage.close();
    }
    
}
