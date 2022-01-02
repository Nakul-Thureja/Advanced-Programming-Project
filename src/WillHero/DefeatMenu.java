package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;
import javafx.stage.Stage;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

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
	@FXML
	private ImageView beginner;
	@FXML
	private Text coinCounter;
	@FXML
	private Text playerName;

	private Game currGame;

	public void spendCoin(MouseEvent e) throws IOException {
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Continue To Play ?");
		alert.setHeaderText("You're about to spend 5 coins");
		alert.getButtonTypes().clear();
		alert.getButtonTypes().add(ButtonType.YES);
		alert.getButtonTypes().add(ButtonType.NO);
		// alert.setContentText("Do you want to save before exiting?");
		Stage mystage = (Stage) anchorPane.getScene().getWindow();
		if (alert.showAndWait().get() == ButtonType.YES) {
			Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
			Stage stage = mystage;
			Gamer currGamer = (Gamer) stage.getUserData();
			currGame = currGamer.getcurrGame();
			currGamer.setFlag(true);
			if(currGamer.deduceCoins()) {
			currGame.stopALL();
			currGame.reviveHero();
			stage.setUserData(currGamer);
			Scene scene = new Scene(root);
			stage.setScene(scene);
			stage.show();
			}
			else {
				Alert alert2 = new Alert(AlertType.WARNING);
				alert2.setContentText("Don't have enough Coins :(");
				alert2.setHeaderText(null);
				alert2.setTitle(null);
				alert2.showAndWait();
			}
				
			}
		}
	

	public void restartHandler(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Gamer currGamer = (Gamer) stage.getUserData();
		Game currGame = currGamer.getcurrGame();
		currGamer.setFlag(false);
		stage.setUserData(currGamer);
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

	public void init_defeat(MouseEvent event) {
		beginner.setVisible(false);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Gamer currGamer = (Gamer) stage.getUserData();
		Game currGame = currGamer.getcurrGame();
		myScore.setText(Integer.toString(currGame.getScore()));
		coinCounter.setText(Integer.toString(currGamer.getCoins()));
		playerName.setText(currGamer.getPlayerName());

	}
}
