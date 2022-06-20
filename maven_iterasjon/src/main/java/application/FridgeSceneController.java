package application;

import java.io.IOException;

import Entiteter.Kj�leskap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.stage.Stage;

public class FridgeSceneController {
	
	private Stage stage;
	private Parent root;
	private Scene scene;
	private Kj�leskap kj�leskap;
	@FXML
	private Button fridgeButton;
	@FXML
	private Button addButton;
	@FXML
	private Button visButton;
	@FXML
	private Label varer;

	public void switchToAdd(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
		root = loader.load();
		
		SceneController scene2Controller = loader.getController();
		scene2Controller.setKj�leskap(kj�leskap);
		
		//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	
	public void setKj�leskap(Kj�leskap kj�leskap) {
		this.kj�leskap=kj�leskap;
	}
	
	public void visVarer(ActionEvent event) {
		varer.setText(kj�leskap.toString());
		System.out.println(kj�leskap.toString());
		System.out.println(kj�leskap.toString().equals(""));
	}
	
	public void switchToFridge(ActionEvent event) throws IOException {
		FXMLLoader loader = FXMLLoader.load(getClass().getResource("Fridge.fxml"));
		root = loader.load();
		
		FridgeSceneController scene2 = loader.getController();
		scene2.setKj�leskap(kj�leskap);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();

	}
	
}
