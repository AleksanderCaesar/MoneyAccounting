
package yan.algernon.moneyaccounting.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Alexander
 */
public class Expense {
    private String year;
    private String month;
    private int loans;
    private int telephoneInternet;
    private int communalExpenses;
    private int food;
    private int travelCard;
    private int otherExpense;
    private int total;
    
    public Expense(){
          
    }
    
    public Expense(String year, String month, int loans, int tel, int cu, int food, int tc, int other){
        
        this.year = year;
        this.month = month;
        this.loans = loans;
        this.telephoneInternet = tel;
        this.communalExpenses = cu;
        this.food = food;
        this.travelCard = tc;
        this.otherExpense = other;
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

    public int getLoans() {
        return loans;
    }

    public void setLoans(int loans) {
        this.loans = loans;
    }

    public int getTelephoneInternet() {
        return telephoneInternet;
    }

    public void setTelephoneInternet(int telephoneInternet) {
        this.telephoneInternet = telephoneInternet;
    }

    public int getCommunalExpenses() {
        return communalExpenses;
    }

    public void setCommunalExpenses(int communalExpenses) {
        this.communalExpenses = communalExpenses;
    }

    public int getFood() {
        return food;
    }

    public void setFood(int food) {
        this.food = food;
    }

    public int getTravelCard() {
        return travelCard;
    }

    public void setTravelCard(int travelCard) {
        this.travelCard = travelCard;
    }

    public int getOtherExpense() {
        return otherExpense;
    }

    public void setOtherExpense(int otherExpense) {
        this.otherExpense = otherExpense;
    }

    public int getTotal() {
        return loans+otherExpense+travelCard+food+communalExpenses+telephoneInternet;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    
}