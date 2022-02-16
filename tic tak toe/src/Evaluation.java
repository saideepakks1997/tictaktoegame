
public class Evaluation {
	public static boolean evaluate(char[][] ttt, int row, int col,char curVal) {
		int count = 0;
		for(int i=0; i<3; i++) {
			if(ttt[row][i] == curVal)
				count++;
			else
				break;
			if(count == 3)
				return true;
		}
		count = 0;
		for(int i=0; i<3; i++) {
			if(ttt[i][col] == curVal)
				count++;
			else
				break;
			if(count == 3)
				return true;
		}
		count = 0;
		if(row == col) {
			for(int i=0; i<3; i++) {
				if(ttt[i][i] == curVal)
					count++;
				else
					break;
				if(count == 3)
					return true;
			}
		}
		count = 0;
		if(col + row == 2) {
			for(int i=2; i>=0; i--) {
				if(ttt[i][2-i] == curVal)
					count++;
				else
					break;
				if(count == 3)
					return true;
			}
		}
		return false;
	}
}
