import java.util.*;
public class MainTTT {
	 static Scanner sc = new Scanner(System.in);
	public static void main(String[] args) {
		char[][] ttt= new char[3][3];
		
		for(char[] t:ttt)
			Arrays.fill(t, '-');
	boolean loop = true;
	while(loop) {
		System.out.println("1.Register Player");
		System.out.println("2.Fix Match");
		System.out.println("3.Players summary");
		System.out.println("4.Tournament summary");
		System.out.println("5.Player Summary ");
		System.out.println("6.Exit");
		int opt = sc.nextInt();
		switch(opt) {
			case 1: 
				Player.registerPlayer();
				break;
			case 2:
				Match m = Match.selectPlayer();
				Match.startMatch(m);
				break;
			case 3:
				ListOfPlayers.displayPlayersSummary();
				break;
			case 4:
				MatchSummary.tournamentSummary();
				break;
			case 5:
				Player p = ListOfPlayers.printPlayers();
				Player.displayPlayerSummary(p);
				break;
			case 6:
				loop = false;
				break;
			default: System.out.println("Enter correct option");
				break;
			}
		}
	}
}