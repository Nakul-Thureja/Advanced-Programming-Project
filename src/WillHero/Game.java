package WillHero;

import java.util.ArrayList;

public class Game {
	private Player myPlayer;
    private Hero myHero;
    private ArrayList<Platform> myPlatforms;
    private ArrayList<Coin> myCoins;
    private ArrayList<Orc> myOrcs;
    private Companion myCompanion;
    private BossOrc myBossOrc;
    private Helmet myHelmet;
    private ArrayList<Weapon> myWeapons;
    private ArrayList<Chest> myChests;
    private Score myScore;
    private ArrayList<GameComponents> myComponents;

    public Game(String playerName){
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

    //add clone
    public void setHelmet(Helmet helmet){
        this.myHelmet = helmet;
    }

    public void setHero(Hero hero){
        this.myHero = hero;
    }

    public void setMyWeapons(ArrayList<Weapon> Weapons){
        this.myWeapons = new ArrayList<>(Weapons);
    }
    public void setMyScore(Score score){
        this.myScore = score;
    }

    public void setMyPlayer(Player myPlayer) {
        this.myPlayer = myPlayer;
    }

    public Player getMyPlayer() {
        return this.myPlayer;
    }

    @Override
    public String toString() {
        return "Game{}";
    }
}
