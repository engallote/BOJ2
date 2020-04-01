import java.util.*;

public class Main {
	static int N, T;
	static int[][] arr, chk;
	static int[] dx = {1, 0, -1, 0, 3, 0, -3, 0, 1, 1, -1, -1, 2, 2, -2, -2}, dy = {0, 1, 0, -1, 0, 3, 0, -3, 2, -2, 2, -2, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		T = sc.nextInt();
		arr = new int[N][N];
		chk = new int[N][N];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++){
				arr[i][j] = sc.nextInt();
				chk[i][j] = 1000000000;
			}
		
		chk[0][0] = 0;
		bfs();
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0, 0));
		int size = 0, res = Integer.MAX_VALUE;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(Math.abs(p.x - (N-1)) + Math.abs(p.y - (N-1)) <= 2){
					int dist = Math.abs(p.x - (N-1)) + Math.abs(p.y - (N-1));
					res = Math.min(res, p.cost + dist * T);
					continue;
				}
				
				for(int i = 0; i < 16; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) continue;
					
					int cost = p.cost + 3 * T + arr[nx][ny];
					if(chk[nx][ny] <= cost) continue;
					
					chk[nx][ny] = cost;
					q.offer(new Pair(nx, ny, cost));
				}
			}
		}
		
		System.out.println(res);
	}
}
class Pair{
	int x, y, cost;
	Pair(int x, int y, int cost){
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
}