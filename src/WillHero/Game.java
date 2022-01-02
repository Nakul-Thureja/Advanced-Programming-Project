package WillHero;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.ImageView;

public class Game implements Serializable {
	private Hero myHero;
	private ArrayList<Platform> myPlatforms;
	private ArrayList<Coin> myCoins;
	private ArrayList<RedOrc> myredOrcs;
	private ArrayList<GreenOrc> mygreenOrcs;
	private ArrayList<Collider> myColliders;
	private Companion myCompanion;
	private BossOrc myBossOrc;
	private Helmet myHelmet;
	private ArrayList<Weapon> myWeapons;
	private ArrayList<Chest> myChests;
	private Score myScore;
	private ArrayList<GameComponents> myComponents;
	private ArrayList<Position> misc;
	private boolean ended;
	private transient HashMap<GameComponents, HashMap<GameComponents, ImageView>> CollisionMap;
	private transient HashMap<GameComponents, ImageView> PlatformMap;
	private transient HashMap<GameComponents, ImageView> GreenOrcMap;
	private transient HashMap<GameComponents, ImageView> CollidersMap;
	private transient HashMap<GameComponents, ImageView> RedOrcMap;
	private transient HashMap<GameComponents, ImageView> WeaponMap;
	private transient HashMap<GameComponents, ImageView> CoinMap;

	public ArrayList<Position> getmisc() {
		return this.misc;
	}

//	public static void addInstances(GameSlots slots) {
//		
//		if(slots.getSlot1()!=null) {
//			Game game = slots.getSlot1();
//			playerCoins = game.playerCoins;
//		}
//		if(slots.getSlot2()!=null) {
//			Game game = slots.getSlot2();
//			instances.put(game.getPlayerName(), game);
//		}
//		if(slots.getSlot3()!=null) {
//			Game game = slots.getSlot3();
//			instances.put(game.getPlayerName(), game);
//		}
//		if(slots.getSlot4()!=null) {
//			Game game = slots.getSlot4();
//			instances.put(game.getPlayerName(), game);
//		}
//	}
	
	
	
	public Game() {
		this.misc = new ArrayList<Position>();
		this.myHero = null;
		this.myPlatforms = null;
		this.myCoins = null;
		this.mygreenOrcs = null;
		this.myredOrcs = null;
		this.myCompanion = null;
		this.myBossOrc = null;
		this.myHelmet = null;
		this.myWeapons = null;
		this.myChests = null;
		this.myScore = null;
		this.myComponents = null;
		this.myColliders = null;
		this.CollisionMap = null;
		this.CoinMap = null;
		this.PlatformMap = null;
		this.WeaponMap = null;
		this.RedOrcMap = null;
		this.GreenOrcMap = null;
		this.CollidersMap = null;
		this.ended = false;
	}
	public void end() {
		this.ended = true;
	}
	public boolean isEnded() {
		return this.ended;
	}
	public void initMap() {
		this.CollisionMap = new HashMap<>();
		this.CoinMap = new HashMap<>();
		this.PlatformMap = new HashMap<>();
		this.WeaponMap = new HashMap<>();
		this.RedOrcMap = new HashMap<>();
		this.GreenOrcMap = new HashMap<>();
		this.CollidersMap = new HashMap<>();
	}

	

//	public int getCoins() {
//		return this.totalCoins;
//	}
//	public boolean deduceCoins() {
//		if(totalCoins>=5) {
//			totalCoins -= 5;
//			myHero.setcurrCoins(totalCoins) ;
//			return true;
//		}
//		else {
//			return false;
//		}
//	}
//	public void setCoins(int num) {
//		this.totalCoins += num;
//		playerCoins.put(getPlayerName(), num);
//	}

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



