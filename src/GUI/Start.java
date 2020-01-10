package GUI;

import BACKEND.Todo;
import javafx.application.Application;
import javafx.application.Platform;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;


public class Start extends Application {	
	
	static Todo todo=new Todo();
	
    public static void main(String[] args) {
        launch(args);
    }
    


	@Override
	public void start(Stage stage) throws Exception {
		Todo todo;
		
		FXMLLoader load = new FXMLLoader(getClass().getResource("Sarasas.fxml"));	
		Parent root = load.load();	
		
		SarasasController controller=load.getController();
	    controller.tableview();
	
		Scene scene = new Scene(root);		
		stage.setScene(scene);
		stage.setTitle("2-asis tarpinis atsiskaitymas");
		stage.show();

	}
	
	
}