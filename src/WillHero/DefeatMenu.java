package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
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
import javafx.scene.text.Text;
//import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
//import javafx.animation.TranslateTransition;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.image.ImageView;
//import javafx.scene.transform.Rotate;
//import javafx.util.Duration;

public class DefeatMenu {

	
	@FXML
	private ImageView restartButton;
	@FXML
	private ImageView mainButton;
	@FXML
	private ImageView coinButton;
	@FXML
	private ImageView myHero;
	@FXML
	private Text myScore;
	@FXML
	private AnchorPane anchorPane;

	public void spendCoin() throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Continue To Play ?");
		alert.setHeaderText("You're about to spend 5 coins");
		alert.getButtonTypes().clear();
		alert.getButtonTypes().add(ButtonType.YES);
		alert.getButtonTypes().add(ButtonType.NO);
		//alert.setContentText("Do you want to save before exiting?");
		Stage mystage = (Stage)anchorPane.getScene().getWindow();
		if (alert.showAndWait().get() == ButtonType.YES){
			Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
			Stage stage = mystage;
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();			
		} 
	}
	
	public void restartHandler(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void mainHandler(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}


	public void hover1(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_restart_combo.png").toURI().toString());
		restartButton.setImage(image);
	}

	public void unhover1(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/restart_combo.png").toURI().toString());
		restartButton.setImage(image);
	}

	
	public void hover2(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_menu_combo.png").toURI().toString());
		mainButton.setImage(image);
	}

	public void unhover2(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/menu_combo.png").toURI().toString());
		mainButton.setImage(image);
	}
	
	public void hover3(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_coin_button.png").toURI().toString());
		coinButton.setImage(image);
	}

	public void unhover3(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/coin_button.png").toURI().toString());
		coinButton.setImage(image);
	}


}
