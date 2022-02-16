import java.math.MathContext;
import java.util.*;
public class MatchSummary {
	Player player1;
	Player player2;
	Player winner;
	public MatchSummary(Player player1,Player player2,Player winner) {
		this.player1 = player1;
		this.player2 = player2;
		this.winner = winner;
	}
	public static void tournamentSummary() {
		Iterator itr = Match.summary.iterator();
		System.out.format("%12s%22s%22s%22s","Match number","Player-1","Player-2","Winner");
		System.out.println();
		int i=1;
		while(itr.hasNext()) {
			MatchSummary m = (MatchSummary) itr.next();
			String winner = (m.winner == null)?"Match draw":m.winner.name;
			System.out.format("%12d%22s%22s%22s",i++,m.player1.name,m.player2.name,winner);
			System.out.println();
		}
	}
}
