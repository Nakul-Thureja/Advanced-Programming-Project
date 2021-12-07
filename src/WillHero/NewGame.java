package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
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
//import javafx.animation.TranslateTransition;
//import javafx.fxml.FXML;
//import javafx.fxml.Initializable;
//import javafx.scene.image.ImageView;
//import javafx.scene.transform.Rotate;
//import javafx.util.Duration;

public class NewGame implements Initializable {

	@FXML
	private ImageView pauseButton;

	@FXML
	private ImageView myHero;

	@FXML
	private AnchorPane myPane;

	@FXML
	private AnchorPane gamePane;
	@FXML
	private ImageView hammerSlot;
	@FXML
	private ImageView swordSlot;
	@FXML
	private ImageView redORC;
	@FXML
	private ImageView greenORC;
	@FXML
	private ImageView coinDisplay;
	@FXML
	private ImageView handWeapon;

	private TranslateTransition translate;
	private ScaleTransition scale;
	private TranslateTransition wtranslate;

	public void pauseHandler(MouseEvent event) throws IOException {
		Parent root = FXMLLoader.load(getClass().getResource("/Pause.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void hover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_pause_button.png").toURI().toString());
		pauseButton.setImage(image);
	}

	public void unhover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/pause_button.png").toURI().toString());
		pauseButton.setImage(image);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		translate = new TranslateTransition();
		translate.setNode(myHero);
		translate.setDuration(Duration.millis(600));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByY(-60);
		translate.setAutoReverse(true);
		scale = new ScaleTransition();
		scale.setNode(myHero);
		scale.setDuration(Duration.millis(600));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(-0.1);
		scale.setByY(0.1);
		scale.setAutoReverse(true);
		wtranslate = new TranslateTransition();
		wtranslate.setNode(handWeapon);
		wtranslate.setDuration(Duration.millis(600));
		wtranslate.setCycleCount(TranslateTransition.INDEFINITE);
		wtranslate.setByY(-60);
		wtranslate.setAutoReverse(true);
		wtranslate.play();
		translate.play();
		scale.play();

		myHero.translateXProperty().addListener((obs, old, newValue) -> {

			int offset = newValue.intValue();

			if (offset > 100 && offset < 11500 - 100) {
				myPane.setLayoutX(-(offset - 100));
				pauseButton.setX(offset - 100);
				swordSlot.setX(offset-100);
				hammerSlot.setX(offset-100);
				coinDisplay.setX(offset-100);
			}
		});

	}

	public void move(MouseEvent e) {
		translate.pause();
		scale.pause();
		wtranslate.pause();
	
		TranslateTransition translate1 = new TranslateTransition();
		translate1.setNode(myHero);
		translate1.setDuration(Duration.millis(450));
		translate1.setCycleCount(1);
		translate1.setByX(300);
		translate1.setAutoReverse(false);
		TranslateTransition wtranslate1 = new TranslateTransition();
		wtranslate1.setNode(handWeapon);
		wtranslate1.setDuration(Duration.millis(450));
		wtranslate1.setCycleCount(1);
		wtranslate1.setByX(300);
		wtranslate1.setAutoReverse(false);
		wtranslate1.play();
		translate1.play();
		translate1.setOnFinished(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent arg0) {
				translate.play();
				scale.play();
				wtranslate.play();
			}
		});
		//new PauseTransition(Duration.millis(5000));
		//translate.play();
		//scale.play();
	}

}
