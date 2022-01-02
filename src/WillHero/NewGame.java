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
import javafx.scene.shape.Line;
import javafx.scene.text.Text;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;

public class NewGame {

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
	private ImageView coin16;
	@FXML
	private ImageView coin17;
	@FXML
	private ImageView coin18;
	@FXML
	private ImageView coin19;
	@FXML
	private ImageView coin20;
	@FXML
	private ImageView coin21;
	@FXML
	private ImageView coin22;
	@FXML
	private ImageView coin23;
	@FXML
	private ImageView coin24;
	@FXML
	private ImageView coin25;
	@FXML
	private ImageView coin26;
	@FXML
	private ImageView coin27;
	@FXML
	private ImageView coin28;
	@FXML
	private ImageView coin29;
	@FXML
	private ImageView coin30;
	@FXML
	private ImageView coin31;
	@FXML
	private ImageView coin32;
	@FXML
	private ImageView coin33;
	@FXML
	private ImageView coin34;
	@FXML
	private ImageView coin35;
	@FXML
	private ImageView coin36;
	@FXML
	private ImageView coin37;
	@FXML
	private ImageView coin38;
	@FXML
	private ImageView coin39;
	@FXML
	private ImageView coin40;
	@FXML
	private ImageView coin41;
	@FXML
	private ImageView coin42;
	@FXML
	private ImageView coin43;
	@FXML
	private ImageView coin44;
	@FXML
	private ImageView coin45;
	@FXML
	private ImageView coin46;
	@FXML
	private ImageView coin47;
	@FXML
	private ImageView coin48;
	@FXML
	private ImageView coin49;
	@FXML
	private ImageView coin50;
	@FXML
	private ImageView coin51;
	@FXML
	private ImageView coin52;
	@FXML
	private ImageView coin53;
	
	@FXML
	private Text playerName;
	@FXML
	private ImageView beginButton;
	@FXML
	private Text coinCounter;
	@FXML
	private AnchorPane heroPane;
	@FXML
	private ImageView greenOrc1;
	@FXML
	private ImageView greenOrc2;
	@FXML
	private ImageView greenOrc3;
	@FXML
	private ImageView greenOrc4;
	@FXML
	private ImageView greenOrc5;
	@FXML
	private ImageView greenOrc6;
	@FXML
	private ImageView greenOrc7;
	@FXML
	private ImageView greenOrc8;
	@FXML
	private ImageView greenOrc9;
	@FXML
	private ImageView greenOrc10;
	@FXML
	private ImageView greenOrc11;
	@FXML
	private ImageView greenOrc12;
	@FXML
	private ImageView greenOrc13;
	@FXML
	private ImageView greenOrc14;
	@FXML
	private ImageView greenOrc15;
	@FXML
	private ImageView greenCollider1;
	@FXML
	private ImageView greenCollider2;
	@FXML
	private ImageView greenCollider3;
	@FXML
	private ImageView greenCollider4;
	@FXML
	private ImageView greenCollider5;
	@FXML
	private ImageView greenCollider6;
	@FXML
	private ImageView greenCollider7;
	@FXML
	private ImageView greenCollider8;
	@FXML
	private ImageView greenCollider9;
	@FXML
	private ImageView greenCollider10;
	@FXML
	private ImageView greenCollider11;
	@FXML
	private ImageView greenCollider12;
	@FXML
	private ImageView greenCollider13;
	@FXML
	private ImageView greenCollider14;
	@FXML
	private ImageView greenCollider15;
	@FXML
	private ImageView redOrc1;
	@FXML
	private ImageView redOrc2;
	@FXML
	private ImageView redOrc3;
	@FXML
	private ImageView redOrc4;
	@FXML
	private ImageView redOrc5;
	@FXML
	private ImageView redOrc6;
	@FXML
	private ImageView redOrc7;
	@FXML
	private ImageView redOrc8;
	@FXML
	private ImageView redCollider1;
	@FXML
	private ImageView redCollider2;
	@FXML
	private ImageView redCollider3;
	@FXML
	private ImageView redCollider4;
	@FXML
	private ImageView redCollider5;
	@FXML
	private ImageView redCollider6;
	@FXML
	private ImageView redCollider7;
	@FXML
	private ImageView redCollider8;
	@FXML
	private ImageView bossOrc;
	@FXML
	private ImageView bossCollider;
	@FXML
	private ImageView coinChest1;
	@FXML
	private ImageView coinChest2;
	@FXML
	private ImageView coinChest3;
	@FXML
	private ImageView opencoinChest1;
	@FXML
	private ImageView opencoinChest2;
	@FXML
	private ImageView opencoinChest3;
	@FXML
	private ImageView weaponChest1;
	@FXML
	private ImageView weaponChest2;
	@FXML
	private ImageView weaponChest3;
	@FXML
	private ImageView openweaponChest1;
	@FXML
	private ImageView openweaponChest2;
	@FXML
	private ImageView openweaponChest3;
	
