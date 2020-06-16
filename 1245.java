import java.util.*;

public class Main {
	static int N, M, h, cnt;
	static int[][] arr, chk;
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		chk = new int[N][M];
		int max = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				max = Math.max(max, arr[i][j]);
			}
		
		cnt = 0;
		
		for(int k = max; k >= 1; k--){
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] == k && chk[i][j] == 0){
						++cnt;
						bfs(i, j);
					}
		}
		
		System.out.println(cnt);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = 1;
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 8; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[p.x][p.y] < arr[nx][ny] || arr[nx][ny] == 0 || chk[nx][ny] == 1)
						continue;
					chk[nx][ny] = 1;
					q.offer(new Pair(nx, ny));
				}
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