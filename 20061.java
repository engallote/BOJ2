import java.util.*;

public class Main {
	static int res = 0;
	static int[][] green = new int[6][4], blue = new int[4][6];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(--N >= 0) {
			int t = sc.nextInt();
			int x = sc.nextInt();
			int y = sc.nextInt();
			
			downG(t, x, y);
			downB(t, x, y);
			
			clearLine();
			
			remove();
		}
		
		System.out.println(res);
		int cnt = 0;
		for(int i = 0; i < 6; i++)
			for(int j = 0; j < 4; j++)
				cnt += green[i][j];
		
		for(int i = 0; i < 4; i++)
			for(int j = 0; j < 6; j++)
				cnt += blue[i][j];
		
		System.out.println(cnt);
	}
	private static void remove() {
		int cnt = 0;
		//green
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 4; j++)
				if(green[i][j] != 0) {
					++cnt;
					break;
				}
		
		while(--cnt >= 0) {
			for(int i = 4; i >= 0; i--)
				for(int j = 0; j < 4; j++)
					green[i + 1][j] = green[i][j];
			Arrays.fill(green[0], 0);
		}
		
		//blue
		cnt = 0;
		for(int i = 0; i < 2; i++)
			for(int j = 0; j < 4; j++)
				if(blue[j][i] != 0) {
					++cnt;
					break;
				}
		
		while(--cnt >= 0) {
			for(int i = 4; i >= 0; i--)
				for(int j = 0; j < 4; j++)
					blue[j][i + 1] = blue[j][i];
			for(int i = 0; i < 4; i++)
				blue[i][0] = 0;
		}
	}
	private static void clearLine() {
		int cnt = 0;
		boolean flag = true;
		//green
		while(flag) {
			flag = false;
			for(int i = 5; i > 0; i--) {
				cnt = 0;
				for(int j = 0; j < 4; j++)
					if(green[i][j] != 0) ++cnt;
				
				if(cnt == 4) {
					++res;
					flag = true;
					for(int k = i; k > 0; k--)
						for(int j = 0; j < 4; j++)
							green[k][j] = green[k-1][j];
					Arrays.fill(green[0], 0);
				}
			}
		}
		
		//blue
		flag = true;
		while(flag) {
			flag = false;
			for(int i = 5; i > 0; i--) {
				cnt = 0;
				for(int j = 0; j < 4; j++)
					if(blue[j][i] != 0) ++cnt;
				
				if(cnt == 4) {
					++res;
					flag = true;
					for(int k = i; k > 0; k--)
						for(int j = 0; j < 4; j++)
							blue[j][k] = blue[j][k - 1];
					for(int j = 0; j < 4; j++)
						blue[j][0] = 0;
				}
			}
		}
	}
	private static void downB(int t, int x, int y) {
		int ny = 0;
		if(t == 1) {
			for(int i = 0; i < 6; i++) {
				if(blue[x][i] == 0) ny = i;
				else break;
			}
			blue[x][ny] = 1;
		}
		else if(t == 2) {
			for(int i = 0; i < 5; i++) {
				if(blue[x][i] == 0 && blue[x][i + 1] == 0) ny = i;
				else break;
			}
			blue[x][ny] = blue[x][ny + 1] = 1;
		}
		else {
			for(int i = 0; i < 6; i++) {
				if(blue[x][i] == 0 && blue[x + 1][i] == 0) ny = i;
				else break;
			}
			blue[x][ny] = blue[x + 1][ny] = 1;
		}
	}
	private static void downG(int t, int x, int y) {
		int nx = 0;
		if(t == 1) {
			for(int i = 0; i < 6; i++) {
				if(green[i][y] == 0) nx = i;
				else break;
			}
			green[nx][y] = 1;
		}
		else if(t == 2) {
			for(int i = 0; i < 6; i++) {
				if(green[i][y] == 0 && green[i][y + 1] == 0) nx = i;
				else break;
			}
			green[nx][y] = green[nx][y + 1] = 1;
		}
		else {
			for(int i = 0; i < 5; i++) {
				if(green[i][y] == 0 && green[i + 1][y] == 0) nx = i;
				else break;
			}
			green[nx][y] = green[nx + 1][y] = 1;
		}
	}
}