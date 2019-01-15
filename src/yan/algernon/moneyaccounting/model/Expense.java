
package yan.algernon.moneyaccounting.model;

import javafx.beans.property.IntegerProperty;
import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author Alexander
 */
public class Expense {
    private StringProperty year;
    private StringProperty month;
    private IntegerProperty loans;
    private IntegerProperty telephoneInternet;
    private IntegerProperty communalExpenses;
    private IntegerProperty food;
    private IntegerProperty travelCard;
    private IntegerProperty otherExpense;
    private IntegerProperty total;
    
    public Expense(){
        this.month = new SimpleStringProperty();
        this.year = new SimpleStringProperty();
        this.loans = new SimpleIntegerProperty();
        this.telephoneInternet = new SimpleIntegerProperty();
        this.communalExpenses = new SimpleIntegerProperty();
        this.food = new SimpleIntegerProperty();
        this.travelCard = new SimpleIntegerProperty();
        this.otherExpense = new SimpleIntegerProperty();
        this.total = new SimpleIntegerProperty();        
    }
    
    public Expense(String year, String month, int loans, int tel, int cu, int food, int tc, int other){
        this.month = new SimpleStringProperty(month);
        this.year = new SimpleStringProperty(year);
        this.loans = new SimpleIntegerProperty(loans);
        this.telephoneInternet = new SimpleIntegerProperty(tel);
        this.communalExpenses = new SimpleIntegerProperty(cu);
        this.food = new SimpleIntegerProperty(food);
        this.travelCard = new SimpleIntegerProperty(tc);
        this.otherExpense = new SimpleIntegerProperty(other);
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

    public IntegerProperty getLoans() {
        return loans;
    }

    public void setLoans(Integer loans) {
        this.loans.set(loans);
    }

    public IntegerProperty getTelephoneInternet() {
        return telephoneInternet;
    }

    public void setTelephoneInternet(Integer telephoneInternet) {
        this.telephoneInternet.set(telephoneInternet) ;
    }

    public IntegerProperty getCommunalExpenses() {
        return communalExpenses;
    }

    public void setCommunalExpenses(Integer communalExpenses) {
        this.communalExpenses.set(communalExpenses) ;
    }

    public IntegerProperty getFood() {
        return food;
    }

    public void setFood(Integer food) {
        this.food.set(food) ;
    }

    public IntegerProperty getTravelCard() {
        return travelCard;
    }

    public void setTravelCard(Integer travelCard) {
        this.travelCard.set(travelCard); 
    }

    public IntegerProperty getOtherExpense() {
        return otherExpense;
    }

    public void setOtherExpense(Integer otherExpense) {
        this.otherExpense.set(otherExpense);
    }

    public IntegerProperty getTotal() {
        int totalInt = loans.get() + telephoneInternet.get() + communalExpenses.get() + food.get()
                      + travelCard.get() + otherExpense.get();
        total.set(totalInt);
        return total;
    }

    public String getYearString(){
        return year.get();
    }
    
    public String getMonthString(){
        return month.get();
    }
    
    public int getLoansInt(){
        return loans.get();
    }
    
    public int getTelInternetInt(){
        return telephoneInternet.get();
    }
    
    public int getCommunalExpensesInt(){
        return communalExpenses.get();
    }
    
    public int getFoodInt(){
        return food.get();
    }
    
    public int getTravelCardInt(){
        return travelCard.get();
    }
    
    public int getOtherExpenseInt(){
        return otherExpense.get();
    }
    
    public int getTotalInt(){
        return total.get();
    }
}
