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

	private TranslateTransition translate;
	private ScaleTransition scale;

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
		translate.setDuration(Duration.millis(750));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByY(-60);
		translate.setAutoReverse(true);
		scale = new ScaleTransition();
		scale.setNode(myHero);
		scale.setDuration(Duration.millis(750));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(-0.1);
		scale.setByY(0.1);
		scale.setAutoReverse(true);
		translate.play();
		scale.play();

		myHero.translateXProperty().addListener((obs, old, newValue) -> {

			int offset = newValue.intValue();

			if (offset > 100 && offset < 11500 - 100) {
				myPane.setLayoutX(-(offset - 100));
				pauseButton.setX(offset - 100);
			}
		});

	}

	public void move(MouseEvent e) {
		translate.pause();
		scale.pause();
		TranslateTransition translate1 = new TranslateTransition();
		translate1.setNode(myHero);
		translate1.setDuration(Duration.millis(750));
		translate1.setCycleCount(1);
		translate1.setByX(300);
		translate1.setAutoReverse(false);
		translate1.play();
		translate.play();
		scale.play();

	}

}
