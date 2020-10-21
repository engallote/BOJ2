import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			chk = new boolean[N][M];
			res = 0;
			int max = 0;
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++) {
					arr[i][j] = sc.nextInt();
					max = Math.max(max, arr[i][j]);
				}
			
			for(int k = 1; k < max; k++) {
				for(int i = 1; i < N - 1; i++)
					for(int j = 1; j < M - 1; j++)
						if(arr[i][j] == k && !chk[i][j])
							bfs(i, j, k);
				
				for(int i = 0; i < N; i++)
					Arrays.fill(chk[i], false);
			}
			
			System.out.println("Case #" + test_case + ": " + res);
		}
	}
	private static void bfs(int x, int y, int k) {
		chk[x][y] = true;
		Queue<Pair> q = new LinkedList<>(), tmp = new LinkedList<>();
		q.offer(new Pair(x, y));
		boolean flag = true;
		int h = 10000;
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			tmp.offer(p);
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny]) continue;
				if(arr[nx][ny] == k) {
					chk[nx][ny] = true;
					if(nx == 0 || ny == 0 || nx == N - 1 || ny == M - 1) flag = false;
					q.offer(new Pair(nx, ny));
				}
				else h = Math.min(h, arr[nx][ny]);
			}
		}
		
		if(flag && h != 10000 && h > k) {
			while(!tmp.isEmpty()) {
				Pair p = tmp.poll();
				arr[p.x][p.y] = h;
				res += h - k;
			}
		}
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}