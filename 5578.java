import java.util.*;

public class Main {
	static int N, M, res;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		res = 0;
		arr = new int[N][M];
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) q.offer(new Pair(i, j));
			}
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			dfs(p.x, p.y, 0);
		}
		
		System.out.println(res);
	}
	private static void dfs(int x, int y, int cnt) {
		res = Math.max(res, cnt);
		
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0) continue;
			arr[nx][ny] = 0;
			dfs(nx, ny, cnt + 1);
			arr[nx][ny] = 1;
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