package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.ResourceBundle;

import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.PauseTransition;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
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
import javafx.scene.control.Button;
//import javafx.scene.control.Button;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
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

	private Hero hero;
	private Timeline empty;
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
//	@FXML
//	private ImageView redORC;
//	@FXML
//	private ImageView greenORC;
//	@FXML
//	private ImageView bossORC;
	@FXML
	private ImageView coinDisplay;
	@FXML
	private ImageView handWeapon;
	@FXML
	private ImageView handWeapon2;
	@FXML
	private ImageView clickable;
//	@FXML
//	private ImageView OrcWeapon;
	@FXML
	private Text myScore;
	@FXML
	private Button defeatButton;
	@FXML
	private ImageView deathpanel;
	@FXML
	private ImageView collider1;
	@FXML
	private ImageView collider2;
	@FXML
	private ImageView collider3;
	@FXML
	private ImageView collider4;
	@FXML
	private ImageView collider5;
	@FXML
	private ImageView collider6;
	@FXML
	private ImageView collider7;
	@FXML
	private ImageView collider8;
	@FXML
	private ImageView collider9;
	@FXML
	private ImageView collider10;
	@FXML
	private ImageView collider11;
	@FXML
	private ImageView collider12;
	@FXML
	private ImageView collider13;
	@FXML
	private ImageView collider14;
	@FXML
	private ImageView collider15;
	@FXML
	private Text playerName;
	@FXML
	private ImageView beginButton;
	@FXML
	private Text coinCounter;
	
	private Game currGame;
	private Score score;
	private TranslateTransition translate;
	private ScaleTransition scale;
	private TranslateTransition wtranslate;
	private TranslateTransition w2translate;
	private TranslateTransition translate1 = new TranslateTransition();
	private TranslateTransition wtranslate1 = new TranslateTransition();
	private TranslateTransition w2translate1 = new TranslateTransition();
	private ArrayList<Platform> platformList;
	private ArrayList<ImageView> colliderList;
	private GameSlots gameSlot;
	
