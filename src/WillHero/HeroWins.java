package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class HeroWins {
	@FXML
	private ImageView menuButton;
	@FXML
	private ImageView exitButton;
	@FXML
	private AnchorPane anchorPane;
	
	
	public void hover1(MouseEvent event) throws URISyntaxException {
	    	Image image = new Image(getClass().getResource("/assets/dark_new_gamebutton.png").toURI().toString());
			menuButton.setImage(image); 
	}
	
	public void unhover1(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/new_game_button.png").toURI().toString());
		menuButton.setImage(image);
	}
	
	public void hover2(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_exit_button.png").toURI().toString());
		exitButton.setImage(image); 
	}
	
	public void unhover2(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/exit_button.png").toURI().toString());
		exitButton.setImage(image);
	}
	
	public void exit(MouseEvent e){	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("You're about to Exit!");
		Stage mystage = (Stage)anchorPane.getScene().getWindow();
		if (alert.showAndWait().get() == ButtonType.OK){
			mystage.close();
		} 
	}
	
	public void mainmenu(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
