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
	
	
	public void initGame(MouseEvent event){
		beginButton.setVisible(false);
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		currGame = (Game) stage.getUserData();
		playerName.setText(currGame.getMyPlayer().getName());
		Weapon Sword = new Weapon(0,0);
		Weapon Hammer = new Weapon(0,0);
		ArrayList<Weapon> Weapons = new ArrayList<>();
		Weapons.add(Sword);
		Weapons.add(Hammer);
		currGame.setMyWeapons(Weapons);
		Helmet helmet = new Helmet(0,0,Weapons);
		currGame.setHelmet(helmet);
		Hero hero = new Hero(0, 0, helmet);
		currGame.setHero(hero);
		Score score = new Score(0,0,0);
		currGame.setMyScore(score);


	}

	public void heroDefeat() throws IOException {
		empty.stop();
		Parent root = FXMLLoader.load(getClass().getResource("/HeroDies.fxml"));
		// Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		Stage stage = (Stage) myPane.getScene().getWindow();
		stage.setUserData(currGame);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

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
					// TODO Auto-generated catch block
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
		//platform.giveCollider(colliderList);
		hero.givePlatform(platformList);
		hero.beginGravity(colliderList,myHero,deathpanel);

//		Platform platform = new Platform(0, 0, 0, platform1);
//		platformList.add(platform);
//		/Platform platform02 = new Platform(0, 0, 0, platform2);
//		Platform platform03 = new Platform(0, 0, 0, platform3);
//		Platform platform04 = new Platform(0, 0, 0, platform4);
//		Platform platform05 = new Platform(0, 0, 0, platform5);
//		Platform platform06 = new Platform(0, 0, 0, platform6);
//		Platform platform07 = new Platform(0, 0, 0, platform7);
//		Platform platform08 = new Platform(0, 0, 0, platform8);
//		Platform platform09 = new Platform(0, 0, 0, platform9);
//		Platform platform010 = new Platform(0, 0, 0, platform10);
//		Platform platform011 = new Platform(0, 0, 0, platform11);
//		Platform platform012 = new Platform(0, 0, 0, platform12);
//		Platform platform013 = new Platform(0, 0, 0, platform13);
//		Platform platform014 = new Platform(0, 0, 0, platform14);
//		Platform platform015 = new Platform(0, 0, 0, platform15);
//		Platform platform016 = new Platform(0, 0, 0, platform16);
//		Platform platform017 = new Platform(0, 0, 0, platform17);
//		Platform platform018 = new Platform(0, 0, 0, platform18);
//		Platform platform019 = new Platform(0, 0, 0, platform19);
//		Platform platform020 = new Platform(0, 0, 0, platform20);
//		Platform platform021 = new Platform(0, 0, 0, platform21);
//		Platform platform022 = new Platform(0, 0, 0, platform22);
//		Platform platform023 = new Platform(0, 0, 0, platform23);
//		Platform platform024 = new Platform(0, 0, 0, platform24);
//		Platform platform025 = new Platform(0, 0, 0, platform25);
//		Platform platform026 = new Platform(0, 0, 0, platform26);
//		Platform platform027 = new Platform(0, 0, 0, platform27);
//		Platform platform028 = new Platform(0, 0, 0, platform28);
//		Platform platform029 = new Platform(0, 0, 0, platform29);
//		Platform platform030 = new Platform(0, 0, 0, platform30);
//		Platform platform031 = new Platform(0, 0, 0, platform31);
//		Platform platform032 = new Platform(0, 0, 0, platform32);
//		Platform platform033 = new Platform(0, 0, 0, platform33);
//		Platform platform034 = new Platform(0, 0, 0, platform34);
//		Platform platform035 = new Platform(0, 0, 0, platform35);
//		hero.givePlatform(platform01);
//		hero.givePlatform(platform02);
//		hero.givePlatform(platform03);
//		hero.givePlatform(platform04);
//		hero.givePlatform(platform05);
//		hero.givePlatform(platform06);
//		hero.givePlatform(platform07);
//		hero.givePlatform(platform08);
//		hero.givePlatform(platform09);
//		hero.givePlatform(platform010);
//		hero.givePlatform(platform011);
//		hero.givePlatform(platform012);
//		hero.givePlatform(platform013);
//		hero.givePlatform(platform014);
//		hero.givePlatform(platform015);
//		hero.givePlatform(platform016);
//		hero.givePlatform(platform017);
//		hero.givePlatform(platform018);
//		hero.givePlatform(platform019);
//		hero.givePlatform(platform020);
//		hero.givePlatform(platform021);
//		hero.givePlatform(platform022);
//		hero.givePlatform(platform023);
//		hero.givePlatform(platform024);
//		hero.givePlatform(platform025);
//		hero.givePlatform(platform026);
//		hero.givePlatform(platform027);
//		hero.givePlatform(platform028);
//		hero.givePlatform(platform029);
//		hero.givePlatform(platform030);
//		hero.givePlatform(platform031);
//		hero.givePlatform(platform032);
//		hero.givePlatform(platform033);
//		hero.givePlatform(platform034);
//		hero.givePlatform(platform035);
//		translate = new TranslateTransition();
//		translate.setNode(myHero);
//		translate.setDuration(Duration.millis(600));
//		translate.setCycleCount(TranslateTransition.INDEFINITE);
//		translate.setByY(-60);
//		translate.setAutoReverse(true);
//		scale = new ScaleTransition();
//		scale.setNode(myHero);
//		scale.setDuration(Duration.millis(600));
//		scale.setCycleCount(TranslateTransition.INDEFINITE);
//		scale.setInterpolator(Interpolator.LINEAR);
//		scale.setByX(-0.1);
//		scale.setByY(0.1);
//		scale.setAutoReverse(true);
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
		// translate.play();
		// scale.play();
		myHero.translateXProperty().addListener((obs, old, newValue) -> {

			int offset = newValue.intValue();

			if (offset > 100 && offset < 11500 - 100) {
				myPane.setLayoutX(-(offset - 100));
				clickable.setX(offset - 100);
				pauseButton.setX(offset - 100);
				swordSlot.setX(offset - 100);
				hammerSlot.setX(offset - 100);
				coinDisplay.setX(offset - 100);
				myScore.setX(offset - 100);
				playerName.setX(offset-100);
				coinCounter.setX(offset-100);
			}
		});
//		auto_jump(redORC,60,true);
//		auto_jump(greenORC,50,true);
//		auto_jump(bossORC,85,true);
//		auto_jump(OrcWeapon,60,false);

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
		
		// translate.pause();
		// scale.pause();
//		wtranslate.pause();
//		w2translate.pause();
//	
//		translate1 = new TranslateTransition();
//		translate1.setNode(myHero);
//		translate1.setDuration(Duration.millis(450));
//		translate1.setCycleCount(1);
//		translate1.setByX(300);
//		translate1.setAutoReverse(false);
//		wtranslate1 = new TranslateTransition();
//		wtranslate1.setNode(handWeapon);
//		wtranslate1.setDuration(Duration.millis(450));
//		wtranslate1.setCycleCount(1);
//		wtranslate1.setByX(300);
//		wtranslate1.setAutoReverse(false);
//		w2translate1 = new TranslateTransition();
//		w2translate1.setNode(handWeapon2);
//		w2translate1.setDuration(Duration.millis(450));
//		w2translate1.setCycleCount(1);
//		w2translate1.setByX(300);
//		w2translate1.setAutoReverse(false);
//		w2translate1.play();
//		wtranslate1.play();
//		translate1.play();
//		
//		translate1.setOnFinished(new EventHandler<ActionEvent>() {
//			
//			@Override
//			public void handle(ActionEvent arg0) {
//				//translate.play();
//				//scale.play();
//				wtranslate.play();
//				w2translate.play();
//			}
//		});
		currGame.getMyScore().scoreplus1();
		;
		myScore.setText(Integer.toString(currGame.getMyScore().getScore()));

//		if(score.getScore() == 15) {
//			Parent root = FXMLLoader.load(getClass().getResource("/HeroWins.fxml"));
//			Stage stage = (Stage)((Node)e.getSource()).getScene().getWindow();
//			Scene scene = new Scene(root);
//			stage.setScene(scene);
//			stage.show();
//		}
		// new PauseTransition(Duration.millis(5000));
		// translate.play();
		// scale.play();

	}

}
