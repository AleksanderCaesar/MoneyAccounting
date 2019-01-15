package yan.algernon.moneyaccounting;

import java.beans.XMLEncoder;
import java.io.File;
import java.io.FileOutputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.util.prefs.Preferences;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javax.xml.bind.JAXBContext;
import javax.xml.bind.Marshaller;
import javax.xml.bind.Unmarshaller;
import javax.xml.transform.Result;
import javax.xml.transform.Source;
import javax.xml.transform.Transformer;
import javax.xml.transform.TransformerFactory;
import javax.xml.transform.dom.DOMSource;
import javax.xml.transform.stream.StreamResult;
import yan.algernon.moneyaccounting.fxml.MainViewController;
import yan.algernon.moneyaccounting.fxml.NewWindowIncome;
import yan.algernon.moneyaccounting.model.Expense;
import yan.algernon.moneyaccounting.model.Income;
import yan.algernon.moneyaccounting.fxml.IncomeViewController;
import yan.algernon.moneyaccounting.fxml.MainLayoutController;
import yan.algernon.moneyaccounting.fxml.NewWindowExpense;
import yan.algernon.moneyaccounting.model.DataWrapper;
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
        
        incomeList.add(new Income("2018","december",55000,25000,15000));
        incomeList.add(new Income("2018","november",65000,25000,15500));
        incomeList.add(new Income("2018","may",68000,30000,20000));
         
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
            MainLayoutController controller = loader.getController();
            controller.setMainApp(this); 
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
            if(inc.getYear().equals(year) & inc.getMonth().equals(month)){
                tempIncome = inc;
            }                
        }            
        return tempIncome;
    }
    
    public static Expense getExpenseByMonthAndYear(String year, String month){
        Expense tempExpense = new Expense();
        for(Expense exp : expenseList){
            if(exp.getYear().equals(year) & exp.getMonth().equals(month)){
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
          System.out.print("Итого за "+total.getMonth()+" "+total.getYearProperty()+"г. "+ " Всего доходов: "+ total.getTotalIncome()+
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
            tempTtl.setTotalExpense(getExpenseByMonthAndYear(inc.getYear(),inc.getMonth()).getTotal());
            
            tempTotal = tempTtl;
            totalList.add(tempTotal);
        }
    } 
    
    public void setDataFilePath(File file) {
         
     
       Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
        if (file != null) {
        prefs.put("filePath", file.getPath());

        primaryStage.setTitle("Программа учета денежных средств -  " + file.getName());
      } else {
        prefs.remove("filePath");

        primaryStage.setTitle("Программа учета денежных средств");
      }
    }
    
    public File getDaTaFilePath() {
       
         Preferences prefs = Preferences.userNodeForPackage(MainApp.class);
       String filePath = prefs.get("filePath", null);
       if (filePath != null) {
        return new File(filePath);
     } else {
        return null;
      }
    }
    
     public void loadDataFromFile(File file){         
     
         try{
             JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
             Unmarshaller um = context.createUnmarshaller();             
              
              DataWrapper wrapper = (DataWrapper)um.unmarshal(file);
              
              expenseList.clear();
              incomeList.clear();
              totalList.clear();
              expenseList.addAll(wrapper.getExpense());
              incomeList.addAll(wrapper.getIncome());
                           
              
              setDataFilePath(file);
              
         } catch (Exception e) { 
        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not load data");
        alert.setContentText("Could not load data from file:\n" + file.getPath());

        alert.showAndWait();
     }
  }
     
     public void saveDataToFile(File file){
         
          try {
              JAXBContext context = JAXBContext.newInstance(DataWrapper.class);
             Marshaller m = context.createMarshaller();
             m.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, true);
             
             
            
             DataWrapper wrExp = new DataWrapper();
             wrExp.setIncome(incomeList);
             wrExp.setExpense(expenseList);             
             
             m.marshal(wrExp, file);
             
             setDataFilePath(file);    
        
        
        
    } catch (Exception e) { 
        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setHeaderText("Could not save data");
        alert.setContentText("Could not save data to file:\n" + file.getPath());

        alert.showAndWait();
       }
    }
    
}

