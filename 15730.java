import java.util.*;

public class Main {
	static int N, M, res = 0;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int max = 0;
		arr = new int[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				max = Math.max(max, arr[i][j]);
			}
		
		for(int h = 0; h <= max; h++){
			refresh();
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] == h && !chk[i][j])
						bfs(i, j, h);
		}
		System.out.println(res);
	}
	private static void refresh() {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
	}
	private static void bfs(int x, int y, int k) {
		Queue<Pair> q = new LinkedList<Pair>(), tmp = new LinkedList<Pair>();
		chk[x][y] = true;
		q.offer(new Pair(x, y));
		int h = Integer.MAX_VALUE;
		boolean end = false;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			tmp.offer(p);
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M){
					end = true;
					continue;
				}
				if(chk[nx][ny]) continue;
				
				if(arr[nx][ny] == k){
					chk[nx][ny] = true;
					if(nx == 0 || ny == 0 || nx == N - 1 || ny == M - 1) end = true;
					q.offer(new Pair(nx, ny));
				}
				else h = Math.min(h, arr[nx][ny]);
			}
		}
		
		if(end) return;
		
		if(h > k){
			while(!tmp.isEmpty()){
				res += h - k;
				arr[tmp.peek().x][tmp.poll().y] = h;
			}
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}