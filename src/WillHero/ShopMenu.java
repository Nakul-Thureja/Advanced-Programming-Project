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
import javafx.scene.text.Text;
import javafx.stage.Stage;

public class ShopMenu {
	@FXML
	private ImageView hero1;
	@FXML
	private ImageView hero2;
	@FXML
	private ImageView hero3;
	@FXML
	private ImageView hero4;
	@FXML
	private ImageView booster;
	@FXML
	private Text coinCounter;
	@FXML
	private Text playerName;
	@FXML
	private ImageView backButton;
	@FXML
	private ImageView beginner;
	@FXML
	private Text texter;
	
	private Gamer currGamer;
	
	public void buyHero1(MouseEvent e) {
		int val = currGamer.canBuy(1,10);
		if( val == 2) {
			//System.out.println("hello");
			currGamer.addHelmet(1);
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Successful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}
		else {
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Unsuccessful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}
			
	}
    
	public void buyHero2(MouseEvent e) {
		int val = currGamer.canBuy(2,10);
		if( val == 2) {
			currGamer.addHelmet(2);
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Successful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}
		else {
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Unsuccessful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}
	}
    
	public void buyHero3(MouseEvent e) {
		int val = currGamer.canBuy(3,20);
		if( val == 2) {
			currGamer.addHelmet(3);
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Successful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}
		else {
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Unsuccessful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}
		
	}
    
	public void buyHero4(MouseEvent e) {
		int val = currGamer.canBuy(4,20);
		if( val == 2) {
			currGamer.addHelmet(4);
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Successful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}	
		else {
			Alert alert2 = new Alert(AlertType.WARNING);
			alert2.setContentText("Purchase Unsuccessful");
			alert2.setHeaderText(null);
			alert2.setTitle(null);
			alert2.showAndWait();
		}
	}
	
	public void buyBooster(MouseEvent e) {
		currGamer.setBooster(true);
		Alert alert2 = new Alert(AlertType.WARNING);
		alert2.setContentText("Purchase Successful");
		alert2.setHeaderText(null);
		alert2.setTitle(null);
		alert2.showAndWait();
	}
	public void hover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_back_button.png").toURI().toString());
		backButton.setImage(image);
	}

	public void unhover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/back_button.png").toURI().toString());
		backButton.setImage(image);
	}
	
	public void init(MouseEvent event) {
		beginner.setVisible(false);
		texter.setVisible(false);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		currGamer = (Gamer) stage.getUserData();
		//Game currGame = currGamer.getcurrGame();
		//myScore.setText(Integer.toString(currGame.getScore()));
		coinCounter.setText(Integer.toString(currGamer.getCoins()));
		playerName.setText(currGamer.getPlayerName());

	}
	
	public void goBack(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Pause.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		currGamer = (Gamer) stage.getUserData();
		Game currGame = currGamer.getcurrGame();		
		stage.setUserData(currGamer);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
}
