import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] map, chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		chk = new int[N][M];
		res = 0;
		
		for(int i = 0; i < N; i++) {
			char[] ch = sc.next().toCharArray();
			for(int j = 0; j < M; j++)
				map[i][j] = ch[j] - '0';
		}
		
		solve(0, 0, 0, 1);
		
		System.out.println(res);
	}
	private static void solve(int x, int y, int sum, int cnt) {
		if(x >= N) {
			res = Math.max(res, sum);
			return;
		}
		if(y >= M) {
			solve(x + 1, 0, sum, cnt);
			return;
		}
		if(chk[x][y] != 0) {
			solve(x, y + 1, sum, cnt);
			return;
		}
		
		chk[x][y] = cnt;
		int tmp = map[x][y];
		solve(x, y + 1, sum + tmp, cnt + 1);
		
		//가로
		int nx = 0, ny = 0;
		for(int i = 1; i < M - y && chk[x][y+i] == 0; i++) {
			tmp *= 10;
			tmp += map[x][y+i];
			chk[x][y+i] = cnt;
			ny = y + i;
			solve(x, y + 1 + i, sum + tmp, cnt + 1);
		}
		for(int i = y; i <= ny; i++)
			chk[x][i] = 0;
		
		tmp = map[x][y];
		//세로
		for(int i = 1; i < N - x && chk[x+i][y] == 0; i++) {
			tmp *= 10;
			tmp += map[x+i][y];
			nx = x + i;
			chk[x+i][y] = cnt;
			solve(x, y + 1, sum + tmp, cnt + 1);
		}
		for(int i = x; i <= nx; i++)
			chk[i][y] = 0;
		chk[x][y] = 0;
	}
}