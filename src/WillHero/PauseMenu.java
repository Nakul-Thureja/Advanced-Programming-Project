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

public class PauseMenu {
	
	@FXML
	private ImageView resumeButton;
	@FXML
	private ImageView restartButton;
	@FXML
	private ImageView saveButton;
	@FXML
	private ImageView mainButton;
	
	public void resumeHandler(MouseEvent event) {
		
	}
	
	public void restartHandler(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void saveHandler(MouseEvent event) {
		
	}
	
	public void mainHandler(MouseEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void hover1(MouseEvent event) throws URISyntaxException {
    	Image image = new Image(getClass().getResource("/assets/dark_resume_combo.png").toURI().toString());
		resumeButton.setImage(image); 
}

	public void unhover1(MouseEvent event) throws URISyntaxException {
	Image image = new Image(getClass().getResource("/assets/resume_combo.png").toURI().toString());
	resumeButton.setImage(image);
}
	public void hover2(MouseEvent event) throws URISyntaxException {
    	Image image = new Image(getClass().getResource("/assets/dark_restart_combo.png").toURI().toString());
		restartButton.setImage(image); 
}

	public void unhover2(MouseEvent event) throws URISyntaxException {
	Image image = new Image(getClass().getResource("/assets/restart_combo.png").toURI().toString());
		restartButton.setImage(image);
}
	public void hover3(MouseEvent event) throws URISyntaxException {
    	Image image = new Image(getClass().getResource("/assets/dark_save_combo.png").toURI().toString());
		saveButton.setImage(image); 
}

	public void unhover3(MouseEvent event) throws URISyntaxException {
	Image image = new Image(getClass().getResource("/assets/save_combo.png").toURI().toString());
		saveButton.setImage(image);
}
	public void hover4(MouseEvent event) throws URISyntaxException {
    	Image image = new Image(getClass().getResource("/assets/dark_menu_combo.png").toURI().toString());
		mainButton.setImage(image); 
}

	public void unhover4(MouseEvent event) throws URISyntaxException {
	Image image = new Image(getClass().getResource("/assets/menu_combo.png").toURI().toString());
		mainButton.setImage(image);
}
	
	
	

}
