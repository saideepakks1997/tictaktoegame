import java.util.*;
public class Match {
	static Scanner sc = new Scanner(System.in);
	Player player1;
	Player player2;
	static ArrayList<MatchSummary> summary = new ArrayList<>();
	public Match(Player player1,Player player2) {
		this.player1 = player1;
		this.player2 = player2;
	}
	
	public static Match selectPlayer() {
		int i=1;
		int selectPlayerId = 0;
		Player player1=null,player2=null;
		while(i<3) {
			System.out.println("Select player "+i);
			ListOfPlayers.printPlayers(selectPlayerId);
			selectPlayerId = sc.nextInt();
			Player p = ListOfPlayers.listOfPlayers.get(selectPlayerId);
			if(i==1)
				player1 = p;
			else
				player2 = p;
			i++;
			}
		Match m = new Match(player1,player2);
		return m;
	}
	public static void startMatch(Match m) {
		System.out.println("Match between "+m.player1.name+"(X) and "+m.player2.name+"(O)");
		char[][] ttt = new char[3][3];
		for(char[] t:ttt)
			Arrays.fill(t, '-');
		int i=0;
		boolean loop = true;
		char curVal = 'X';
		sc.nextLine();
		while(loop) {
			char tempVal='/';
			Print.printTTT(ttt);
			System.out.println("Enter row and col number");
			
			String ip = sc.nextLine();
			int[] rc = processIp(ip);
			int row = rc[0]-49;
			int col = rc[1]-49;
//			int col = 1;
			System.out.println("row = "+row+"col = "+col);
//			System.exit(0);
			if(ttt[row][col] == '-') {
				ttt[row][col] = curVal;
				i++;
				tempVal = curVal;
				curVal = (curVal == 'X')?'O':'X';
			}
			else {
				System.out.println("Enter correct input");
			}
				
			
			if(i>=5) {
				boolean isGameOver =  Evaluation.evaluate(ttt,row,col,tempVal);
				if(isGameOver) {
					Player winner = (tempVal == 'X')?m.player1:m.player2;
					Player losser = (tempVal == 'X')?m.player2:m.player1;
					Print.printTTT(ttt);
					System.out.println(winner.name+" has won the game");
					winner.setWin();
					losser.setLost();
					MatchSummary ms = new MatchSummary(m.player1, m.player2, winner);
					Match.summary.add(ms);
					winner.setPlayerSummary(losser, 1);
					losser.setPlayerSummary(winner, 2);
					loop = false;
					break;
				}
			}
			
			if(i==9) {
				m.player1.setDraw();
				m.player2.setDraw();
				System.out.println("Game over");
				MatchSummary ms = new MatchSummary(m.player1, m.player2, null);
				Match.summary.add(ms);
				m.player1.setPlayerSummary(m.player2, 3);
				m.player2.setPlayerSummary(m.player1, 3);
				break;
			}
			
		}
		
	}

	private static int[] processIp(String ip) {
		int[] rc = new int[2];
		rc[0] = ip.charAt(0);
		rc[1] = ip.charAt(2);
		return rc;
	}

}
