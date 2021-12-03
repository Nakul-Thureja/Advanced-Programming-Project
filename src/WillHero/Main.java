package WillHero;
	
import java.io.IOException;
import java.net.URISyntaxException;
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
import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;
import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
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
	
	
	@FXML
	private ImageView myHero; 
	@FXML
	private ImageView myPrincess; 
	@FXML
	private ImageView myHeart;	
	@FXML
	private AnchorPane anchorPane;
	@FXML
	private ImageView newButton;
	@FXML
	private ImageView exitButton;
	@FXML
	private ImageView loadButton;
	
	@Override
	public void start(Stage primaryStage){
		try {
			Parent root = FXMLLoader.load(getClass().getResource("/Main.fxml")); 
			Scene scene = new Scene(root);
			//scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			Image icon = new Image(getClass().getResource("/assets/hero2.png").toURI().toString());
			primaryStage.getIcons().add(icon);
			
			primaryStage.setTitle("WILL HERO");
			primaryStage.setScene(scene);
			primaryStage.setResizable(false);
			primaryStage.show();
			primaryStage.setOnCloseRequest(event -> {
				event.consume();
				Alert alert = new Alert(AlertType.CONFIRMATION);
				alert.setTitle("Exit");
				alert.setHeaderText("You're about to Exit!");
				if (alert.showAndWait().get() == ButtonType.OK){
					primaryStage.close();
				} 	
			});
		} catch(Exception e) {
			e.printStackTrace();
		}
	}
	
	public void logout(MouseEvent e){	
		Alert alert = new Alert(AlertType.CONFIRMATION);
		alert.setTitle("Exit");
		alert.setHeaderText("You're about to Exit!");
		//alert.setContentText("Do you want to save before exiting?");
		Stage mystage = (Stage)anchorPane.getScene().getWindow();
		if (alert.showAndWait().get() == ButtonType.OK){
			mystage.close();
		} 
	}
	
	public void newGame(MouseEvent event) throws IOException {
		  Parent root = FXMLLoader.load(getClass().getResource("/NewGame.fxml"));
		  Stage stage = (Stage)((Node)event.getSource()).getScene().getWindow();
		  Scene scene = new Scene(root);
		  stage.setScene(scene);
		  stage.show();
	}
	
	public void hover1(MouseEvent event) throws URISyntaxException {
        	Image image = new Image(getClass().getResource("/assets/dark_new_gamebutton.png").toURI().toString());
			newButton.setImage(image); 
	}
	
	public void unhover1(MouseEvent event) throws URISyntaxException {
		Image image = new Image(getClass().getResource("/assets/new_game_button.png").toURI().toString());
		newButton.setImage(image);
	}
	
	public void hover2(MouseEvent event) throws URISyntaxException {
    	Image image = new Image(getClass().getResource("/assets/dark_exit_button.png").toURI().toString());
		exitButton.setImage(image); 
}

	public void unhover2(MouseEvent event) throws URISyntaxException {
	Image image = new Image(getClass().getResource("/assets/exit_button.png").toURI().toString());
	exitButton.setImage(image);
}
	public void hover3(MouseEvent event) throws URISyntaxException {
    	Image image = new Image(getClass().getResource("/assets/dark_load_button.png").toURI().toString());
		loadButton.setImage(image); 
}

	public void unhover3(MouseEvent event) throws URISyntaxException {
	Image image = new Image(getClass().getResource("/assets/load_button.png").toURI().toString());
		loadButton.setImage(image);
}
	public static void main(String[] args) {
		launch(args);
	} 
	
	
	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		  TranslateTransition translate = new TranslateTransition();
		  translate.setNode(myHero);
		  translate.setDuration(Duration.millis(750));
		  translate.setCycleCount(TranslateTransition.INDEFINITE);
		  translate.setByY(-60);
		  translate.setAutoReverse(true);
		  ScaleTransition scale = new ScaleTransition();
		  scale.setNode(myHero);
		  scale.setDuration(Duration.millis(750));
		  scale.setCycleCount(TranslateTransition.INDEFINITE);
		  scale.setInterpolator(Interpolator.LINEAR);
		  scale.setByX(-0.1);
		  scale.setByY(0.1);
		  scale.setAutoReverse(true);
		
		  TranslateTransition translate1 = new TranslateTransition();
		  translate1.setNode(myPrincess);
		  translate1.setDuration(Duration.millis(750));
		  translate1.setCycleCount(TranslateTransition.INDEFINITE);
		  translate1.setByY(-45);
		  translate1.setAutoReverse(true);
		  ScaleTransition scale2 = new ScaleTransition();
		  scale2.setNode(myPrincess);
		  scale2.setDuration(Duration.millis(750));
		  scale2.setCycleCount(ScaleTransition.INDEFINITE);
		  scale2.setInterpolator(Interpolator.LINEAR);
		  scale2.setByX(-0.1);
		  scale2.setByY(0.1);
		  scale2.setAutoReverse(true);
		  
		  
		  ScaleTransition scale3 = new ScaleTransition();
		  scale3.setNode(myHeart);
		  scale3.setDuration(Duration.millis(800));
		  scale3.setCycleCount(ScaleTransition.INDEFINITE);
		  scale3.setInterpolator(Interpolator.LINEAR);
		  scale3.setByX(-0.3);
		  scale3.setByY(-0.3);
		  scale3.setAutoReverse(true);
		  
		  
		  translate.play();
		  scale.play();
		  translate1.play();
		  scale2.play();
		  scale3.play();
		  
	}
}