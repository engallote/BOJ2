import java.util.*;

public class Main {
	static int N, M;
	static int[][] chk;
	static Pair[] arr;
	static int[] dx = {1, 1, 2, 2, -1, -1, -2, -2}, dy = {2, -2, 1, -1, 2, -2, 1, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	int sx = sc.nextInt();
    	int sy = sc.nextInt();
    	chk = new int[N + 1][N + 1];
    	arr = new Pair[M];
    	
    	for(int i = 1; i <= N; i++)
    		Arrays.fill(chk[i], Integer.MAX_VALUE);
    	
    	for(int i = 0; i < M; i++) {
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		arr[i] = new Pair(x, y); 
    	}
    	
    	bfs(sx, sy);
    	
    	for(int i = 0; i < M; i++)
    		System.out.print(chk[arr[i].x][arr[i].y] + " ");
	}
	private static void bfs(int sx, int sy) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(sx, sy));
		chk[sx][sy] = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 8; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 1 || ny < 1 || nx > N || ny > N || chk[nx][ny] <= chk[p.x][p.y] + 1) 
						continue;
					chk[nx][ny] = chk[p.x][p.y] + 1;
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