
package yan.algernon.moneyaccounting.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import yan.algernon.moneyaccounting.MainApp;

public class Total {
    private StringProperty year;
    private StringProperty month;
    private IntegerProperty totalIncome;
    private IntegerProperty totalExpense;
    private IntegerProperty difference;
    
    private MainApp mainApp;
    
  public Total(){
      this.difference = new SimpleIntegerProperty();
  }
  
  public Total(String year,String month){
        this.month = new SimpleStringProperty(month);
        this.year = new SimpleStringProperty(year);
        this.totalIncome = mainApp.getIncomeByMonthAndYear(year,month).getTotal();
        this.totalExpense = mainApp.getExpenseByMonthAndYear(year, month).getTotal();
        this.difference = new SimpleIntegerProperty();
  }

    public StringProperty getYear() {
        return year;
    }

    public void setYear(StringProperty year) {
        this.year = year;
    }

    public StringProperty getMonth() {
        return month;
    }

    public void setMonth(StringProperty month) {
        this.month = month;
    }

    public IntegerProperty getTotalIncome() {
        return totalIncome;
    }

    public void setTotalIncome(IntegerProperty totalIncome) {
        this.totalIncome = totalIncome;
    }

    public IntegerProperty getTotalExpense() {
        return totalExpense;
    }

    public void setTotalExpense(IntegerProperty totalExpense) {
        this.totalExpense = totalExpense;
    }

    public IntegerProperty getDifference() {
        int dif = totalIncome.get()-totalExpense.get();
        difference.set(dif);
        return difference;
    }

    public int getTotalIncomeInteger(){
        int inc = totalIncome.get() ;
        return inc;
    }
    
    public String getYearString(){
        return year.get();
    }
    
    public String getMonthString(){
        return month.get();
    }
   
  
  
}
