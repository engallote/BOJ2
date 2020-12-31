import java.util.*;

public class Main {
	static int N, M, K;
	static char[][] map;
	static boolean[][][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		map = new char[N][M];
		chk = new boolean[N][M][K + 1][K + 1];
		
		for(int i = 0; i < N; i++)
			map[i] = sc.next().toCharArray();
		
		solve();
	}
	private static void solve() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(0, 0, 0, 0));
		chk[0][0][0][0] = true;
		int size;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1) {
					System.out.println("Yes");
					return;
				}
				
				int d = 0;
				if(map[p.x][p.y] == 'R') d = 3;
				else if(map[p.x][p.y] == 'D') d = 0;
				else if(map[p.x][p.y] == 'L') d = 1;
				else d = 2;
				
				if(range(p.x, p.y, d) && !chk[p.x + dx[d]][p.y + dy[d]][p.l][p.r]) {
					chk[p.x + dx[d]][p.y + dy[d]][p.l][p.r] = true;
					q.offer(new Pair(p.x + dx[d], p.y + dy[d], p.l, p.r));
				}
				if(p.l < K) {
					int nd = d - 1;
					if(nd < 0) nd = 4 + nd;
					
					if(range(p.x, p.y, nd) && !chk[p.x + dx[nd]][p.y + dy[nd]][p.l + 1][p.r]) {
						chk[p.x + dx[nd]][p.y + dy[nd]][p.l + 1][p.r] = true;
						q.offer(new Pair(p.x + dx[nd], p.y + dy[nd], p.l + 1, p.r));
					}
					if(range(p.x, p.y, nd) && !chk[p.x][p.y][p.l + 1][p.r]) {
						chk[p.x][p.y][p.l + 1][p.r] = true;
						q.offer(new Pair(p.x, p.y, p.l + 1, p.r));
					}
				}
				if(p.r < K) {
					int nd = d + 1;
					nd %= 4;
					
					if(range(p.x, p.y, nd) && !chk[p.x + dx[nd]][p.y + dy[nd]][p.l][p.r + 1]) {
						chk[p.x + dx[nd]][p.y + dy[nd]][p.l][p.r + 1] = true;
						q.offer(new Pair(p.x + dx[nd], p.y + dy[nd], p.l, p.r + 1));
					}
					if(range(p.x, p.y, nd) && !chk[p.x][p.y][p.l][p.r + 1]) {
						chk[p.x][p.y][p.l][p.r + 1] = true;
						q.offer(new Pair(p.x, p.y, p.l, p.r + 1));
					}
				}
			}
		}
		
		System.out.println("No");
	}
	private static boolean range(int x, int y, int d) {
		if(x + dx[d] >= 0 && y + dy[d] >= 0 && x + dx[d] < N && y + dy[d] < M) return true;
		return false;
	}
}
class Pair {
	int x, y, l, r;
	Pair(int x, int y, int l, int r) {
		this.x = x;
		this.y = y;
		this.l = l;
		this.r = r;
	}
}