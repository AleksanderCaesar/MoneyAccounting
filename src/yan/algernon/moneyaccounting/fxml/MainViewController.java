
package yan.algernon.moneyaccounting.fxml;

import java.io.IOException;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Modality;
import javafx.stage.Stage;
import yan.algernon.moneyaccounting.MainApp;
import yan.algernon.moneyaccounting.model.Expense;
import yan.algernon.moneyaccounting.model.Total;


/**
 *
 * @author Alexander
 */
public class MainViewController {
    @FXML
    private TableView<Total> totalTable;
    @FXML
    private TableColumn<Total,String> yearColumn;
    @FXML
    private TableColumn<Total,String> monthColumn;
    @FXML
    private TableColumn<Total,Integer> incomeTotalColumn;
    @FXML
    private TableColumn<Total,Integer> expenseTotalColumn;
    @FXML
    private TableColumn<Total,Integer> differenceColumn;
    
    
    private MainApp mainApp;  
    
    
  public MainViewController (){
      
  }
  
   public void initialize(){       
       
       
   }
   
   
  public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;  
        
  }
    
  @FXML
  private void incomeButton(){
      try{
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("IncomeView.fxml"));
          AnchorPane windowIncome = (AnchorPane) loader.load();
          
          Stage windowStage = new Stage();
          windowStage.setTitle("Список поступлений");
          windowStage.initModality(Modality.WINDOW_MODAL);
          windowStage.initOwner(mainApp.getPrimaryStage());
          Scene scene = new Scene(windowIncome);
          windowStage.setScene(scene);
          IncomeViewController controller = loader.getController();
          controller.setWindowStage(windowStage);
          controller.setMainApp(mainApp);
          
          windowStage.showAndWait();
      } catch (IOException e) {
            e.printStackTrace();
        }
      
  }
  @FXML
  private void expenseButton(){
      try{
          FXMLLoader loader = new FXMLLoader();
          loader.setLocation(getClass().getResource("ExpenseView.fxml"));
          AnchorPane windowIncome = (AnchorPane) loader.load();
          
          Stage windowStage = new Stage();
          windowStage.setTitle("Список расходов");
          windowStage.initModality(Modality.WINDOW_MODAL);
          windowStage.initOwner(mainApp.getPrimaryStage());
          Scene scene = new Scene(windowIncome);
          windowStage.setScene(scene);
          ExpenseViewController controller = loader.getController();
          controller.setWindowStage(windowStage);
          controller.setMainApp(mainApp);
          windowStage.showAndWait();
      } catch (IOException e) {
            e.printStackTrace();
        }   
  }   
  
  @FXML
  private void renewData(){
      mainApp.getAllDataForTotalList();
      yearColumn.setCellValueFactory(new PropertyValueFactory<>("year"));
      monthColumn.setCellValueFactory(new PropertyValueFactory<>("month"));
      incomeTotalColumn.setCellValueFactory(new PropertyValueFactory<>("totalIncome"));
      expenseTotalColumn.setCellValueFactory(new PropertyValueFactory<>("totalExpense"));
      differenceColumn.setCellValueFactory(new PropertyValueFactory<>("difference"));
      totalTable.setItems(mainApp.getTotalList());
      
      
  }
    
}
