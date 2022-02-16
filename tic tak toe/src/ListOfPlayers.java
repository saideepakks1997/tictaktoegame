import java.util.*;
import java.util.Map.Entry;
public class ListOfPlayers {
	static LinkedHashMap<Integer,Player> listOfPlayers = new LinkedHashMap<>();
	static Scanner sc = new Scanner(System.in);
	public static void printPlayers(Integer id) {
		Set players = ListOfPlayers.listOfPlayers.entrySet();
		Iterator itr = players.iterator();
		while(itr.hasNext()) {
			Map.Entry m = (Map.Entry)itr.next();
			Player p = (Player) m.getValue();
		if(id != m.getKey())
			System.out.println(m.getKey()+"-"+p.name);
		}
	}
	public static Player printPlayers() {
		System.out.println("Select player");
		Set players = ListOfPlayers.listOfPlayers.entrySet();
		Iterator itr = players.iterator();
		int opt=0;
		while(itr.hasNext()) {
			Map.Entry m = (Map.Entry)itr.next();
			Player p = (Player) m.getValue();
			System.out.println(m.getKey()+"-"+p.name);
		}
		opt = sc.nextInt();
		return ListOfPlayers.listOfPlayers.get(opt);
		
	}
	public static void displayPlayersSummary() {
		System.out.format("%32s%7s%7s%7s%7s","Player-name","Played","Won","Losses","Draw");
		System.out.println();
		Set players = ListOfPlayers.listOfPlayers.entrySet();
		Iterator itr = players.iterator();
		while(itr.hasNext()) {
			Map.Entry m = (Map.Entry)itr.next();
			Player p = (Player) m.getValue();
			System.out.format("%32s%7s%7s%7s%7s",p.name,p.noOfPlayed,p.noOfWins,p.noOfLost,p.noOfDraw);
			System.out.println();
			}
}
}
