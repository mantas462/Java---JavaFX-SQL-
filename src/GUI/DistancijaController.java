package GUI;

import java.sql.SQLException;
import java.util.ArrayList;

import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class DistancijaController {

	Stage stage;
	
	
	@FXML
	private ComboBox combobox;
	@FXML
	private TableView tableview;
	
	public void quit() {
		Platform.exit();
		System.exit(0);
	}

	public void load() throws SQLException {
tableview.setColumnResizePolicy(TableView.CONSTRAINED_RESIZE_POLICY);
		
		TableColumn tableColumn1=new TableColumn("nr");
		TableColumn tableColumn2=new TableColumn("laikas");
		
		tableColumn1.setCellValueFactory(new PropertyValueFactory<>("nr"));	
		tableColumn2.setCellValueFactory(new PropertyValueFactory<>("laikas"));	
		
		tableview.getColumns().add(tableColumn1);
		tableview.getColumns().add(tableColumn2);
		
		int[] atstumas= Start.todo.getAtstumai();
		
		
		ArrayList<Integer> list = new ArrayList<Integer>();
		list.add(0);
		for(int i=0; i<atstumas.length; i++) {
			list.add(atstumas[i]);
		}
		
		combobox.getItems().addAll(list);
	}

	public void action() throws SQLException {
		
		
		
		int selection=(int) combobox.getSelectionModel().getSelectedItem();
		
	
		ObservableList observableList=null;
		
		if(selection!=0) { observableList =FXCollections.observableList(Start.todo.getNeededBegikas(selection)); }
		else {
			observableList =FXCollections.observableList(Start.todo.getBegikas());
				}
		
		tableview.setItems(observableList);
		

		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Pranesimas");
		alert.setHeaderText("Viso irasu: " + Start.todo.getirasuskaicius());
		if (selection!=0) {
		alert.setContentText("Cia parodyta: " + Start.todo.getreikiamuirasuskaicius(selection));
		}
		else {
			alert.setContentText("Cia parodyta: " + Start.todo.getirasuskaicius());
		}
		alert.showAndWait();
	}
	
	public void gotoBegikuSarasas () throws Exception {
		
		
		FXMLLoader load = new FXMLLoader(getClass().getResource("Sarasas.fxml"));	
		Parent root = load.load();	
		
		SarasasController controller=load.getController();
	    controller.tableview();
	
	    stage = (Stage) tableview.getScene().getWindow();
		Scene scene = new Scene(root);		
		stage.setScene(scene);
		stage.setTitle("2-asis tarpinis atsiskaitymas");
		stage.show();
	}
	
	
	
}
