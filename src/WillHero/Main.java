package WillHero;
	
import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import javafx.animation.Interpolator;
import javafx.animation.ScaleTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.animation.TranslateTransition;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.image.ImageView;
import javafx.scene.transform.Rotate;
import javafx.util.Duration;

public class Main implements Initializable { 
	@FXML
	private ImageView myImage; 
	@FXML
	private ImageView myOrc; 
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  TranslateTransition translate = new TranslateTransition();
		  translate.setNode(myImage);
		  translate.setDuration(Duration.millis(600));
		  translate.setCycleCount(TranslateTransition.INDEFINITE);
		  translate.setByY(-75);
		  translate.setAutoReverse(true);
		  ScaleTransition scale = new ScaleTransition();
		  scale.setNode(myImage);
		  scale.setDuration(Duration.millis(600));
		  scale.setCycleCount(TranslateTransition.INDEFINITE);
		  scale.setInterpolator(Interpolator.LINEAR);
		  scale.setByX(-0.1);
		  scale.setByY(0.1);
		  scale.setAutoReverse(true);
		
		  TranslateTransition translate1 = new TranslateTransition();
		  translate1.setNode(myOrc);
		  translate1.setDuration(Duration.millis(600));
		  translate1.setCycleCount(TranslateTransition.INDEFINITE);
		  translate1.setByY(-75);
		  translate1.setAutoReverse(true);
		  ScaleTransition scale2 = new ScaleTransition();
		  scale2.setNode(myOrc);
		  scale2.setDuration(Duration.millis(600));
		  scale2.setCycleCount(TranslateTransition.INDEFINITE);
		  scale2.setInterpolator(Interpolator.LINEAR);
		  scale2.setByX(-0.1);
		  scale2.setByY(0.1);
		  scale2.setAutoReverse(true);
		  translate.play();
		  scale.play();
		  translate1.play();
		  scale2.play();
	}
}