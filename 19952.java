import java.util.*;

public class Main {
	static int N, M, O, F, sx, sy, ex, ey;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] mp;
	static boolean[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			N = sc.nextInt();
			M = sc.nextInt();
			O = sc.nextInt();//장애물 개수
			F = sc.nextInt();//초기 힘
			sx = sc.nextInt() - 1;
			sy = sc.nextInt() - 1;
			ex = sc.nextInt() - 1;
			ey = sc.nextInt() - 1;
			
			mp = new int[N][M];
			chk = new boolean[N][M];
			
			
			for(int i = 0; i < O; i++) {
				int x = sc.nextInt() - 1;
				int y = sc.nextInt() - 1;
				int l = sc.nextInt();
				
				mp[x][y] = l;
			}
			
			
			bfs();
		}
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy, F));
		chk[sx][sy] = true;
		int size;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == ex && p.y == ey) {
					System.out.println("잘했어!!");
					return;
				}
				if(p.p <= 0) continue;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
					
					if(mp[p.x][p.y] >= mp[nx][ny] && p.p - 1 >= 0) {
						chk[nx][ny] = true;
						q.offer(new Pair(nx, ny, p.p - 1));
					}
					else {
						int sub = mp[nx][ny] - mp[p.x][p.y];
						if(p.p >= sub) {
							chk[nx][ny] = true;
							q.offer(new Pair(nx, ny, p.p - 1));
						}
					}
				}
			}
		}
		
		System.out.println("인성 문제있어??");
	}
}
class Pair{
	int x, y, p;
	Pair(int x, int y, int p) {
		this.x = x;
		this.y = y;
		this.p = p;
	}
}