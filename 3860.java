import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int M = sc.nextInt();
			int N = sc.nextInt();
			
			if(N == 0 && M == 0) break;
			int[][] map = new int[N][M];
			ArrayList<Pair> arr = new ArrayList<>();
			int G = sc.nextInt();//¹¦ºñÀÇ °³¼ö
			while(--G >= 0) {
				int y = sc.nextInt();
				int x = sc.nextInt();
				map[x][y] = -1;
			}
			
			int E = sc.nextInt();//±Í½Å ±¸¸ÛÀÇ °³¼ö
			for(int i = 1; i <= E; i++) {
				int sy = sc.nextInt();
				int sx = sc.nextInt();
				int ey = sc.nextInt();
				int ex = sc.nextInt();
				int t = sc.nextInt();
				map[sx][sy] = 1;
				arr.add(new Pair(sx, sy, ex, ey, t));
			}
			
			int INF = 1000000000;
			int[][] dist = new int[N][M];
			int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++) {
					if(map[i][j] != 0 || (i == N - 1 && j == M - 1)) continue;
					for(int k = 0; k < 4; k++) {
						int nx = i + dx[k], ny = j + dy[k];
						if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == -1)
							continue;
						arr.add(new Pair(i, j, nx, ny, 1));
					}
				}
			
			for(int i = 0; i < N; i++)
				Arrays.fill(dist[i], INF);
			dist[0][0] = 0;
			
			boolean notEnd = false;
			loop:for(int t = 1; t <= N * M; t++) {
				for(Pair next : arr)
					if(dist[next.sx][next.sy] < INF && dist[next.ex][next.ey] > dist[next.sx][next.sy] + next.time) {
						dist[next.ex][next.ey] = dist[next.sx][next.sy] + next.time;
						if(t == N * M) {
							notEnd = true;
							break loop;
						}
					}
			}
			
			if(notEnd) System.out.println("Never");
			else System.out.println(dist[N-1][M-1] != INF ? dist[N-1][M-1] : "Impossible");
		}
	}
}
class Pair {
	int sx, sy, ex, ey, time;
	Pair(int sx, int sy, int ex, int ey, int time) {
		this.sx = sx;
		this.sy = sy;
		this.ex = ex;
		this.ey = ey;
		this.time = time;
	}
}