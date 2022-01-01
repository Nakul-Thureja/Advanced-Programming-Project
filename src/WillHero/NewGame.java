package WillHero;

import java.io.IOException;
import java.net.URISyntaxException;
import java.util.ArrayList;
import java.util.HashMap;
import javafx.animation.Animation;
import javafx.animation.Interpolator;
import javafx.animation.KeyFrame;
import javafx.animation.ScaleTransition;
import javafx.animation.Timeline;
import javafx.animation.TranslateTransition;
import javafx.stage.Stage;
import javafx.util.Duration;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class NewGame{

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
	@FXML
	private ImageView coinDisplay;
	@FXML
	private ImageView handWeapon;
	@FXML
	private ImageView handWeapon2;
	@FXML
	private ImageView clickable;
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
	private ArrayList<ImageView> CollidersImageView;
	private ArrayList<ImageView> CoinsImageView;
	private ArrayList<ImageView> RedOrcsImageView;
	private ArrayList<ImageView> GreenOrcsImageView;
	private ArrayList<ImageView> WeaponChestImageView;
	private ArrayList<ImageView> CoinChestImageView;
	
	
	private GameSlots gameSlot;
	private HashMap<GameComponents, HashMap<GameComponents,ImageView>> CollisionMap;


	public void letsBegin(MouseEvent e) {
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		currGame = (Game) stage.getUserData();
		currGame.initMap();
		if (currGame.isLoad()) {
			loadGame();

		} else {
			initGame();
		}
		currGame.setHeroImage(myHero);
		CollisionMap = new HashMap<>();		
		CollidersImageView = new ArrayList<>();
		CoinsImageView = new ArrayList<>();	
		RedOrcsImageView = new ArrayList<>();
		GreenOrcsImageView = new ArrayList<>();	
		WeaponChestImageView = new ArrayList<>();
		CoinChestImageView = new ArrayList<>();	
		
		CollidersImageView.add(collider1);
		CollidersImageView.add(collider2);
		CollidersImageView.add(collider3);
		CollidersImageView.add(collider4);
		CollidersImageView.add(collider5);
		CollidersImageView.add(collider6);
		CollidersImageView.add(collider7);
		CollidersImageView.add(collider8);
		CollidersImageView.add(collider9);
		CollidersImageView.add(collider10);
		CollidersImageView.add(collider11);
		CollidersImageView.add(collider12);
		CollidersImageView.add(collider13);
		CollidersImageView.add(collider14);
		CollidersImageView.add(collider15);
		CollidersImageView.add(collider16);
		CollidersImageView.add(collider17);
		CollidersImageView.add(collider18);
		CollidersImageView.add(collider19);
		CollidersImageView.add(collider20);
		CollidersImageView.add(collider21);
		CollidersImageView.add(collider22);
		CollidersImageView.add(collider23);
		CollidersImageView.add(collider24);
		CollidersImageView.add(collider25);
		CollidersImageView.add(collider26);
		CollidersImageView.add(collider27);
		CollidersImageView.add(collider28);
		CollidersImageView.add(collider29);
		CollidersImageView.add(collider30);
		CollidersImageView.add(collider31);
		CollidersImageView.add(collider32);
		CollidersImageView.add(collider33);
		CollidersImageView.add(collider34);
		CollidersImageView.add(collider35);
		CollidersImageView.add(collider36);
		CollidersImageView.add(collider37);
		CollidersImageView.add(collider38);
		CollidersImageView.add(collider39);
		CollidersImageView.add(collider40);
		CollidersImageView.add(collider41);
		CollidersImageView.add(collider42);
		CollidersImageView.add(collider43);
		CollidersImageView.add(collider44);
		CollidersImageView.add(collider45);
		
		CoinsImageView.add(coin1);
		CoinsImageView.add(coin2);
		CoinsImageView.add(coin3);
		CoinsImageView.add(coin4);
		CoinsImageView.add(coin5);
		CoinsImageView.add(coin6);
		CoinsImageView.add(coin7);
		CoinsImageView.add(coin8);
		CoinsImageView.add(coin9);
		CoinsImageView.add(coin10);
		CoinsImageView.add(coin11);
		CoinsImageView.add(coin12);
		CoinsImageView.add(coin13);
		CoinsImageView.add(coin14);
		CoinsImageView.add(coin15);
		
		
		empty = new Timeline();
		empty.setCycleCount(Animation.INDEFINITE);
		KeyFrame empty_frame = new KeyFrame(Duration.millis(18), e1 -> {
			coinCounter.setText(Integer.toString(currGame.getcurrCoins()));
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
		
		currGame.setCoinMap(CoinsImageView);
		currGame.setPlatformMap(CollidersImageView);
		currGame.beginGame();
		myHero.translateXProperty().addListener((obs, old, newValue) -> {
			int offset = newValue.intValue();
			if (offset > 100) {
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
		coinDisplay.setX(misc.get(5).getX());
		myScore.setX(misc.get(6).getX());
		playerName.setX(misc.get(7).getX());
		coinCounter.setX(misc.get(8).getX());
		playerName.setText(currGame.getPlayerName());
		myHero.setTranslateX(currGame.getmyHeroX() + 92);
		myScore.setText(Integer.toString(currGame.getScore()));
		beginButton.setVisible(false);
	}

	public void initGame() {		
		beginButton.setVisible(false);
		playerName.setText(currGame.getPlayerName());
		GameFactory factory = new GameFactory(); 
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
		ArrayList<Coin> myCoins = new ArrayList<>();
		for(int i=0;i<50;i++) {
			myCoins.add((Coin) factory.createComponent("coin"));
		}
		currGame.setMyCoins(myCoins);
		ArrayList<GreenOrc> mygorcs = new ArrayList<>();
		for(int i=0;i<20;i++) {
			mygorcs.add((GreenOrc) factory.createComponent("greenorc"));
		}
		currGame.setMygreenOrcs(mygorcs);
		ArrayList<RedOrc> myrorcs = new ArrayList<>();
		for(int i=0;i<10;i++) {
			myrorcs.add((RedOrc) factory.createComponent("redorc"));
		}
		currGame.setMyredOrcs(myrorcs);
		ArrayList<Platform> myplatforms = new ArrayList<>();
		for(int i=0;i<45;i++) {
			myplatforms.add((Platform) factory.createComponent("platform"));
		}
		currGame.setMyPlatforms(myplatforms);
	}

	public void heroDefeat() throws IOException {
		empty.stop();
		currGame.setFlag(false);
		Parent root = FXMLLoader.load(getClass().getResource("/HeroDies.fxml"));
		Stage stage = (Stage) myPane.getScene().getWindow();
		stage.setUserData(currGame);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void pauseHandler(MouseEvent event) throws IOException {
		empty.stop();
		currGame.stopALL();
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

	public void move(MouseEvent e) throws IOException {
		currGame.moveHeroForward(myHero);
		currGame.scoreplus1();
		myScore.setText(Integer.toString(currGame.getScore()));
	}
}
