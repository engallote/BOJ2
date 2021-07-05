import java.util.*;

public class Main {
	static int N, M;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static char[][] arr;
	static boolean[][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new char[N][M];
    	chk = new boolean[N][M];
    	
    	for(int i = 0; i < N; i++)
    		arr[i] = sc.next().toCharArray();
    	
    	int res = 0;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(arr[i][j] == 'L' && !chk[i][j]) {
    				bfs(i, j);
    				++res;
    			}
    	
    	System.out.println(res);
	}
	private static void bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] == 'W')
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
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