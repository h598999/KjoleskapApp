package application;

import java.awt.image.BufferedImage;
import java.io.IOException;
import java.net.URI;
import java.net.URL;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import Entiteter.Kj�leskap;
import HjelpeKlasser.image;
import javafx.embed.swing.SwingFXUtils;
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
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class FridgeSceneController {
	
	private Stage stage;
	private Parent root;
	private Scene scene;
	private Kj�leskap kj�leskap;
	private int bildeRunner = 0;
	@FXML
	private Button fridgeButton;
	@FXML
	private Button addButton;
	@FXML
	private Button visButton;
	@FXML
	private GridPane myGridPane;
	

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
	
	public void visVarer(ActionEvent event) throws IOException {
		
		for (int i = 0; i<kj�leskap.getAntal(); i++) {
			Label label = new Label();
			ImageView bilde = new ImageView();
			label.setText(kj�leskap.entryToString(i));
			bilde.setImage(image.createImageIcon(kj�leskap.getAlle()[i].getKey().getImages()[0].getMedium()));
			myGridPane.add(label, 0, i);
			myGridPane.add(bilde, 1, i);
			

		}
		
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
