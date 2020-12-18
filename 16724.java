import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new char[N][M];
		chk = new int[N][M];
		
		for(int i = 0; i < N; i++)
			map[i] = sc.next().toCharArray();
		
		int cnt = 1, res = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				int tmp = dfs(i, j, cnt);
				if(tmp == cnt)
					++res;
				++cnt;
			}
		
		System.out.println(res);
	}
	private static int dfs(int x, int y, int cnt) {
		if(chk[x][y] != 0) return chk[x][y];
		chk[x][y] = cnt;
		
		if(map[x][y] == 'U') return chk[x][y] = dfs(x - 1, y, cnt);
		else if(map[x][y] == 'D') return chk[x][y] = dfs(x + 1, y, cnt);
		else if(map[x][y] == 'L') return chk[x][y] = dfs(x, y - 1, cnt);
		else return chk[x][y] = dfs(x, y + 1, cnt);
	}
}