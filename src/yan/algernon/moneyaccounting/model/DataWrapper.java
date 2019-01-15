
package yan.algernon.moneyaccounting.model;

import java.util.List;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "income")
public class DataWrapper {  

    private List<Income> income;
    private List<Expense> expense;
    

    @XmlElement 
    public List<Income> getIncome() {
        return income;
    }
    
    
    public void setIncome(List<Income> income) {
        this.income = income;
    }
    
    @XmlElement
    public List<Expense> getExpense() {
        return expense;
    }

    public void setExpense(List<Expense> expense) {
        this.expense = expense;
    }
    
    
    
}

