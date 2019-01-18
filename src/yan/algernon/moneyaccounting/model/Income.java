
package yan.algernon.moneyaccounting.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Alexander
 */
public class Income {
    private String year;
    private String month;
    private int salary;
    private int prepayment;    
    private int otherIncome;
    private int total;

    
    
 public Income(){ 
         
 }
    
 public Income(String year, String month,int salary, int pre, int other ){
        this.month = month;
        this.year = year;
        this.salary = salary;
        this.prepayment = pre;
        this.otherIncome = other;
        this.total = 0;
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

    public int getSalary() {
        return salary;
    }

    public void setSalary(int salary) {
        this.salary = salary;
    }

    public int getPrepayment() {
        return prepayment;
    }

    public void setPrepayment(int prepayment) {
        this.prepayment = prepayment;
    }

    public int getOtherIncome() {
        return otherIncome;
    }

    public void setOtherIncome(int otherIncome) {
        this.otherIncome = otherIncome;
    }

    public int getTotal() {
        return salary+prepayment+otherIncome;
    }

    public void setTotal(int total) {
        this.total = total;
    }

    

}