	private static Gamer currGamer;
	private static  Game currGame;
	private static  Score score;
	private static  TranslateTransition translate;
	private static  ScaleTransition scale;
	private static  TranslateTransition wtranslate;
	private static  TranslateTransition w2translate;
	private static  TranslateTransition translate1 = new TranslateTransition();
	private static  TranslateTransition wtranslate1 = new TranslateTransition();
	private static  TranslateTransition w2translate1 = new TranslateTransition();
	private static  ArrayList<ImageView> CollidersImageView;
	private static  ArrayList<ImageView> CoinsImageView;
	private static  ArrayList<ImageView> RedOrcsImageView;
	private static  ArrayList<ImageView> GreenOrcsImageView;
	private static  ArrayList<ImageView> WeaponChestImageView;
	private static  ArrayList<ImageView> CoinChestImageView;
	private static  ArrayList<ImageView> openWeaponChestImageView;
	private static  ArrayList<ImageView> openCoinChestImageView;
	private static  ArrayList<ImageView> OrcCollidersImageView;
	private static  ArrayList<ImageView> WeaponImageView;
	
	private static  GameSlots gameSlot;
	private static  HashMap<GameComponents, HashMap<GameComponents, ImageView>> CollisionMap;

	public void letsBegin(MouseEvent e) {
		Thread thread = new Thread(() -> {
			CollidersImageView = new ArrayList<>();
			CoinsImageView = new ArrayList<>();
			RedOrcsImageView = new ArrayList<>();
			GreenOrcsImageView = new ArrayList<>();
			WeaponChestImageView = new ArrayList<>();
			CoinChestImageView = new ArrayList<>();
			openWeaponChestImageView = new ArrayList<>();
			openCoinChestImageView = new ArrayList<>();
			OrcCollidersImageView = new ArrayList<>();
			WeaponImageView = new ArrayList<>();
			
			WeaponImageView.add(handWeapon);
			WeaponImageView.add(handWeapon2);
			
			GreenOrcsImageView.add(greenOrc1);
			GreenOrcsImageView.add(greenOrc2);
			GreenOrcsImageView.add(greenOrc3);
			GreenOrcsImageView.add(greenOrc4);
			GreenOrcsImageView.add(greenOrc5);
			GreenOrcsImageView.add(greenOrc6);
			GreenOrcsImageView.add(greenOrc7);
			GreenOrcsImageView.add(greenOrc8);
			GreenOrcsImageView.add(greenOrc9);
			GreenOrcsImageView.add(greenOrc10);
			GreenOrcsImageView.add(greenOrc11);
			GreenOrcsImageView.add(greenOrc12);
			GreenOrcsImageView.add(greenOrc13);
			GreenOrcsImageView.add(greenOrc14);
			GreenOrcsImageView.add(greenOrc15);

			RedOrcsImageView.add(redOrc1);
			RedOrcsImageView.add(redOrc2);
			RedOrcsImageView.add(redOrc3);
			RedOrcsImageView.add(redOrc4);
			RedOrcsImageView.add(redOrc5);
			RedOrcsImageView.add(redOrc6);
			RedOrcsImageView.add(redOrc7);
			RedOrcsImageView.add(redOrc8);
			
			OrcCollidersImageView.add(greenCollider1);
			OrcCollidersImageView.add(greenCollider2);
			OrcCollidersImageView.add(greenCollider3);
			OrcCollidersImageView.add(greenCollider4);
			OrcCollidersImageView.add(greenCollider5);
			OrcCollidersImageView.add(greenCollider6);
			OrcCollidersImageView.add(greenCollider7);
			OrcCollidersImageView.add(greenCollider8);
			OrcCollidersImageView.add(greenCollider9);
			OrcCollidersImageView.add(greenCollider10);
			OrcCollidersImageView.add(greenCollider11);
			OrcCollidersImageView.add(greenCollider12);
			OrcCollidersImageView.add(greenCollider13);
			OrcCollidersImageView.add(greenCollider14);
			OrcCollidersImageView.add(greenCollider15);
			OrcCollidersImageView.add(redCollider1);
			OrcCollidersImageView.add(redCollider2);
			OrcCollidersImageView.add(redCollider3);
			OrcCollidersImageView.add(redCollider4);
			OrcCollidersImageView.add(redCollider5);
			OrcCollidersImageView.add(redCollider6);
			OrcCollidersImageView.add(redCollider7);
			OrcCollidersImageView.add(redCollider8);

				
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
			CoinsImageView.add(coin16);
			CoinsImageView.add(coin17);
			CoinsImageView.add(coin18);
			CoinsImageView.add(coin19);
			CoinsImageView.add(coin20);
			CoinsImageView.add(coin21);
			CoinsImageView.add(coin22);
			CoinsImageView.add(coin23);
			CoinsImageView.add(coin24);
			CoinsImageView.add(coin25);
			CoinsImageView.add(coin26);
			CoinsImageView.add(coin27);
			CoinsImageView.add(coin28);
			CoinsImageView.add(coin29);
			CoinsImageView.add(coin30);
			CoinsImageView.add(coin31);
			CoinsImageView.add(coin32);
			CoinsImageView.add(coin33);
			CoinsImageView.add(coin34);
			CoinsImageView.add(coin35);
			CoinsImageView.add(coin36);
			CoinsImageView.add(coin37);
			CoinsImageView.add(coin38);
			CoinsImageView.add(coin39);
			CoinsImageView.add(coin40);
			CoinsImageView.add(coin41);
			CoinsImageView.add(coin42);
			CoinsImageView.add(coin43);
			CoinsImageView.add(coin44);
			CoinsImageView.add(coin45);
			CoinsImageView.add(coin46);
			CoinsImageView.add(coin47);
			CoinsImageView.add(coin48);
			CoinsImageView.add(coin49);
			CoinsImageView.add(coin50);
			CoinsImageView.add(coin51);
			CoinsImageView.add(coin52);
			CoinsImageView.add(coin53);
			
			CoinChestImageView.add(coinChest1);
			CoinChestImageView.add(coinChest2);
			CoinChestImageView.add(coinChest3);
			
			WeaponChestImageView.add(weaponChest1);
			WeaponChestImageView.add(weaponChest2);
			WeaponChestImageView.add(weaponChest3);
			
			openCoinChestImageView.add(opencoinChest1);
			openCoinChestImageView.add(opencoinChest2);
			openCoinChestImageView.add(opencoinChest3);
			
			openWeaponChestImageView.add(openweaponChest1);
			openWeaponChestImageView.add(openweaponChest2);
			openWeaponChestImageView.add(openweaponChest3);

		}); 
		thread.start();
		Stage stage = (Stage) ((Node) e.getSource()).getScene().getWindow();
		currGamer = (Gamer) stage.getUserData();
		
		
		if(!currGamer.isLoad()) {
			currGamer.newGame();
		}
		
		currGame = currGamer.getcurrGame();
		currGame.initMap();		
		
		try {
			thread.join();
		} catch (InterruptedException e3) {
			// TODO Auto-generated catch block
			e3.printStackTrace();
		}
		
		if (currGamer.isLoad()) {
			loadGame();
		} 
		else {
			initGame();
		}
		currGame.setHeroImage(myHero);
		currGame.reviveHero();
		currGame.giveWeaponImage(handWeapon, handWeapon2);
		currGame.setCoinMap(CoinsImageView);
		currGame.setGorcMap(GreenOrcsImageView,OrcCollidersImageView);
		currGame.setRorcMap(RedOrcsImageView, OrcCollidersImageView);
		currGame.setColliderMap(OrcCollidersImageView);
		currGame.setPlatformMap(CollidersImageView);
		currGame.setCoinChestMap(CoinChestImageView,openCoinChestImageView);
		currGame.setWeaponChestMap(WeaponChestImageView,openWeaponChestImageView);
		currGame.setWeaponMap(WeaponImageView);
		currGame.giveWeaponstoHero();
		empty = new Timeline();
		empty.setCycleCount(Animation.INDEFINITE);
		KeyFrame empty_frame = new KeyFrame(Duration.millis(18), e1 -> {
			coinCounter.setText(Integer.toString(currGame.getcurrCoins()));
			
			if (myHero.getBoundsInParent().intersects(deathpanel.getBoundsInParent()) || currGame.getHeroStat()) {
				try {
					currGamer.setCoins(currGame.getcurrCoins());
					heroDefeat();
				} catch (IOException e2) {
					e2.printStackTrace();
				}
			}
			
			for(int i= 0;i<GreenOrcsImageView.size();i++) {
				if (GreenOrcsImageView.get(i).getBoundsInParent().intersects(deathpanel.getBoundsInParent())) {
					currGame.getMygreenOrcs().get(i).setVisibilty(false);
					GreenOrcsImageView.get(i).setVisible(false);
				}
			}
			
			for(int i= 0;i<RedOrcsImageView.size();i++) {
				if (RedOrcsImageView.get(i).getBoundsInParent().intersects(deathpanel.getBoundsInParent())) {
					currGame.getMyredOrcs().get(i).setVisibilty(false);
					RedOrcsImageView.get(i).setVisible(false);
				}
			}
		});
		empty.getKeyFrames().add(empty_frame);
		empty.play();
		
		
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
		playerName.setText(currGamer.getPlayerName());
		myHero.setTranslateX(currGame.getmyHeroX() + currGame.getForwardMove());
		for(int i = 0;i<currGame.getMygreenOrcs().size();i++) {
			
			GreenOrcsImageView.get(i).setTranslateX(currGame.getMygreenOrcs().get(i).getPositionX());
			OrcCollidersImageView.get(i).setTranslateX(currGame.getMygreenOrcs().get(i).getColliderX());
		}
		for(int i = 0;i<currGame.getMyredOrcs().size();i++) {
			
			RedOrcsImageView.get(i).setTranslateX(currGame.getMyredOrcs().get(i).getPositionX());
			OrcCollidersImageView.get(i+15).setTranslateX(currGame.getMyredOrcs().get(i).getColliderX());
		}
		myScore.setText(Integer.toString(currGame.getScore()));
		beginButton.setVisible(false);
		
	}

