package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;
import java.net.URL;
import java.util.ArrayList;
import java.util.EventObject;
import java.util.HashMap;
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

	//private Hero hero;
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
	private ImageView collider16;
	@FXML
	private ImageView collider17;
	@FXML
	private ImageView collider18;
	@FXML
	private ImageView collider19;
	@FXML
	private ImageView collider20;
	@FXML
	private ImageView collider21;
	@FXML
	private ImageView collider22;
	@FXML
	private ImageView collider23;
	@FXML
	private ImageView collider24;
	@FXML
	private ImageView collider25;
	@FXML
	private ImageView collider26;
	@FXML
	private ImageView collider27;
	@FXML
	private ImageView collider28;
	@FXML
	private ImageView collider29;
	@FXML
	private ImageView collider30;
	@FXML
	private ImageView collider31;
	@FXML
	private ImageView collider32;
	@FXML
	private ImageView collider33;
	@FXML
	private ImageView collider34;
	@FXML
	private ImageView collider35;
	@FXML
	private ImageView collider36;
	@FXML
	private ImageView collider37;
	@FXML
	private ImageView collider38;
	@FXML
	private ImageView collider39;
	@FXML
	private ImageView collider40;
	@FXML
	private ImageView collider41;
	@FXML
	private ImageView collider42;
	@FXML
	private ImageView collider43;
	@FXML
	private ImageView collider44;
	@FXML
	private ImageView collider45;
	@FXML
	private ImageView coin1;
	@FXML
	private ImageView coin2;
	@FXML
	private ImageView coin3;
	@FXML
	private ImageView coin4;
	@FXML
	private ImageView coin5;
	@FXML
	private ImageView coin6;
	@FXML
	private ImageView coin7;
	@FXML
	private ImageView coin8;
	@FXML
	private ImageView coin9;
	@FXML
	private ImageView coin10;
	@FXML
	private ImageView coin11;
	@FXML
	private ImageView coin12;
	@FXML
	private ImageView coin13;
	@FXML
	private ImageView coin14;
	@FXML
	private ImageView coin15;
	
	@FXML
	private Text playerName;
	@FXML
	private ImageView beginButton;
	@FXML
	private Text coinCounter;
	@FXML
	private AnchorPane heroPane;

	private Game currGame;
	private Score score;
	private TranslateTransition translate;
	private ScaleTransition scale;
	private TranslateTransition wtranslate;
	private TranslateTransition w2translate;
	private TranslateTransition translate1 = new TranslateTransition();
	private TranslateTransition wtranslate1 = new TranslateTransition();
	private TranslateTransition w2translate1 = new TranslateTransition();
//	private ArrayList<Platform> platformList;
//	private ArrayList<ImageView> colliderList;
	private GameSlots gameSlot;
	private HashMap<GameComponents, HashMap<GameComponents,ImageView>> CollisionMap;

