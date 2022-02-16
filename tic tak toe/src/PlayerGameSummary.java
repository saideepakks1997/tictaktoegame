
public class PlayerGameSummary {
	Player opponent;
	int status;//1-win,2-loss,3-draw
	public PlayerGameSummary(Player opponent, int status) {
		this.opponent = opponent;
		this.status = status;
	}
}
