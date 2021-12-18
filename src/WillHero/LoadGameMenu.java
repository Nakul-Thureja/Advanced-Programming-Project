package WillHero;

import java.io.IOException;
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

public class LoadGameMenu {

	@FXML
	private ImageView homeButton;
	@FXML
	private ImageView myChest;
	@FXML
	private ImageView myChest2;
	@FXML
	private ImageView saveCoin;
	@FXML
	private ImageView slot1;
	@FXML
	private ImageView slot2;
	@FXML
	private ImageView slot3;
	@FXML
	private ImageView slot4;

	public void goHome(MouseEvent e) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	
	public void newGame(MouseEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	public void scale(MouseEvent e) throws IOException {
		 ScaleTransition scale = new ScaleTransition();
		  scale.setNode(saveCoin);
		  scale.setDelay(Duration.millis(300));
		  scale.setDuration(Duration.millis(600));
		  scale.setCycleCount(1);
		  scale.setInterpolator(Interpolator.LINEAR);
		  scale.setByX(100);
		  scale.setByY(100);
		  scale.play();
		  scale.setOnFinished(new EventHandler<ActionEvent>() {
				
				@Override
				public void handle(ActionEvent arg0) {				
					try {
						newGame(e);
					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
		  
	}
	public void translate(MouseEvent e) throws IOException {
		saveCoin.setVisible(true);
		TranslateTransition translate = new TranslateTransition();
		translate.setNode(saveCoin);
		translate.setDuration(Duration.millis(500));
		translate.setCycleCount(1);
		translate.setByY(-80);
		translate.play();
		translate.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {				
				try {
					scale(e);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public void slot1_click(MouseEvent e) throws IOException {
		translate(e);
		//newGame(e);
		
	}
	public void slot2_click(MouseEvent e) throws IOException {
		translate(e);
		//newGame(e);

	}
	public void slot3_click(MouseEvent e) throws IOException {
		translate(e);
		//newGame(e);

	}
	public void slot4_click(MouseEvent e) throws IOException {
		translate(e);
		//newGame(e);

	}
	


	public void hover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_homeButton.png").toURI().toString());
		homeButton.setImage(image);
	}

	public void unhover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/homeButton.png").toURI().toString());
		homeButton.setImage(image);
	}

	public void hover1(MouseEvent event) throws URISyntaxException {
		timeLineClose.stop();
		chestOPEN();
		Image image = new Image(getClass().getResource("/assets/dark_saveslot1.png").toURI().toString());
		slot1.setImage(image);
	}

	public void unhover1(MouseEvent event) throws URISyntaxException {
		timeLine.stop();
		chestCLOSE();
		Image image = new Image(getClass().getResource("/assets/saveslot1.png").toURI().toString());
		slot1.setImage(image);
	}

	public void hover2(MouseEvent event) throws URISyntaxException {
		timeLineClose.stop();
		chestOPEN();
		Image image = new Image(getClass().getResource("/assets/dark_saveslot2.png").toURI().toString());
		slot2.setImage(image);
	}

	public void unhover2(MouseEvent event) throws URISyntaxException {
		timeLine.stop();
		chestCLOSE();
		Image image = new Image(getClass().getResource("/assets/saveslot2.png").toURI().toString());
		slot2.setImage(image);
	}

	public void hover3(MouseEvent event) throws URISyntaxException {
		timeLineClose.stop();
		chestOPEN();
		Image image = new Image(getClass().getResource("/assets/dark_saveslot3.png").toURI().toString());
		slot3.setImage(image);
	}

	public void unhover3(MouseEvent event) throws URISyntaxException {
		timeLine.stop();
		chestCLOSE();
		Image image = new Image(getClass().getResource("/assets/saveslot3.png").toURI().toString());
		slot3.setImage(image);
	}

	public void hover4(MouseEvent event) throws URISyntaxException {
		chestOPEN();
		timeLineClose.stop();
		Image image = new Image(getClass().getResource("/assets/dark_saveslot4.png").toURI().toString());
		slot4.setImage(image);
	}

	public void unhover4(MouseEvent event) throws URISyntaxException {
		timeLine.stop();
		chestCLOSE();
		Image image = new Image(getClass().getResource("/assets/saveslot4.png").toURI().toString());
		slot4.setImage(image);
	}

	Timeline timeLine = new Timeline();
	Timeline timeLineClose = new Timeline();

	public void chestOPEN() {

		Collection<KeyFrame> frames = timeLine.getKeyFrames();
		Duration frameGap = Duration.millis(300);
		Duration frameTime = Duration.ZERO;

		//frameTime = frameTime.add(frameGap);
		frames.add(new KeyFrame(frameTime, e -> myChest.setVisible(true)));
		frames.add(new KeyFrame(frameTime, e -> myChest2.setVisible(false)));
		frameTime = frameTime.add(frameGap);
		frames.add(new KeyFrame(frameTime, e -> myChest.setVisible(false)));
		frames.add(new KeyFrame(frameTime, e -> myChest2.setVisible(true)));
		// frameTime = frameTime.add(frameGap);
//		frames.add(new KeyFrame(frameTime, e -> saveCoin.setVisible(true)));
//		frames.add(new KeyFrame(frameTime, e -> translate()));

		timeLine.setCycleCount(1);
		timeLine.play();
	}

	public void chestCLOSE() {

		Collection<KeyFrame> frames = timeLineClose.getKeyFrames();
		Duration frameGap = Duration.millis(200);
		Duration frameTime = Duration.ZERO;

		// frames.add(new KeyFrame(frameTime, e -> opp_translate()));
		//frameTime = frameTime.add(frameGap);
		frames.add(new KeyFrame(frameTime, e -> myChest.setVisible(false)));
		frames.add(new KeyFrame(frameTime, e -> myChest2.setVisible(true)));
		frameTime = frameTime.add(frameGap);
		frames.add(new KeyFrame(frameTime, e -> myChest.setVisible(true)));
		frames.add(new KeyFrame(frameTime, e -> myChest2.setVisible(false)));
		// frameTime = frameTime.add(frameGap);
		// frames.add(new KeyFrame(frameTime, e -> saveCoin.setVisible(false)));

		timeLineClose.setCycleCount(1);
		timeLineClose.play();
	}

}