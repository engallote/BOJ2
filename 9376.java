import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static Pair p1, p2;
	static int[][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			map = new char[N + 2][M + 2];
			chk = new int[3][N + 2][M + 2];
			p1 = new Pair(-1, 0);
			p2 = new Pair(-1, -1);
			
			for(int i = 0; i <= N + 1; i++) {
				Arrays.fill(map[i], '.');
				if(i == 0 || i == N + 1) continue;
				char[] ch = sc.next().toCharArray();
				for(int j = 1; j <= M; j++) {
					map[i][j] = ch[j - 1];
					if(map[i][j] == '$') {
						map[i][j] = '.';
						if(p1.x == -1) {
							p1.x = i;
							p1.y = j;
						}
						else {
							p2.x = i;
							p2.y = j;
						}
					}
				}
			}
			
			for(int i = 0; i < 3; i++)
				for(int j = 0; j <= N + 1; j++)
					Arrays.fill(chk[i][j], 100000000);
			
			go(new Pair(0, 0), 0);
			go(p1, 1);
			go(p2, 2);
			
			int res = Integer.MAX_VALUE;
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= M; j++)
					if(map[i][j] != '*') {
						if(map[i][j] == '.') res = Math.min(res, chk[0][i][j] + chk[1][i][j] + chk[2][i][j]);
						else res = Math.min(res, chk[0][i][j] + chk[1][i][j] + chk[2][i][j] - 2);
					}
			
			
			System.out.println(res);
		}
	}
	private static void go(Pair pair, int idx) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(pair.x, pair.y, 0));
		chk[idx][pair.x][pair.y] = 0;
		int size = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					
					if(nx < 0 || ny < 0 || nx >= N + 2 || ny >= M + 2 || map[nx][ny] == '*') continue;
					if(map[nx][ny] == '#') {
						if(chk[idx][nx][ny] > p.cnt + 1) {
							chk[idx][nx][ny] = p.cnt + 1;
							q.offer(new Pair(nx, ny, p.cnt + 1));
						}
					}
					else {
						if(chk[idx][nx][ny] > p.cnt) {
							chk[idx][nx][ny] = p.cnt;
							q.offer(new Pair(nx, ny, p.cnt));
						}
					}
				}
			}
		}
	}
}
class Pair {
	int x, y, cnt;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
}