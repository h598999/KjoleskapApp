package application;

import java.io.IOException;
import java.net.URISyntaxException;
import Entiteter.Kjøleskap;
import Entiteter.Vare;
import HjelpeKlasser.BarCodeSaver;
import HjelpeKlasser.TableEntry;
import JPA.VareGetter;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.text.Text;
import javafx.scene.text.TextFlow;
import javafx.stage.Stage;


public class SceneController  {
	
	private Stage stage;
	private Scene scene;
	private Parent root;
	private Kjøleskap kjøleskap = new Kjøleskap();
	private BarCodeSaver saver = new BarCodeSaver();

	
	@FXML
	private Button leggTilButton;
	
	@FXML
	private Button visButton;
	
	@FXML
	TextField leggTilFelt;
	@FXML
	private Button addButton;
	@FXML
	private Button fridgeButton;
	@FXML
	private Button EnterButton;
	@FXML
	private Label varer;
	
	
	public void switchToFridge(ActionEvent event) throws IOException {
		VareGetter.getVarer(kjøleskap, saver);
		FXMLLoader loader = new FXMLLoader(getClass().getResource("Fridge.fxml"));
		root = loader.load();
		
		FridgeSceneController scene2Controller = loader.getController();
		scene2Controller.setKjøleskap(kjøleskap);
		//root = FXMLLoader.load(getClass().getResource("Scene2.fxml"));
		stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		scene = new Scene(root);
	
		stage.setScene(scene);
		
		stage.show();

	}
	
	public void Enter(ActionEvent event) {
		saver.add(leggTilFelt.getText());
		leggTilFelt.setText("");
	}
	
	public void leggTil(ActionEvent event) throws URISyntaxException, IOException, InterruptedException {
		VareGetter.getVarer(kjøleskap, saver);
	}
	
	

	
	public void setKjøleskap(Kjøleskap kjøleskap) {
		this.kjøleskap = kjøleskap;
	}
	
	

}
