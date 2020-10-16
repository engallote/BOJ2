import java.util.*;

public class Main {
	static int N, M;
	static int[][] map, chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		chk = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				chk[i][j] = 1000000000;
			}
		
		if(map[0][0] == -1 || map[N-1][M-1] == -1) {
			System.out.println(-1);
			return;
		}
		
		bfs();
	}
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(0, 0, map[0][0]));
		chk[0][0] = map[0][0];
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.x == N - 1 && p.y == M - 1) {
				System.out.println(p.cnt);
				return;
			}
			if(chk[p.x][p.y] < p.cnt) continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1) continue;
				if(chk[nx][ny] > p.cnt + map[nx][ny]) {
					chk[nx][ny] = p.cnt + map[nx][ny];
					pq.offer(new Pair(nx, ny, p.cnt + map[nx][ny]));
				}
			}
		}
		
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	Pair(int x, int y, int cnt) {
		this.x = x;
		this.y = y;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cnt > this.cnt ? -1 : (o.cnt == this.cnt ? 0 : 1);
	}
}