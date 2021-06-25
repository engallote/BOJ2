import java.util.*;

public class Main {
	static int N, M;
	static double[][] arr;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new double[N][M];
    	map = new int[N][M];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++) {
    			int r = sc.nextInt();
    			int g = sc.nextInt();
    			int b = sc.nextInt();
    			arr[i][j] = (r + g + b) / 3.0;
    		}
    	
    	int T = sc.nextInt();
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++) {
    			if(arr[i][j] >= T) map[i][j] = 255;
    			else map[i][j] = 0;
    		}
    	
    	Queue<Pair> q = new LinkedList<Pair>();
    	int res = 0;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(map[i][j] == 255) {
    				q.offer(new Pair(i, j));
    				map[i][j] = 0;
    				bfs(q);
    				q.clear();
    				++res;
    			}
    	
    	System.out.println(res);
	}
	private static void bfs(Queue<Pair> q) {
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			for(int d = 0; d < 4; d++) {
				int nx = p.x + dx[d], ny = p.y + dy[d];
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] != 255) continue;
				
				map[nx][ny] = 0;
				q.offer(new Pair(nx, ny));
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