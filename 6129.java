import java.util.*;

public class Main {
	static int N;
	static char[][] map;
	static int[][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new char[N][N];
    	chk = new int[N][N][4];
    	int sx = 0, sy = 0;
    	
    	for(int i = 0; i < N; i++) {
    		map[i] = sc.next().toCharArray();
    		for(int j = 0; j < N; j++) {
    			if(map[i][j] == 'A') {
    				sx = i;
    				sy = j;
    			}
    			Arrays.fill(chk[i][j], Integer.MAX_VALUE);
    		}
    	}
    	
    	bfs(sx, sy);
	}
	private static void bfs(int sx, int sy) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < 4; i++) pq.offer(new Pair(sx, sy, i, 0));
		int res = Integer.MAX_VALUE;
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(map[p.x][p.y] == 'B') {
				res = Math.min(res, p.cnt);
				continue;
			}
			if(chk[p.x][p.y][p.d] <= p.cnt) continue;
			chk[p.x][p.y][p.d] = p.cnt;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] == 'x') continue;
				if(i == p.d) pq.offer(new Pair(nx, ny, p.d, p.cnt));
				else pq.offer(new Pair(nx, ny, i, p.cnt + 1));
			}
		}
		
		System.out.println(res);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, d, cnt;
	Pair(int x, int y, int d, int cnt){
		this.x = x;
		this.y = y;
		this.d = d;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cnt, o.cnt);
	}
}