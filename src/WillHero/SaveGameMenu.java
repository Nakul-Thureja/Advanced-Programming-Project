package WillHero;

import java.io.FileOutputStream;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Collection;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.KeyValue;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.beans.value.WritableValue;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
//import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
//import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
//import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
public class SaveGameMenu implements Initializable {

	@FXML
	private ImageView backButton;
	@FXML
	private ImageView myJumper;
	@FXML
	private ImageView myHeart;
	@FXML
	private ImageView slot1;
	@FXML
	private ImageView slot2;
	@FXML
	private ImageView slot3;
	@FXML
	private ImageView slot4;

	public static void serialize(Game currGame) throws IOException {
		ObjectOutputStream out = null;
		out = new ObjectOutputStream (new FileOutputStream("savedgames.txt"));
		out.writeObject(currGame);
		out.close();
	} 
	
	public void goBack(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Pause.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Game currGame = (Game) stage.getUserData();
		serialize(currGame);
		System.out.println(currGame.getMyPlayer().getName());
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	

	public void hover1(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_saveslot1.png").toURI().toString());
		slot1.setImage(image);
	}
	public void hover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_back_button.png").toURI().toString());
		backButton.setImage(image);
	}

	public void unhover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/back_button.png").toURI().toString());
		backButton.setImage(image);
	}
	public void unhover1(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/saveslot1.png").toURI().toString());
		slot1.setImage(image);
	}

	public void hover2(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_saveslot2.png").toURI().toString());
		slot2.setImage(image);
	}

	public void unhover2(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/saveslot2.png").toURI().toString());
		slot2.setImage(image);
	}

	public void hover3(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_saveslot3.png").toURI().toString());
		slot3.setImage(image);
	}

	public void unhover3(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/saveslot3.png").toURI().toString());
		slot3.setImage(image);
	}
	
	public void hover4(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_saveslot4.png").toURI().toString());
		slot4.setImage(image);
	}

	public void unhover4(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/saveslot4.png").toURI().toString());
		slot4.setImage(image);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(myJumper);
		translate.setDuration(Duration.millis(750));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByY(-85);
		translate.setAutoReverse(true);
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(myJumper);
		scale.setDuration(Duration.millis(750));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(-0.1);
		scale.setByY(0.1);
		scale.setAutoReverse(true);
		
		ScaleTransition scale3 = new ScaleTransition();
		scale3.setNode(myHeart);
		scale3.setDuration(Duration.millis(750));
		scale3.setCycleCount(ScaleTransition.INDEFINITE);
		scale3.setInterpolator(Interpolator.LINEAR);
		scale3.setByX(0.3);
		scale3.setByY(0.3);
		scale3.setAutoReverse(true);
		  
		translate.play();
		scale.play();
		scale3.play();
	}

}
