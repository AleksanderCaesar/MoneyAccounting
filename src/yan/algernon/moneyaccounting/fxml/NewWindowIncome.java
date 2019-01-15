
package yan.algernon.moneyaccounting.fxml;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import yan.algernon.moneyaccounting.model.Income;

public class NewWindowIncome {
    @FXML
    private TextField yearField;
    @FXML
    private TextField monthField;
    @FXML
    private TextField salaryField;
    @FXML
    private TextField prepaymentField;
    @FXML
    private TextField otherIncomeField;
    
    private Stage windowStage;
    private Income income;
    private boolean okClicked = false;
    
    
  @FXML
  private void initialize() {
  }
  
  public void setWindowStage(Stage windowStage){
        this.windowStage = windowStage;
    }
  
  public void setIncomeData(Income income){
      this.income = income;
      yearField.setText(income.getYear());
      monthField.setText(income.getMonth());
      salaryField.setText(Integer.toString(income.getSalary()));
      prepaymentField.setText(Integer.toString(income.getPrepayment()));
      otherIncomeField.setText(Integer.toString(income.getOtherIncome()));     
  }
  
  public boolean isOkClicked() {
        return okClicked;
    }
  
  @FXML
    private void handleOk(){        
        income.setYear(yearField.getText());
        income.setMonth(monthField.getText());
        income.setSalary(Integer.parseInt(salaryField.getText()));
        income.setPrepayment(Integer.parseInt(prepaymentField.getText()));
        income.setOtherIncome(Integer.parseInt(otherIncomeField.getText()));
        income.getTotal();
        okClicked = true;
        windowStage.close();
    }
    
    @FXML
    private void handleCancel() {
        windowStage.close();
    }
    
}
