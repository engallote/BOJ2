import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new int[N][M];
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			arr[i][j] = sc.nextInt();
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(arr[i][j] != 0) bfs(i, j);
    	
    	System.out.println(pq.peek().y);
	}
	private static void bfs(int x, int y) {
		int cnt = 0;
		Queue<Pair> q = new LinkedList<>();
		boolean[][] chk = new boolean[N][M];
		chk[x][y] = true;
		q.offer(new Pair(x, y));
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				pq.offer(new Pair(cnt, arr[x][y] + arr[p.x][p.y]));
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || chk[nx][ny])
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			++cnt;
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.x > this.x) return 1;
		else if(o.x == this.x) return Integer.compare(o.y, this.y);
		else return -1;
	}
}