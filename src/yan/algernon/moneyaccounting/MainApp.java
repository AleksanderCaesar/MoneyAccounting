package yan.algernon.moneyaccounting;

import java.io.File;
import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import yan.algernon.moneyaccounting.fxml.MainViewController;
import yan.algernon.moneyaccounting.fxml.NewWindowIncome;
import yan.algernon.moneyaccounting.model.Expense;
import yan.algernon.moneyaccounting.model.Income;
import yan.algernon.moneyaccounting.fxml.IncomeViewController;
import yan.algernon.moneyaccounting.fxml.NewWindowExpense;
import yan.algernon.moneyaccounting.model.Total;


/** 
 * @author Alexander
 */
public class MainApp extends Application {
  private  Stage primaryStage;
  BorderPane mainRoot;
  private static ObservableList<Income> incomeList = FXCollections.observableArrayList();
  private static ObservableList<Expense> expenseList = FXCollections.observableArrayList();
  private static ObservableList<Total> totalList = FXCollections.observableArrayList();
  
          
    
    
    public MainApp(){ 
        
        incomeList.add(new Income("2018","december", 29500,14000,0));
        incomeList.add(new Income("2018","november", 55000, 14000, 25000));
        incomeList.add(new Income("2018","may", 35500,15000,10000));
         
        expenseList.add(new Expense("2018","may", 15000, 2300, 7000, 15500, 2300, 9000));
        expenseList.add(new Expense("2018","december", 17000, 2000, 8500, 12000, 2000, 5000));
        expenseList.add(new Expense("2018","november", 17500, 2200, 8000, 13000, 2500, 7500));
       
        
    }
    
    
    @Override
    public void start(Stage primaryStage) {        
        this.primaryStage = primaryStage;
        this.primaryStage.setTitle("Программа учета денежных средств");
        primaryStage.setResizable(false);
        
        initRootLayout();
        initMainView(); 
        // showTotalList() Для проверки
        
    }
    
    public void getTotal(){
        
    }
    public void initRootLayout(){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fxml/MainLayout.fxml"));
            mainRoot = (BorderPane) loader.load();
           
            
            Scene scene = new Scene(mainRoot);
            primaryStage.setScene(scene);
            primaryStage.show();
        } catch (IOException e){
            e.printStackTrace();
        }
    }
    
    
    public void initMainView (){        
          try {            
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fxml/MainView.fxml"));
            AnchorPane MainView = (AnchorPane) loader.load();           
            mainRoot.setCenter(MainView);            
            
            MainViewController controller = loader.getController();
            controller.setMainApp(this);
            
        }  catch (IOException e) {
            e.printStackTrace();
        }          
    }
    
    
    public Stage getPrimaryStage() {
        return primaryStage;
    }
    
    public ObservableList<Income> getIncomeList(){
        return incomeList;
    }
    
    public ObservableList<Expense>  getExpenseList(){
        return expenseList;
    }  
    
    public ObservableList<Total>  getTotalList(){
        return totalList;
    }    
    
    
    public boolean showNewIncomeWindow(Income income){
        
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fxml/EditIncome.fxml"));
            AnchorPane windowIncome = (AnchorPane) loader.load();
          
            Stage windowStage = new Stage();
            windowStage.setTitle("Доходы за месяц");
            Scene scene = new Scene(windowIncome);
            windowStage.setScene(scene);    
            
            NewWindowIncome controller = loader.getController();
            controller.setWindowStage(windowStage);
            controller.setIncomeData(income);
            windowStage.showAndWait();
            return  controller.isOkClicked();
        } catch (IOException e) {
            e.printStackTrace();
        }    
        return false;
    }
    
    public boolean showNewExpenseWindow(Expense expense){
        try{
            FXMLLoader loader = new FXMLLoader();
            loader.setLocation(getClass().getResource("fxml/EditExpense.fxml"));
            AnchorPane windowExpense = (AnchorPane)loader.load();
            
            Stage windowStage = new Stage();
            windowStage.setTitle("Расходы за месяц");
            Scene scene = new Scene(windowExpense);
            windowStage.setScene(scene);
            
            NewWindowExpense controller = loader.getController();
            controller.setWindowStage(windowStage);
            controller.setExpenseData(expense);
            windowStage.showAndWait();
            return  controller.isOkClicked();            
        } catch(IOException e) {
            e.printStackTrace();
        }    
        return false;
    }
    
     public  static Income getIncomeByMonthAndYear(String year, String month){
        Income tempIncome = new Income();
        for(Income inc : incomeList ){
            if(inc.getYearString().equals(year) & inc.getMonthString().equals(month)){
                tempIncome = inc;
            }                
        }            
        return tempIncome;
    }
    
    public static Expense getExpenseByMonthAndYear(String year, String month){
        Expense tempExpense = new Expense();
        for(Expense exp : expenseList){
            if(exp.getYearString().equals(year) & exp.getMonthString().equals(month)){
                tempExpense = exp;
            }                
        }            
        return tempExpense;
    }
          
    
    public static void main(String[] args) {
        launch(args);
        
    }
    
    /* Для проверки
    public  void showTotalList(){
      for(Total total : totalList){
          System.out.print("Итого за "+total.getMonth()+" "+total.getYear()+"г. "+ " Всего доходов: "+ total.getTotalIncome()+
                  ". Всего расходов :"+total.getTotalExpense()+". Чистый доход составил :"+total.getDifference());
          System.out.println();
      }
  } */
    public void getAllDataForTotalList(){
        Total tempTotal = new Total();
        totalList.clear();
        for(Income inc : incomeList){
            Total tempTtl = new Total();
            tempTtl.setYear(inc.getYear());
            tempTtl.setMonth(inc.getMonth());
            tempTtl.setTotalIncome(inc.getTotal());
            tempTtl.setTotalExpense(getExpenseByMonthAndYear(inc.getYearString(),inc.getMonthString()).getTotal());
            
            tempTotal = tempTtl;
            totalList.add(tempTotal);
        }
    } 
    
}

