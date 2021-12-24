package WillHero;

import java.io.Serializable;
import java.util.ArrayList;

import javafx.scene.image.ImageView;

public class Game implements Serializable{
	private Player myPlayer;
	private Hero myHero;
	private ArrayList<Platform> myPlatforms;
	private ArrayList<Coin> myCoins;
	private int numCoins;
	private ArrayList<Orc> myOrcs;
	private Companion myCompanion;
	private BossOrc myBossOrc;
	private Helmet myHelmet;
	private ArrayList<Weapon> myWeapons;
	private ArrayList<Chest> myChests;
	private Score myScore;
	private ArrayList<GameComponents> myComponents;

	public Game(String playerName) {
		this.numCoins = 0;
		this.myPlayer = new Player(playerName);
		this.myHero = null;
		this.myPlatforms = null;
		this.myCoins = null;
		this.myOrcs = null;
		this.myCompanion = null;
		this.myBossOrc = null;
		this.myHelmet = null;
		this.myWeapons = null;
		this.myChests = null;
		this.myScore = null;
		this.myComponents = null;
	}

	// add clone
	public int getCoins() {
		return this.numCoins;
	}

	public void setHelmet(Helmet helmet) {
		this.myHelmet = helmet;
	}

	public void setHero(Hero hero) {
		this.myHero = hero;
	}

	public void setMyWeapons(ArrayList<Weapon> Weapons) {
		this.myWeapons = new ArrayList<>(Weapons);
	}

	public void setMyScore(Score score) {
		this.myScore = score;
	}

	public void setMyPlayer(Player myPlayer) {
		this.myPlayer = myPlayer;
	}

	public Player getMyPlayer() {
		return this.myPlayer;
	}

	public Score getMyScore() {
		return this.myScore;
	}

	public void master_collider(ImageView caller) {
		for (int i = 0; i < this.myComponents.size(); i++) {
			myComponents.get(i).collision(caller);
		}

	}

	@Override
	public String toString() {
		return "Game{}";
	}
}
