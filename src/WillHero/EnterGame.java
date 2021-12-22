package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EnterGame implements Initializable {
	
	private Game myGame;
	@FXML
	private ImageView redOrc1;
	@FXML
	private ImageView redOrc2;
	@FXML
	private ImageView greenOrc1;
	@FXML
	private ImageView greenOrc2;
	@FXML
	private ImageView submitButton;
	@FXML
	private TextField textName;

	private String name;

	public void hover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/dark_submit.png").toURI().toString());
		submitButton.setImage(image);
	}

	public void unhover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/submit.png").toURI().toString());
		submitButton.setImage(image);
	}

	public void startGame(MouseEvent event) throws IOException {
		name = textName.getText();		
		myGame = new Game(name);
		Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setUserData(myGame);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void jumpOrc(ImageView orc, int flag) {

		TranslateTransition translate = new TranslateTransition();
		translate.setNode(orc);
		translate.setDuration(Duration.millis(750));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByY(-60 * flag);
		translate.setAutoReverse(true);
		ScaleTransition scale = new ScaleTransition();
		scale.setNode(orc);
		scale.setDuration(Duration.millis(750));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(-0.1 * flag);
		scale.setByY(0.1 * flag);
		scale.setAutoReverse(true);
		translate.play();
		scale.play();
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		jumpOrc(greenOrc1, 1);
		jumpOrc(greenOrc2, 1);
		jumpOrc(redOrc1, -1);
		jumpOrc(redOrc2, -1);

	}

}
