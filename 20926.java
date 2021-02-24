import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		map = new char[N][M];
		chk = new int[N][M];
		int x = 0, y = 0;
		
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			Arrays.fill(chk[i], Integer.MAX_VALUE);
			for(int j = 0; j < M; j++)
				if(map[i][j] == 'T') {
					x = i;
					y = j;
				}
		}
		
		bfs(x, y);
	}
	private static void bfs(int x, int y) {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(x, y, 0));
		chk[x][y] = 0;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(map[p.x][p.y] == 'E') {
				System.out.println(p.cnt);
				return;
			}
			if(chk[p.x][p.y] > p.cnt) continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'R' || map[nx][ny] == 'H') 
					continue;
				int num = 0;
				while(nx >= 0 && ny >= 0 && nx < N && ny < M) {
					if(map[nx][ny] == 'E') break;
					num += map[nx][ny] -'0';
					nx += dx[i];
					ny += dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == 'H') {
						num = -1;
						break;
					}
					else if(map[nx][ny] == 'R') {
						nx -= dx[i];
						ny -= dy[i];
						break;
					}
				}
				
				if(num != -1 && chk[nx][ny] > p.cnt + num) {
					chk[nx][ny] = p.cnt + num;
					q.offer(new Pair(nx, ny, chk[nx][ny]));
				}
			}
		}
		
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	Pair(int x, int y, int cnt){
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cnt, o.cnt);
	}
}