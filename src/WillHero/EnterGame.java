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
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.util.Duration;

public class EnterGame implements Initializable {

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
		Image image = new Image(getClass().getResource("/assets/dark_exit_button.png").toURI().toString());
		submitButton.setImage(image);
	}

	public void unhover(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/exit_button.png").toURI().toString());
		submitButton.setImage(image);
	}
	
	public void startGame(MouseEvent event) throws IOException {
		name = textName.getText();
		Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}
	
	public void jumpOrc(ImageView orc,int delay) {
		
		TranslateTransition translate = new TranslateTransition();
		translate.setDelay(Duration.millis(delay));
		translate.setNode(orc);
		translate.setDuration(Duration.millis(750));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByY(-60);
		translate.setAutoReverse(true);
		ScaleTransition scale = new ScaleTransition();
		scale.setDelay(Duration.millis(delay));
		scale.setNode(orc);
		scale.setDuration(Duration.millis(750));
		scale.setCycleCount(TranslateTransition.INDEFINITE);
		scale.setInterpolator(Interpolator.LINEAR);
		scale.setByX(-0.1);
		scale.setByY(0.1);
		scale.setAutoReverse(true);
		translate.play();
		scale.play();
	}
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		jumpOrc(greenOrc1,0);
		jumpOrc(greenOrc2,0);
		jumpOrc(redOrc1,750);
		jumpOrc(redOrc2,750);
		
		
	}

}
