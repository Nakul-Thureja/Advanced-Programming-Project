package WillHero;

import java.util.ArrayList;

public class Game {
	private Player myPlayer;
    private Hero myHero;
    private ArrayList<Platform> myPlatforms;
    private ArrayList<Coin> myCoins;
    private ArrayList<Orc> myOrcs;
    private ArrayList<Companion> myCompanion;
    private BossOrc myBossOrc;
    private Helmet myHelmet;
    private ArrayList<Weapon> myWeapons;
    private ArrayList<Chest> myChests;
    private Score myScore;
    private ArrayList<GameComponents> myComponents;

    public Game(){

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
