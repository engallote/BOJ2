import java.util.*;

public class Main {
	static int N, M, idx;
	static char[][] map;
	static int[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static PriorityQueue<Pair> pq;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	map = new char[N][M];
    	chk = new int[N][M];
    	pq = new PriorityQueue<>();
    	
    	for(int i = 0; i < N; i++)
    		map[i] = sc.next().toCharArray();
    	
    	idx = 1;
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < M; j++)
    			if(map[i][j] == '1' && chk[i][j] == 0) {
    				bfs(i, j, chk, 1);
    				++idx;
    			}
    	    	   	
    	idx = 1;
    	int[][] arr = new int[N][M];
    	
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
    		bfs(p.x, p.y, arr, 2);
    		++idx;
    	}
    	
    	for(int i = 0; i < N; i++) {
    		for(int j = 0; j < M; j++)
    			System.out.print(arr[i][j]);
    		System.out.println();
    	}
	}
	private static void bfs(int x, int y, int[][] arr, int k) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		arr[x][y] = idx;
		int num = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			num += size;
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '0' || arr[nx][ny] != 0)
						continue;
					
					arr[nx][ny] = idx;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		if(k == 1) pq.offer(new Pair(x, y, num));
	}
}
class Pair implements Comparable<Pair> {
	int x, y, num;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int num) {
		this.x = x;
		this.y = y;
		this.num = num;
	}

	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.num, o.num);
	}
}