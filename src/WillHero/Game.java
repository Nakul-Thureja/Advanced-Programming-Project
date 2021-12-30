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
	private boolean loadflag;
	private ArrayList<Position> misc;
	
		
	public ArrayList<Position> getmisc() {
		return this.misc;
	}

	public Game(String playerName) {
		this.misc = new ArrayList<Position>();
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
		this.loadflag = false;
	}
	
	public boolean isLoad() {
		return this.loadflag;
	}
	public void setFlag(boolean _flag) {
		loadflag = _flag;
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

	public Hero getMyHero() {
		return this.myHero;
	}
	public Player getMyPlayer() {
		return this.myPlayer;
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


	public double getmyHeroX() {
		return this.myHero.getPositionX();
	}
	
	public double getmyHeroY() {
		return this.myHero.getPositionY();
	}


	public void scoreplus1() {
		this.myScore.scoreplus1();		
	}


	public int getScore() {
		return this.myScore.getScore();
	}
}
