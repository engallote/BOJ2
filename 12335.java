import java.util.*;

public class Main {
	static boolean x, o, end;
	static char[][] arr = new char[4][4];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int tc = 1; tc <= T; tc++)
		{
			x = false;
			o = false;
			end = true;
			for(int i = 0; i < 4; i++)
			{
				arr[i] = sc.next().toCharArray();
				for(int j = 0; j < 4; j++)
					if(arr[i][j] == '.') end = false;
			}
			
			//hor check
			gameHor();
			
			//ver check
			gameVer();
			
			//dia check
			gameDia();
				
			System.out.print("Case #" + tc + ": ");
			
			if(end && ((!x && !o) || (x && o))) System.out.println("Draw");
			else if(!end && (!x && !o)) System.out.println("Game has not completed");
			else if(x && !o) System.out.println("X won");
			else if(!x && o) System.out.println("O won");
		}
	}
	private static void gameDia() {
		//right
		char c = arr[0][0];
		boolean start = true;
		int  nx = 1, ny = 1;
		if(c == 'T' || c == '.'){
			start = false;
			while(true)
			{
				if(arr[nx][ny] != 'T' && arr[nx][ny] != '.'){
					c = arr[nx][ny];
					start = true;
					break;
				}
				++nx;
				++ny;
				if(nx >= 4) break;
			}
		}
		if(start){
			int cnt = 1;
			while(true)
			{
				if(c == arr[nx][ny] || arr[nx][ny] == 'T') ++cnt;
				else break;
				++nx;
				++ny;
				if(nx >= 4) break;
			}
			if(cnt == 4){
				end = true;
				if(c == 'X') x = true;
				else o = true;
			}
		}
		
		//left
		c = arr[0][3];
		start = true;
		if(c == 'T' || c == '.'){
			start = false;
			nx = 1;
			ny = 2;
			while(true)
			{
				if(arr[nx][ny] != 'T' && arr[nx][ny] != '.'){
					start = true;
					c = arr[nx][ny];
					break;
				}
				++nx;
				--ny;
				if(nx >= 4) break;
			}
		}
		if(start){
			int cnt = 1;
			nx = 1;
			ny = 2;
			while(true)
			{
				if(c == arr[nx][ny] || arr[nx][ny] == 'T') ++cnt;
				else break;
				++nx;
				--ny;
				if(nx >= 4) break;
			}
			if(cnt == 4){
				end = true;
				if(c == 'X') x = true;
				else o = true;
			}
		}
	}
	private static void gameVer() {
		for(int j = 0; j < 4; j++)
		{
			if(arr[0][j] == '.') continue;
			boolean start = true;
			char c = arr[0][j];
			if(c == 'T' || c == '.')
			{
				start = false;
				for(int i = 1; i < 4; i++)
					if(arr[i][j] != 'T' && arr[i][j] != '.'){
						c = arr[i][j];
						start = true;
						break;
					}
			}
			if(start){
				int cnt = 1;
				for(int i = 1; i < 4; i++) {
					if(c == arr[i][j] || arr[i][j] == 'T') ++cnt;
					else break;
				}
				
				if(cnt == 4){
					end = true;
					if(c == 'X') x = true;
					else o = true;
				}
			}
		}
	}
	private static void gameHor() {
		for(int i = 0; i < 4; i++)
		{
			if(arr[i][0] == '.') continue;
			char c = arr[i][0];
			boolean start = true;
			if(c == 'T')
			{
				start = false;
				for(int j = 1; j < 4; j++)
					if(arr[i][j] != 'T' && arr[i][j] != '.'){
						c = arr[i][j];
						start = true;
						break;
					}
			}
			if(start){
				int cnt = 1;
				for(int j = 1; j < 4; j++){
					if(c == arr[i][j] || arr[i][j] == 'T') ++cnt;
					else break;
				}
				
				if(cnt == 4){
					end = true;
					if(c == 'X') x = true;
					else o = true;
				}
			}
		}
	}
}