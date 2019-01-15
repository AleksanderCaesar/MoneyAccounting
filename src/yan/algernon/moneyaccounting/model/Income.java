
package yan.algernon.moneyaccounting.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Alexander
 */
public class Income {
    private StringProperty year;
    private StringProperty month;
    private IntegerProperty salary;
    private IntegerProperty prepayment;    
    private IntegerProperty otherIncome;
    private IntegerProperty total;

    
    
 public Income(){ 
        this.month = new SimpleStringProperty();
        this.year = new SimpleStringProperty();
        this.salary = new SimpleIntegerProperty();
        this.prepayment = new SimpleIntegerProperty();
        this.otherIncome = new SimpleIntegerProperty();
        this.total = new SimpleIntegerProperty();
 }
    
 public Income(String year, String month, int salary, int prepayment, int otherIncome){
        this.month = new SimpleStringProperty(month);
        this.year = new SimpleStringProperty(year);
        this.salary = new SimpleIntegerProperty(salary);
        this.prepayment = new SimpleIntegerProperty(prepayment);
        this.otherIncome = new SimpleIntegerProperty(otherIncome);
        this.total = new SimpleIntegerProperty();
 }

    public StringProperty getYear() {
        return year;
    }

    public void setYear(String year) {
       this.year.set(year);
    }

    public StringProperty getMonth() {
        return month;
    }

    public void setMonth(String month) {
        this.month.set(month); 
    }

    public IntegerProperty getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary.set(salary);
    }

    public IntegerProperty getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(int prepayment) {
        this.prepayment.set(prepayment); 
    }

    public IntegerProperty getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(int otherIncome) {
        this.otherIncome.set(otherIncome); 
    }
    
    public IntegerProperty getTotal() {        
        int  totalInt = salary.get()+prepayment.get()+otherIncome.get();
        total.set(totalInt);
        return total;
    }
    
    public String getYearString(){
        return year.get();
    }
    
    public String getMonthString(){
        return month.get();
    }
    
    public int getSalaryInt(){
        return salary.get();
    }
    
    public int getPrepaymentInt(){
        return prepayment.get();
    }
    
    public int getOtherIncomeInt(){
        return otherIncome.get();
    }
    
    public int getTotalInt(){
        return total.get();
    }
    

}