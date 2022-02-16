import java.util.*;
public class Player {
	static Scanner sc = new Scanner(System.in);
	static int count = 0;
	int player_id;
	String name;
	int noOfPlayed;
	int noOfWins;
	int noOfLost;
	int noOfDraw;
	ArrayList<PlayerGameSummary> summary = new ArrayList<>();
	
	public Player(String name) {
		player_id = ++count;
		this.name = name;
	}
	public void setWin() {
		noOfWins++;
		noOfPlayed++;
	}
	public void setLost() {
		noOfLost++;
		noOfPlayed++;
	}
	public void setDraw() {
		noOfDraw++;
		noOfPlayed++;
	}
	public void setPlayerSummary(Player opponent,int status) {
			PlayerGameSummary ps = new PlayerGameSummary(opponent, status);
			this.summary.add(ps);
	}
	public static void registerPlayer() {
		System.out.println("Enter name of the Player");
		String name = sc.next();
		Player p = new Player(name);
		ListOfPlayers.listOfPlayers.put(p.player_id, p);
	}
	public static void displayPlayerSummary(Player player) {
		System.out.format("%10s%22s%22s","Match No","opponent","status");
		System.out.println();
		int i=1;
		Iterator itr = player.summary.iterator();
		while(itr.hasNext()) {
			PlayerGameSummary ps = (PlayerGameSummary)itr.next();
			String matchStatus = (ps.status == 1)?"Won":((ps.status == 2)?"Lost":"Draw");
			System.out.format("%10s%22s%22s",i++,ps.opponent.name,matchStatus);
			System.out.println();
		}
	}
}