//	public static void setCurrGame(Game game) {
//		currGame = game;
//		return;
//	}
	
	public void letsBegin(MouseEvent e) {
			Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
			currGame = (Game) stage.getUserData();
			if(currGame.isLoad()) {
				loadGame();
		}
			else {
				initGame();
			}
	}
	
	public void loadGame() {
			ArrayList<Position> misc = currGame.getmisc();
			myPane.setLayoutX(misc.get(0).getX());
			clickable.setX(misc.get(1).getX());
			pauseButton.setX(misc.get(2).getX());
			swordSlot.setX(misc.get(3).getX());
			hammerSlot.setX(misc.get(4).getX());
			coinDisplay.setX(misc.get(5).getX());
			myScore.setX(misc.get(6).getX());
			playerName.setX(misc.get(7).getX());
			coinCounter.setX(misc.get(8).getX());
			playerName.setText(currGame.getMyPlayer().getName());
			System.out.println(currGame.getmyHeroX());
			//<<PROBLEM>>
			//------------------
			//--------------
			//---------------
			myHero.setLayoutX(currGame.getmyHeroX());
			//---------------
			//---------------
			//----------------
			//myHero.setY(currGame.getmyHeroY());
			myScore.setText(Integer.toString(currGame.getScore()));
			beginButton.setVisible(false);
			
		}
	
	public void initGame(){
		beginButton.setVisible(false);
		playerName.setText(currGame.getMyPlayer().getName());
		currGame.setFlag(true);
		Weapon Sword = new Weapon(0,0);
		Weapon Hammer = new Weapon(0,0);
		ArrayList<Weapon> Weapons = new ArrayList<>();
		Weapons.add(Sword);
		Weapons.add(Hammer);
		currGame.setMyWeapons(Weapons);
		Helmet helmet = new Helmet(0,0,Weapons);
		currGame.setHelmet(helmet);
		Hero hero = new Hero(0.0, 0.0, helmet);
		currGame.setHero(hero);
		Score score = new Score(myScore.getLayoutX(),myScore.getLayoutY(),0);
		currGame.setMyScore(score);
	}

	public void heroDefeat() throws IOException {
		empty.stop();
		currGame.setFlag(false);
		Parent root = FXMLLoader.load(getClass().getResource("/HeroDies.fxml"));
		// Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Stage stage = (Stage) myPane.getScene().getWindow();
		stage.setUserData(currGame);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void pauseHandler(MouseEvent event) throws IOException {
		empty.stop();
		Parent root = FXMLLoader.load(getClass().getResource("/Pause.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setUserData(currGame);
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

	public void swordSelect(MouseEvent e) throws URISyntaxException {
		translate1.pause();
		wtranslate1.pause();
		w2translate1.pause();
		Image image1 = new Image(getClass().getResource("/assets/unlocked_hammer.png").toURI().toString());
		hammerSlot.setImage(image1);
		Image image = new Image(getClass().getResource("/assets/selected_sword.png").toURI().toString());
		swordSlot.setImage(image);
		handWeapon2.setVisible(false);
		handWeapon.setVisible(true);

	}

	public void hammerSelect(MouseEvent e) throws URISyntaxException {
		translate1.pause();
		wtranslate1.pause();
		w2translate1.pause();
		Image image1 = new Image(getClass().getResource("/assets/unlocked_sword.png").toURI().toString());
		swordSlot.setImage(image1);
		Image image = new Image(getClass().getResource("/assets/selected_hammer.png").toURI().toString());
		hammerSlot.setImage(image);
		handWeapon.setVisible(false);
		handWeapon2.setVisible(true);
	}

	@Override
	public void initialize(URL arg0, ResourceBundle arg1) {
		// TODO Auto-generated method stub
		score = new Score(0, 0, 0);
		empty = new Timeline();
		empty.setCycleCount(Animation.INDEFINITE);
		KeyFrame gravity_frame = new KeyFrame(Duration.millis(18), e -> {
			if (hero.getDeath() == 1) {
				try {
					heroDefeat();
				} catch (IOException e1) {
					e1.printStackTrace();
				}
			}
		});
		empty.getKeyFrames().add(gravity_frame);
		empty.play();
		handWeapon.setVisible(false);
		handWeapon2.setVisible(false);
		hero = new Hero(0, 0, null);
		platformList = new ArrayList<>();
		colliderList = new ArrayList<>();
		colliderList.add(collider1);colliderList.add(collider2);colliderList.add(collider3);colliderList.add(collider4);colliderList.add(collider5);colliderList.add(collider6);
		colliderList.add(collider7);colliderList.add(collider8);colliderList.add(collider9);colliderList.add(collider10);colliderList.add(collider11);colliderList.add(collider12);
		colliderList.add(collider13);colliderList.add(collider14);colliderList.add(collider15);
		Platform platform;
		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
		platform = new Platform(0,0,0);platformList.add(platform);
		hero.givePlatform(platformList);
		hero.beginGravity(colliderList,myHero,deathpanel);
		wtranslate = new TranslateTransition();
		wtranslate.setNode(handWeapon);
		wtranslate.setDuration(Duration.millis(600));
		wtranslate.setCycleCount(TranslateTransition.INDEFINITE);
		wtranslate.setByY(-60);
		wtranslate.setAutoReverse(true);
		w2translate = new TranslateTransition();
		w2translate.setNode(handWeapon2);
		w2translate.setDuration(Duration.millis(600));
		w2translate.setCycleCount(TranslateTransition.INDEFINITE);
		w2translate.setByY(-60);
		w2translate.setAutoReverse(true);
		w2translate.play();
		wtranslate.play();
		myHero.translateXProperty().addListener((obs, old, newValue) -> {

			int offset = newValue.intValue();

			if (offset > 100 && offset < 11500 - 100) {
				currGame.getmisc().clear();
				myPane.setLayoutX(-(offset - 100));
				currGame.getmisc().add(new Position(myPane.getLayoutX(),myPane.getLayoutY()));
				clickable.setX(offset - 100);
				currGame.getmisc().add(new Position(clickable.getX(),clickable.getLayoutY()));
				pauseButton.setX(offset - 100);
				currGame.getmisc().add(new Position(pauseButton.getX(),pauseButton.getLayoutY()));
				swordSlot.setX(offset - 100);
				currGame.getmisc().add(new Position(swordSlot.getX(),swordSlot.getLayoutY()));
				hammerSlot.setX(offset - 100);
				currGame.getmisc().add(new Position(hammerSlot.getX(),hammerSlot.getLayoutY()));
				coinDisplay.setX(offset - 100);
				currGame.getmisc().add(new Position(coinDisplay.getX(),coinDisplay.getLayoutY()));
				myScore.setX(offset - 100);
				currGame.getmisc().add(new Position(myScore.getX(),myScore.getLayoutY()));
				playerName.setX(offset-100);
				currGame.getmisc().add(new Position(playerName.getX(),playerName.getLayoutY()));
				coinCounter.setX(offset-100);
				currGame.getmisc().add(new Position(coinCounter.getX(),coinCounter.getLayoutY()));

			}
		});

	}

	public void auto_jump(ImageView Node, int height, boolean ifscale) {

		TranslateTransition translate = new TranslateTransition();
		translate.setNode(Node);
		translate.setDuration(Duration.millis(750));
		translate.setCycleCount(TranslateTransition.INDEFINITE);
		translate.setByY(-height);
		translate.setAutoReverse(true);
		if (ifscale) {
			ScaleTransition scale = new ScaleTransition();
			scale.setNode(Node);
			scale.setDuration(Duration.millis(750));
			scale.setCycleCount(TranslateTransition.INDEFINITE);
			scale.setInterpolator(Interpolator.LINEAR);
			scale.setByX(-0.1);
			scale.setByY(0.1);
			scale.setAutoReverse(true);
			scale.play();
		}
		translate.play();

	}

	public void move(MouseEvent e) throws IOException {
		hero.moveForward(myHero);
		//System.out.println(myHero.getLayoutX());
		currGame.scoreplus1();
		myScore.setText(Integer.toString(currGame.getScore()));

	}

}
