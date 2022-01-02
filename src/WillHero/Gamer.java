package WillHero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Gamer implements Serializable {
	private static HashMap<String,Gamer> instances = new HashMap<>();
	private Player myPlayer;
	private int coins;
	private ArrayList<Game> myGames;
	private int currentIndex;
	private int savedGames[];
	private int herotype;
	private boolean helmets[];
	public static Gamer getInstance(String playerName) {
		if(!instances.containsKey(playerName)) {
			instances.put(playerName, new Gamer(playerName));
		}
		return instances.get(playerName);
	}
	private Gamer(String playerName){
		this.myPlayer = new Player(playerName);
		this.myGames = new ArrayList<>();
		this.coins = 0;
		this.currentIndex = -1;
		this.savedGames = new int[4];
		this.savedGames[0] = -1;
		this.savedGames[1] = -1;
		this.savedGames[2] = -1;
		this.savedGames[3] = -1;
		this.herotype = 0;
		this.helmets = new boolean[5];
		this.helmets[0] = true;
	}
	public void newGame(){
		Game game = new Game();
		this.myGames.add(game);
		this.currentIndex = this.myGames.size()-1;
	}
	public Game getcurrGame() {
		if(this.currentIndex == -1) {
			newGame();
		}
		return this.myGames.get(this.currentIndex);
	}
	public void savecurrGames(int i) {
		this.savedGames[i] = this.currentIndex;
	}
	
	public void loadcurrGame(int i){
		this.currentIndex = this.savedGames[i];
	}
	
	public void endGame(Game game) {
		this.coins += game.getcurrCoins();
		this.myGames.remove(game);
	}	
	public int canBuy(int i,int coins) {
		if(!this.helmets[i]) {
			return 1;
		}
		else if	(this.coins >= coins) {
			return 2;
		}
		return 0;
	}

	public void addHelmet(int i) {
		try {
			this.helmets[i] = true;
		}
		catch(ArrayIndexOutOfBoundsException e) {
			
		}
	}
	
	public void setCoins(int getcurrCoins) {
		this.coins += getcurrCoins;	
	}
	public String getPlayerName() {
		return this.myPlayer.getName();
	}
	public boolean deduceCoins() {
		if(this.coins>=5) {
			this.coins -= 5;
			return true;
		}
		else {
			return false;
		}
	}
	public int getCoins() {
		return this.coins;
	}
}