//	public static void setCurrGame(Game game) {
//		currGame = game;
//		return;
//	}

	public void letsBegin(MouseEvent e) {
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		currGame = (Game) stage.getUserData();
		if (currGame.isLoad()) {
			loadGame();

		} else {
			initGame();
		}
		currGame.getMyHero().setImage(myHero);
		CollisionMap = new HashMap<>();
		HashMap<GameComponents,ImageView> ImageMap = new HashMap<>();
		
		//CollisionMap.put(new Hero(0, 0, null), null);
		score = new Score(0, 0, 0);
		empty = new Timeline();
		empty.setCycleCount(Animation.INDEFINITE);
		KeyFrame empty_frame = new KeyFrame(Duration.millis(18), e1 -> {
			coinCounter.setText(Integer.toString(currGame.getMyHero().getcurrCoins()));
			if (myHero.getBoundsInParent().intersects(deathpanel.getBoundsInParent())) {
				try {
					heroDefeat();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
		});
		empty.getKeyFrames().add(empty_frame);
		empty.play();
		handWeapon.setVisible(false);
		handWeapon2.setVisible(false);
		Platform platform = new Platform(0,0,0);
		Platform platform2 = new Platform(0,0,0);
		Platform platform3= new Platform(0,0,0);
		Platform platform4 = new Platform(0,0,0);
		Platform platform5 = new Platform(0,0,0);
		Platform platform6 = new Platform(0,0,0);
		Platform platform7 = new Platform(0,0,0);
		Platform platform8 = new Platform(0,0,0);
		Platform platform9 = new Platform(0,0,0);
		Platform platform10 = new Platform(0,0,0);
		Platform platform11= new Platform(0,0,0);
		Platform platform12 = new Platform(0,0,0);
		Platform platform13 = new Platform(0,0,0);
		Platform platform14= new Platform(0,0,0);
		Platform platform15= new Platform(0,0,0);
		Platform platform16 = new Platform(0,0,0);
		Platform platform17= new Platform(0,0,0);
		Platform platform18= new Platform(0,0,0);
		Platform platform19 = new Platform(0,0,0);
		Platform platform20 = new Platform(0,0,0);
		Platform platform21 = new Platform(0,0,0);
		Platform platform22 = new Platform(0,0,0);
		Platform platform23 = new Platform(0,0,0);
		Platform platform24 = new Platform(0,0,0);
		Platform platform25 = new Platform(0,0,0);
		Platform platform26= new Platform(0,0,0);
		Platform platform27 = new Platform(0,0,0);
		Platform platform28 = new Platform(0,0,0);
		Platform platform29= new Platform(0,0,0);
		Platform platform30= new Platform(0,0,0);
		Platform platform31 = new Platform(0,0,0);
		Platform platform32 = new Platform(0,0,0);
		Platform platform33= new Platform(0,0,0);
		Platform platform34 = new Platform(0,0,0);
		Platform platform35 = new Platform(0,0,0);
		Platform platform36 = new Platform(0,0,0);
		Platform platform37 = new Platform(0,0,0);
		Platform platform38 = new Platform(0,0,0);
		Platform platform39 = new Platform(0,0,0);
		Platform platform40 = new Platform(0,0,0);
		Platform platform41= new Platform(0,0,0);
		Platform platform42 = new Platform(0,0,0);
		Platform platform43 = new Platform(0,0,0);
		Platform platform44= new Platform(0,0,0);
		Platform platform45= new Platform(0,0,0);
		Coin gcoin1 = new Coin(0, 0);
		Coin gcoin2 = new Coin(0, 0);
		Coin gcoin3 = new Coin(0, 0);
		Coin gcoin4 = new Coin(0, 0);
		Coin gcoin5 = new Coin(0, 0);
		Coin gcoin6 = new Coin(0, 0);
		Coin gcoin7 = new Coin(0, 0);
		Coin gcoin8 = new Coin(0, 0);
		Coin gcoin9 = new Coin(0, 0);
		Coin gcoin10 = new Coin(0, 0);
		Coin gcoin11 = new Coin(0, 0);
		Coin gcoin12 = new Coin(0, 0);
		Coin gcoin13 = new Coin(0, 0);
		Coin gcoin14 = new Coin(0, 0);
		Coin gcoin15 = new Coin(0, 0);
	//	platformList = new ArrayList<>();
	//	colliderList = new ArrayList<>();
		ImageMap.put(platform, collider1);
		ImageMap.put(platform2, collider2);
		ImageMap.put(platform3, collider3);
		ImageMap.put(platform4, collider4);
		ImageMap.put(platform5, collider5);
		ImageMap.put(platform6, collider6);
		ImageMap.put(platform7, collider7);
		ImageMap.put(platform8, collider8);
		ImageMap.put(platform9, collider9);
		ImageMap.put(platform10, collider10);
		ImageMap.put(platform11, collider11);
		ImageMap.put(platform12, collider12);
		ImageMap.put(platform13, collider13);
		ImageMap.put(platform14, collider14);
		ImageMap.put(platform15, collider15);
		ImageMap.put(platform16, collider16);
		ImageMap.put(platform17, collider17);
		ImageMap.put(platform18, collider18);
		ImageMap.put(platform19, collider19);
		ImageMap.put(platform20, collider20);
		ImageMap.put(platform21, collider21);
		ImageMap.put(platform22, collider22);
		ImageMap.put(platform23, collider23);
		ImageMap.put(platform24, collider24);
		ImageMap.put(platform25, collider25);
		ImageMap.put(platform26, collider26);
		ImageMap.put(platform27, collider27);
		ImageMap.put(platform28, collider28);
		ImageMap.put(platform29, collider29);
		ImageMap.put(platform30, collider30);
		ImageMap.put(platform31, collider31);
		ImageMap.put(platform32, collider32);
		ImageMap.put(platform33, collider33);
		ImageMap.put(platform34, collider34);
		ImageMap.put(platform35, collider35);
		ImageMap.put(platform36, collider36);
		ImageMap.put(platform37, collider37);
		ImageMap.put(platform38, collider38);
		ImageMap.put(platform39, collider39);
		ImageMap.put(platform40, collider40);
		ImageMap.put(platform41, collider41);
		ImageMap.put(platform42, collider42);
		ImageMap.put(platform43, collider43);
		ImageMap.put(platform44, collider44);
		ImageMap.put(platform45, collider45);
		ImageMap.put(gcoin1, coin1);
		ImageMap.put(gcoin2, coin2);
		ImageMap.put(gcoin3, coin3);

		ImageMap.put(gcoin4, coin4);
		ImageMap.put(gcoin5, coin5);
		ImageMap.put(gcoin6, coin6);
		ImageMap.put(gcoin7, coin7);
		ImageMap.put(gcoin8, coin8);
		ImageMap.put(gcoin9, coin9);
		ImageMap.put(gcoin10, coin10);
		ImageMap.put(gcoin11, coin11);
		ImageMap.put(gcoin12, coin12);
		ImageMap.put(gcoin13, coin13);
		ImageMap.put(gcoin14, coin14);
		ImageMap.put(gcoin15, coin15);


//		colliderList.add(collider1);
//		colliderList.add(collider2);
//		colliderList.add(collider3);
//		colliderList.add(collider4);
//		colliderList.add(collider5);
//		colliderList.add(collider6);
//		colliderList.add(collider7);
//		colliderList.add(collider8);
//		colliderList.add(collider9);
//		colliderList.add(collider10);
//		colliderList.add(collider11);
//		colliderList.add(collider12);
//		colliderList.add(collider13);
//		colliderList.add(collider14);
//		colliderList.add(collider15);
		//Platform platform;
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
//		platform = new Platform(0, 0, 0);
//		platformList.add(platform);
		//currGame.getMyHero().givePlatform(platformList);
		CollisionMap.put(new Hero(0,0,null),ImageMap);
		System.out.println(ImageMap.size());
		currGame.beginGame(CollisionMap);
		//currGame.getMyHero().beginGravity(myHero, deathpanel);
//			wtranslate = new TranslateTransition();
//			wtranslate.setNode(handWeapon);
//			wtranslate.setDuration(Duration.millis(600));
//			wtranslate.setCycleCount(TranslateTransition.INDEFINITE);
//			wtranslate.setByY(-60);
//			wtranslate.setAutoReverse(true);
//			w2translate = new TranslateTransition();
//			w2translate.setNode(handWeapon2);
//			w2translate.setDuration(Duration.millis(600));
//			w2translate.setCycleCount(TranslateTransition.INDEFINITE);
//			w2translate.setByY(-60);
//			w2translate.setAutoReverse(true);
//			w2translate.play();
//			wtranslate.play();
		myHero.translateXProperty().addListener((obs, old, newValue) -> {

			int offset = newValue.intValue();
			// System.out.println(myHero.getTranslateX());
			
			if (offset > 100) {// && //offset < 11500 - 100) {
				currGame.getmisc().clear();
				myPane.setLayoutX(-(offset - 100));
				currGame.getmisc().add(new Position(myPane.getLayoutX(), myPane.getLayoutY()));
				clickable.setX(offset - 100);
				currGame.getmisc().add(new Position(clickable.getX(), clickable.getLayoutY()));
				pauseButton.setX(offset - 100);
				currGame.getmisc().add(new Position(pauseButton.getX(), pauseButton.getLayoutY()));
				swordSlot.setX(offset - 100);
				currGame.getmisc().add(new Position(swordSlot.getX(), swordSlot.getLayoutY()));
				hammerSlot.setX(offset - 100);
				currGame.getmisc().add(new Position(hammerSlot.getX(), hammerSlot.getLayoutY()));
				coinDisplay.setX(offset - 100);
				currGame.getmisc().add(new Position(coinDisplay.getX(), coinDisplay.getLayoutY()));
				myScore.setX(offset - 100);
				currGame.getmisc().add(new Position(myScore.getX(), myScore.getLayoutY()));
				playerName.setX(offset - 100);
				currGame.getmisc().add(new Position(playerName.getX(), playerName.getLayoutY()));
				coinCounter.setX(offset - 100);
				currGame.getmisc().add(new Position(coinCounter.getX(), coinCounter.getLayoutY()));
				heroPane.setLayoutX(offset - 100);
				currGame.getmisc().add(new Position(heroPane.getLayoutX(), heroPane.getLayoutY()));
			}
		});

	}

	public void loadGame() {
		ArrayList<Position> misc = currGame.getmisc();

		myPane.setLayoutX(misc.get(0).getX());
		clickable.setX(misc.get(1).getX());
		pauseButton.setX(misc.get(2).getX());
		swordSlot.setX(misc.get(3).getX());
		hammerSlot.setX(misc.get(4).getX());
		// System.out.println(misc.get(4).getX());
		coinDisplay.setX(misc.get(5).getX());
		myScore.setX(misc.get(6).getX());
		playerName.setX(misc.get(7).getX());
		coinCounter.setX(misc.get(8).getX());
		playerName.setText(currGame.getMyPlayer().getName());
		// System.out.println(misc.get(9).getX());
		// <<PROBLEM>>
		// ------------------
		// --------------
		// ---------------
		myHero.setTranslateX(currGame.getmyHeroX() + 92);
		// myHero.setX(misc.get(9).getX());
		// ---------------
		// ---------------
		// ----------------
		// myHero.setY(currGame.getmyHeroY());
		myScore.setText(Integer.toString(currGame.getScore()));
		beginButton.setVisible(false);

	}

	public void initGame() {
		beginButton.setVisible(false);
		playerName.setText(currGame.getMyPlayer().getName());
		currGame.setFlag(true);
		Weapon Sword = new Weapon(0, 0);
		Weapon Hammer = new Weapon(0, 0);
		ArrayList<Weapon> Weapons = new ArrayList<>();
		Weapons.add(Sword);
		Weapons.add(Hammer);
		currGame.setMyWeapons(Weapons);
		Helmet helmet = new Helmet(0, 0, Weapons);
		currGame.setHelmet(helmet);
		Hero hero = new Hero(234.0, 0.0, helmet);
		currGame.setHero(hero);
		Score score = new Score(myScore.getLayoutX(), myScore.getLayoutY(), 0);
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
		currGame.getMyHero().stopALL();
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
		// while(flag == true) ;
//		score = new Score(0, 0, 0);
//		empty = new Timeline();
//		empty.setCycleCount(Animation.INDEFINITE);
//		KeyFrame gravity_frame = new KeyFrame(Duration.millis(18), e -> {
//			if (currGame.getMyHero().getDeath() == 1) {
//				try {
//					heroDefeat();
//				} catch (IOException e1) {
//					e1.printStackTrace();
//				}
//			}
//		});
//		empty.getKeyFrames().add(gravity_frame);
//		empty.play();
//		handWeapon.setVisible(false);
//		handWeapon2.setVisible(false);
//		
//		platformList = new ArrayList<>();
//		colliderList = new ArrayList<>();
//		colliderList.add(collider1);colliderList.add(collider2);colliderList.add(collider3);colliderList.add(collider4);colliderList.add(collider5);colliderList.add(collider6);
//		colliderList.add(collider7);colliderList.add(collider8);colliderList.add(collider9);colliderList.add(collider10);colliderList.add(collider11);colliderList.add(collider12);
//		colliderList.add(collider13);colliderList.add(collider14);colliderList.add(collider15);
//		Platform platform;
//		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
//		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
//		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
//		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
//		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
//		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
//		platform = new Platform(0,0,0);platformList.add(platform);platform = new Platform(0,0,0);platformList.add(platform);
//		platform = new Platform(0,0,0);platformList.add(platform);
//		currGame.getMyHero().givePlatform(platformList);
//		currGame.getMyHero().beginGravity(colliderList,myHero,deathpanel);
//		wtranslate = new TranslateTransition();
//		wtranslate.setNode(handWeapon);
//		wtranslate.setDuration(Duration.millis(600));
//		wtranslate.setCycleCount(TranslateTransition.INDEFINITE);
//		wtranslate.setByY(-60);
//		wtranslate.setAutoReverse(true);
//		w2translate = new TranslateTransition();
//		w2translate.setNode(handWeapon2);
//		w2translate.setDuration(Duration.millis(600));
//		w2translate.setCycleCount(TranslateTransition.INDEFINITE);
//		w2translate.setByY(-60);
//		w2translate.setAutoReverse(true);
//		w2translate.play();
//		wtranslate.play();
//		myHero.translateXProperty().addListener((obs, old, newValue) -> {
//
//			int offset = newValue.intValue();
//			System.out.println(offset);
//
//			if (offset > 100 ){//&& //offset < 11500 - 100) {
//				currGame.getmisc().clear();
//				myPane.setLayoutX(-(offset - 100));
//				currGame.getmisc().add(new Position(myPane.getLayoutX(),myPane.getLayoutY()));
//				clickable.setX(offset - 100);
//				currGame.getmisc().add(new Position(clickable.getX(),clickable.getLayoutY()));
//				pauseButton.setX(offset - 100);
//				currGame.getmisc().add(new Position(pauseButton.getX(),pauseButton.getLayoutY()));
//				swordSlot.setX(offset - 100);
//				currGame.getmisc().add(new Position(swordSlot.getX(),swordSlot.getLayoutY()));
//				hammerSlot.setX(offset - 100);
//				currGame.getmisc().add(new Position(hammerSlot.getX(),hammerSlot.getLayoutY()));
//				coinDisplay.setX(offset - 100);
//				currGame.getmisc().add(new Position(coinDisplay.getX(),coinDisplay.getLayoutY()));
//				myScore.setX(offset - 100);
//				currGame.getmisc().add(new Position(myScore.getX(),myScore.getLayoutY()));
//				playerName.setX(offset-100);
//				currGame.getmisc().add(new Position(playerName.getX(),playerName.getLayoutY()));
//				coinCounter.setX(offset-100);
//				currGame.getmisc().add(new Position(coinCounter.getX(),coinCounter.getLayoutY()));
//				heroPane.setLayoutX(offset-100);
//				currGame.getmisc().add(new Position(heroPane.getLayoutX(),heroPane.getLayoutY()));
//			}
//		});

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
		currGame.getMyHero().moveForward(myHero);
		// System.out.println(myHero.getLayoutX());
		currGame.scoreplus1();
		myScore.setText(Integer.toString(currGame.getScore()));
	}

}
