
package yan.algernon.moneyaccounting.fxml;

import java.io.File;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.FileChooser;
import yan.algernon.moneyaccounting.MainApp;


public class MainLayoutController {
    private MainApp mainApp;
    
    
  public void setMainApp(MainApp mainApp) {
        this.mainApp = mainApp;
  }
  
  
  @FXML
  private void handleNew(){
        mainApp.getExpenseList().clear();
        mainApp.getIncomeList().clear();
        mainApp.getTotalList().clear();
        mainApp.setDataFilePath(null);
  }
  
  @FXML
    private void handleOpen() {
        FileChooser fileChooser = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File file = fileChooser.showOpenDialog(mainApp.getPrimaryStage());

        if (file != null) {
            mainApp.loadDataFromFile(file);
        }
    }
    
    @FXML
    private void handleSave() {
        File DataFile = mainApp.getDaTAFilePath();
        if (DataFile != null) {
            mainApp.saveDataToFile(DataFile);
        } else {
            handleSaveAs();
        }
    }
    
    @FXML
    private void handleSaveAs() {
        FileChooser fileChooser = new FileChooser();
        
        FileChooser.ExtensionFilter extFilter = new FileChooser.ExtensionFilter(
                "XML files (*.xml)", "*.xml");
        fileChooser.getExtensionFilters().add(extFilter);
        
        File file = fileChooser.showSaveDialog(mainApp.getPrimaryStage());

        if (file != null) {
             
            if (!file.getPath().endsWith(".xml")) {
                file = new File(file.getPath() + ".xml");
            }
            mainApp.saveDataToFile(file);
        }
    }
     
    @FXML
    private void handleAbout() {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle("Программа учета денежных средств");
        alert.setHeaderText("О программе");
        alert.setContentText("Автор: Александр Юциков");

        alert.showAndWait();
    }
    
    @FXML
    private void handleExit() {
        System.exit(0);
    }
    
}
