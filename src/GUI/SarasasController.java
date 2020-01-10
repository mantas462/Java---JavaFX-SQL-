package GUI;

import java.io.IOException;
import java.sql.SQLException;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class SarasasController {

	Stage stage;
	
	@FXML
	private TableView tableview;
	
	public void tableview() throws Exception {
	
		tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		TableColumn tableColumn1=new TableColumn("nr");
		TableColumn tableColumn2=new TableColumn("atstumas");
		TableColumn tableColumn3=new TableColumn("vardas");
		TableColumn tableColumn4=new TableColumn("pavarde");
		TableColumn tableColumn5=new TableColumn("laikas");
		
		
		tableColumn1.setCellValueFactory(new PropertyValueFactory<>("nr"));	
		tableColumn2.setCellValueFactory(new PropertyValueFactory<>("atstumas"));	
		tableColumn3.setCellValueFactory(new PropertyValueFactory<>("vardas"));	
		tableColumn4.setCellValueFactory(new PropertyValueFactory<>("pavarde"));	
		tableColumn5.setCellValueFactory(new PropertyValueFactory<>("laikas"));	
		
		ObservableList observableList =FXCollections.observableList(Start.todo.getBegikas());
		
		tableview.getColumns().add(tableColumn1);
		tableview.getColumns().add(tableColumn2);
		tableview.getColumns().add(tableColumn3);
		tableview.getColumns().add(tableColumn4);
		tableview.getColumns().add(tableColumn5);
		
		tableview.setItems(observableList);

		
	}
	
	public void goToDistancija() throws IOException, SQLException {
		FXMLLoader load = new FXMLLoader(getClass().getResource("Distancija.fxml"));	
		Parent root = load.load();	
		
		DistancijaController controller=load.getController();
	    controller.load();
		
		stage = (Stage) tableview.getScene().getWindow();
		Scene scene = new Scene(root);		
		stage.setScene(scene);
		stage.setTitle("2-asis tarpinis atsiskaitymas");
		stage.show();
	}
	
	
	public void quit() {
		Platform.exit();
		System.exit(0);
	}
	
}
