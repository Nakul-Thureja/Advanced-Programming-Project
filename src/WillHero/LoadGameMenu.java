package WillHero;

import java.io.EOFException;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
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
	private static GameSlots Slot; 
	
	public static void deserialize() throws IOException, ClassNotFoundException {
		ObjectInputStream in = null;
		try {
			in = new ObjectInputStream (new FileInputStream("savedgames.txt"));
			Slot = (GameSlots) in.readObject();
			GameSlots.setInstance(Slot);
		}catch(EOFException e) {
			return;
		}
		finally {
			if(in!=null) {
				in.close();
			}
		}
	}
	
	public void goHome(MouseEvent e) throws IOException, ClassNotFoundException {
		Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml"));
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void newGame(MouseEvent event,Game game) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  stage.setUserData(game);
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}

	public void scale(MouseEvent e, int i) throws IOException {
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
						if(i == 1) {newGame(e,Slot.getSlot1());}
						if(i == 2) {newGame(e,Slot.getSlot2());}
						if(i == 3) {newGame(e,Slot.getSlot3());}
						if(i == 4) {newGame(e,Slot.getSlot4());}

					} catch (IOException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
				}
			});
	}
	
	public void translate(MouseEvent e, int i) throws IOException {
		
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
					scale(e, i);
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
	}
	
	public void slot1_click(MouseEvent e) throws IOException, ClassNotFoundException {
		deserialize();
		Slot = GameSlots.getInstance();
		if(Slot.getSlot1() == null) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Game Loader");
			alert1.setHeaderText("No Game is saved in Slot1");
			alert1.showAndWait();
			return;
		}
		//NewGame.setCurrGame(Slot.getSlot1());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Loader");
		alert.setHeaderText("Game Loaded Successfully");
		alert.showAndWait();
		timeLineClose.stop();
		chestOPEN();
		translate(e,1);
	}

	public void slot2_click(MouseEvent e) throws IOException, ClassNotFoundException {
		deserialize();
		Slot = GameSlots.getInstance();
		if(Slot.getSlot2() == null) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Game Loader");
			alert1.setHeaderText("No Game is saved in Slot2");
			alert1.showAndWait();
			return;
		}
		//NewGame.setCurrGame(Slot.getSlot2());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Loader");
		alert.setHeaderText("Game Loaded Successfully");
		alert.showAndWait();
		timeLineClose.stop();
		chestOPEN();
		translate(e,2);
	}

	public void slot3_click(MouseEvent e) throws IOException, ClassNotFoundException {
		deserialize();
		Slot = GameSlots.getInstance();
		if(Slot.getSlot3() == null) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Game Loader");
			alert1.setHeaderText("No Game is saved in Slot3");
			alert1.showAndWait();
			return;
		}
		//NewGame.setCurrGame(Slot.getSlot3());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Loader");
		alert.setHeaderText("Game Loaded Successfully");
		alert.showAndWait();
		translate(e,3);
	}

	public void slot4_click(MouseEvent e) throws IOException, ClassNotFoundException {
		deserialize();
		Slot = GameSlots.getInstance();
		if(Slot.getSlot4() == null) {
			Alert alert1 = new Alert(AlertType.INFORMATION);
			alert1.setTitle("Game Loader");
			alert1.setHeaderText("No Game is saved in Slot4");
			alert1.showAndWait();
			return;
		}
		//NewGame.setCurrGame(Slot.getSlot4());
		Alert alert = new Alert(AlertType.INFORMATION);
		alert.setTitle("Game Loader");
		alert.setHeaderText("Game Loaded Successfully");
		alert.showAndWait();
		translate(e,4);
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
