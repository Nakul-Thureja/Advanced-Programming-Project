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


public class Main extends Application implements Initializable {
	 
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml")); 
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());

			//***ADD LATER***//Image icon = new Image("C:\\Users\\AKSHAT\\Desktop\\LocalAP\\assets\\hero2.png");
			//***ADD LATER***//primaryStage.getIcons().add(icon);

			primaryStage.setTitle("WILL HERO");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	} 
	
	@FXML
	private ImageView myHero; 
	@FXML
	private ImageView myPrincess; 
	@FXML
	private ImageView myHeart;
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  TranslateTransition translate = new TranslateTransition();
		  translate.setNode(myHero);
		  translate.setDuration(Duration.millis(600));
		  translate.setCycleCount(TranslateTransition.INDEFINITE);
		  translate.setByY(-75);
		  translate.setAutoReverse(true);
		  ScaleTransition scale = new ScaleTransition();
		  scale.setNode(myHero);
		  scale.setDuration(Duration.millis(600));
		  scale.setCycleCount(TranslateTransition.INDEFINITE);
		  scale.setInterpolator(Interpolator.LINEAR);
		  scale.setByX(-0.1);
		  scale.setByY(0.1);
		  scale.setAutoReverse(true);
		
		  TranslateTransition translate1 = new TranslateTransition();
		  translate1.setNode(myPrincess);
		  translate1.setDuration(Duration.millis(750));
		  translate1.setCycleCount(TranslateTransition.INDEFINITE);
		  translate1.setByY(-60);
		  translate1.setAutoReverse(true);
		  ScaleTransition scale2 = new ScaleTransition();
		  scale2.setNode(myPrincess);
		  scale2.setDuration(Duration.millis(750));
		  scale2.setCycleCount(TranslateTransition.INDEFINITE);
		  scale2.setInterpolator(Interpolator.LINEAR);
		  scale2.setByX(-0.1);
		  scale2.setByY(0.1);
		  scale2.setAutoReverse(true);
		  
		  
		  ScaleTransition scale3 = new ScaleTransition();
		  scale3.setNode(myHeart);
		  scale3.setDuration(Duration.millis(800));
		  scale3.setCycleCount(ScaleTransition.INDEFINITE);
		  scale3.setInterpolator(Interpolator.LINEAR);
		  scale3.setByX(0.3);
		  scale3.setByY(0.3);
		  scale3.setAutoReverse(true);
		  
		  
		  translate.play();
		  scale.play();
		  translate1.play();
		  scale2.play();
		  scale3.play();
		  
	}
}