	public void setHeroImage(ImageView node) {
		this.myHero.setImage(node);
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

	private void callInit(GameComponents comp, HashMap<GameComponents, ImageView> map) {
		if (comp.getClass() == this.myHero.getClass()) {
			this.myHero.beginGravity(map);
		}
		else if (comp.getClass() == GreenOrc.class) {
			for(int i = 0 ;i< this.mygreenOrcs.size();i++) {
				mygreenOrcs.get(i).beginGravity(map);	
			}
		}
		else if (comp.getClass() == RedOrc.class) {
			for(int i = 0 ;i< this.myredOrcs.size();i++) {
				myredOrcs.get(i).beginGravity(map);	
			}
		}
	}

	public void addColliders() {
		HashMap<GameComponents, ImageView> HeroMap = new HashMap<>();
		HeroMap.putAll(PlatformMap);
		HeroMap.putAll(CoinMap);
		HeroMap.putAll(GreenOrcMap);
		HeroMap.putAll(RedOrcMap);
		HeroMap.putAll(CollidersMap);
		CollisionMap.put(this.myHero, HeroMap);
		HashMap<GameComponents, ImageView> GorcMap = new HashMap<>();
		GorcMap.putAll(PlatformMap);
		CollisionMap.put(this.mygreenOrcs.get(0), GorcMap);	
		HashMap<GameComponents, ImageView> RorcMap = new HashMap<>();
		RorcMap.putAll(PlatformMap);
		CollisionMap.put(this.myredOrcs.get(0), RorcMap);	
	}

	public void beginGame() {
		this.addColliders();
		CollisionMap.forEach((key, value) -> callInit(key, value));
	}

	private ArrayList<Platform> getMyPlatforms() {
		return myPlatforms;
	}

	public void reviveHero() {
		this.myHero.revive();
	}
	public void setMyPlatforms(ArrayList<Platform> myPlatforms) {
		this.myPlatforms = myPlatforms;
	}

	private ArrayList<Coin> getMyCoins() {
		return myCoins;
	}

	public void setMyCoins(ArrayList<Coin> myCoins) {
		this.myCoins = myCoins;
	}

	public ArrayList<RedOrc> getMyredOrcs() {
		return myredOrcs;
	}
	
	public boolean getHeroStat() {
		return this.myHero.status();
	}
	
	
	public void setMyredOrcs(ArrayList<RedOrc> myredOrcs) {
		this.myredOrcs = myredOrcs;
	}

	public ArrayList<GreenOrc> getMygreenOrcs() {
		return mygreenOrcs;
	}

	public void setMygreenOrcs(ArrayList<GreenOrc> mygreenOrcs) {
		this.mygreenOrcs = mygreenOrcs;
	}

	public int getcurrCoins() {
		return this.myHero.getcurrCoins();
	}

	public void stopALL() {
		this.myHero.stopALL();
		for(int i = 0 ;i< this.mygreenOrcs.size();i++) {
			this.mygreenOrcs.get(i).stopALL();
		}
		for(int j = 0;j<this.myredOrcs.size();j++) {
			this.myredOrcs.get(j).stopALL();
		}
	}

	public void moveHeroForward(ImageView myHero2) {
		this.myHero.moveForward(myHero2);
	}

	
	public void setPlatformMap(ArrayList<ImageView> Nodes) {
		for (int i = 0; i < 45; i++) {
			PlatformMap.put(this.getMyPlatforms().get(i), Nodes.get(i));
		}
	}

	public void setCoinMap(ArrayList<ImageView> Nodes) {
		for (int i = 0; i < 15; i++) {
			Nodes.get(i).setVisible(this.getMyCoins().get(i).getVisibilty());
			CoinMap.put(this.getMyCoins().get(i), Nodes.get(i));
		}
	}

	public double getForwardMove() {

		return this.myHero.getForwardValue();
	}

	public void setGorcMap(ArrayList<ImageView> Nodes, ArrayList<ImageView> Node2) {
		for (int i = 0; i < this.getMygreenOrcs().size(); i++) {
			Nodes.get(i).setVisible(this.getMygreenOrcs().get(i).getVisibilty());
			this.getMygreenOrcs().get(i).setImage(Nodes.get(i));
			this.getMygreenOrcs().get(i).setCollider(Node2.get(i));
			GreenOrcMap.put(this.getMygreenOrcs().get(i), Nodes.get(i));
		}
	}
	public void setRorcMap(ArrayList<ImageView> Nodes, ArrayList<ImageView> Node2) {
		for (int i = 0; i < this.getMyredOrcs().size(); i++) {
			Nodes.get(i).setVisible(this.getMyredOrcs().get(i).getVisibilty());
			this.getMyredOrcs().get(i).setImage(Nodes.get(i));
			this.getMyredOrcs().get(i).setCollider(Node2.get(i + 15));
			RedOrcMap.put(this.getMyredOrcs().get(i), Nodes.get(i));
		}
	}
	public void setColliderMap(ArrayList<ImageView> Nodes) {
		for (int i = 0; i < 23; i++) {
			CollidersMap.put(this.getMyColliders().get(i), Nodes.get(i));
		}
	}
	
	
	private ArrayList<Collider> getMyColliders() {
		return this.myColliders;
	}

	public void setMyColliders(ArrayList<Collider> myColliders) {
		this.myColliders = myColliders;
	}

//	public int canBuy(int i,int coins) {
//		if(!this.helmets[i]) {
//			return 1;
//		}
//		else if	(this.totalCoins >= coins) {
//			return 2;
//		}
//		return 0;
//	}
//
//	public void addHelmet(int i) {
//		try {
//			this.helmets[i] = true;
//		}
//		catch(ArrayIndexOutOfBoundsException e) {
//			
//		}
//	}
}
