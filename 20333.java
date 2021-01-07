import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] > 1)
					pq.offer(new Pair(map[i][j], i, j));
			}
		
		int res = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(map[p.x][p.y] <= 1) continue;
			bfs(p.num, p.x, p.y);
			++res;
		}
		
		System.out.println(res);
	}
	private static void bfs(int num, int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(num, x, y));
		map[x][y] = -1;
		int size;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] > p.num || map[nx][ny] == 0) 
						continue;
					q.offer(new Pair(map[nx][ny], nx, ny));
					map[nx][ny] = 0;
				}
			}
		}
	}
}
class Pair implements Comparable<Pair> {
	int x, y, num;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(o.num, this.num);
	}
}