	public void initGame() {
		beginButton.setVisible(false);
		playerName.setText(currGamer.getPlayerName());
		GameFactory factory = new GameFactory();
		currGamer.setFlag(true);
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
		for (int i = 0; i < 53; i++) {
			myCoins.add((Coin) factory.createComponent("coin"));
		}
		currGame.setMyCoins(myCoins);
		ArrayList<GreenOrc> mygorcs = new ArrayList<>();
		for (int i = 0; i < 15; i++) {
			mygorcs.add((GreenOrc) factory.createComponent("greenorc"));
		}
		currGame.setMygreenOrcs(mygorcs);
		ArrayList<RedOrc> myrorcs = new ArrayList<>();
		for (int i = 0; i < 8; i++) {
			myrorcs.add((RedOrc) factory.createComponent("redorc"));
		}
		currGame.setMyredOrcs(myrorcs);
		ArrayList<Platform> myplatforms = new ArrayList<>();
		for (int i = 0; i < 45; i++) {
			myplatforms.add((Platform) factory.createComponent("platform"));
		}
		currGame.setMyPlatforms(myplatforms);
		ArrayList<Collider> mycollider = new ArrayList<>();
		for (int i = 0; i < 23; i++) {
			mycollider.add((Collider) factory.createComponent("collider"));
		}
		currGame.setMyColliders(mycollider);
		ArrayList<CoinChest> mycoinChest = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			mycoinChest.add((CoinChest) factory.createComponent("coinchest"));
		}
		currGame.setMyCoinChests(mycoinChest);
		ArrayList<WeaponChest> myweaponChest = new ArrayList<>();
		for (int i = 0; i < 3; i++) {
			myweaponChest.add((WeaponChest) factory.createComponent("weaponchest"));
		}
		currGame.setMyWeaponChests(myweaponChest);
	
	}

	public void heroDefeat() throws IOException {
		empty.stop();
		currGamer.setFlag(false);
		Parent root = FXMLLoader.load(getClass().getResource("/HeroDies.fxml"));
		Stage stage = (Stage) myPane.getScene().getWindow();
		stage.setUserData(currGamer);
		Scene scene = new Scene(root);
		stage.setScene(scene);
		stage.show();
	}

	public void pauseHandler(MouseEvent event) throws IOException {
		empty.stop();
		currGame.stopALL();
		Parent root = FXMLLoader.load(getClass().getResource("/Pause.fxml"));
		Stage stage = (Stage) ((Node) event.getSource()).getScene().getWindow();
		stage.setUserData(currGamer);
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
