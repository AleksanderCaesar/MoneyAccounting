
package yan.algernon.moneyaccounting.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import yan.algernon.moneyaccounting.MainApp;

public class Total {
    private String year;
    private String month;
    private int totalIncome;
    private int totalExpense;
    private int difference;
    
    private MainApp mainApp;
    
  public Total(){
      
  }
  
  public Total(String year,String month){
        
        this.year = year;
        this.month = month;
        this.totalIncome = mainApp.getIncomeByMonthAndYear(year,month).getTotal();
        this.totalExpense = mainApp.getExpenseByMonthAndYear(year, month).getTotal();
        this.difference = 0;
  }

    public String getYear() {
        return year;
    }

    public void setYear(String year) {
        this.year = year;
    }

    public String getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month = month;
    }

    public int getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(int totalIncome) {
        this.totalIncome = totalIncome;
    }

    public int getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(int totalExpense) {
        this.totalExpense = totalExpense;
    }

    public int getDifference() {
        return totalIncome-totalExpense;
    }

    public void setDifference(int difference) {
        this.difference = difference;
    }

}
