package application;

import java.io.IOException;
import java.net.URI;

import Entiteter.Kjøleskap;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

public class FridgeSceneController {
	
	private Stage stage;
	private Parent root;
	private Scene scene;
	private Kjøleskap kjøleskap = new Kjøleskap();
	@FXML
	private Button fridgeButton;
	@FXML
	private Button addButton;
	@FXML
	private Button visButton;
	@FXML
	private Label varer;
	@FXML
	private ImageView myImageView;
	String url = (kjøleskap.getAlle()[0].getKey().getImages()[0].getThumb());
	Image bilde = new Image(getClass().getResourceAsStream(url));

	public void switchToAdd(ActionEvent event) throws IOException {
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Scene1.fxml"));
		root = loader.load();
		
		SceneController scene2Controller = loader.getController();
		scene2Controller.setKjøleskap(kjøleskap);
		
		//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		
		stage.setScene(scene);
		stage.setMaximized(true);
		stage.show();
	}
	
	public void setKjøleskap(Kjøleskap kjøleskap) {
		this.kjøleskap=kjøleskap;
	}
	
	public void visVarer(ActionEvent event) {
		varer.setText(kjøleskap.toString());
		myImageView.setImage(bilde);
		System.out.println(kjøleskap.toString());
		System.out.println(kjøleskap.toString().equals(""));
	}
	
	public void switchToFridge(ActionEvent event) throws IOException {
		FXMLLoader loader = FXMLLoader.load(getClass().getResource("Fridge.fxml"));
		root = loader.load();
		
		FridgeSceneController scene2 = loader.getController();
		scene2.setKjøleskap(kjøleskap);
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
		String css = this.getClass().getResource("application.css").toExternalForm();
		scene.getStylesheets().add(css);
		stage.setScene(scene);
		stage.show();

	}
	
}
