import java.util.*;

public class Main {
	static int N, K;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		K = sc.nextInt();
		map = new int[N][N];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		PriorityQueue<Pair> pq = new PriorityQueue<>(), tmp = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				map[i][j] = sc.nextInt();
				if(map[i][j] > 0) pq.offer(new Pair(map[i][j], i, j));
			}
		
		int S = sc.nextInt();
		int X = sc.nextInt() - 1;
		int Y = sc.nextInt() - 1;
		boolean flag = false;
		
		while(--S >= 0) {
			flag = true;
			while(!pq.isEmpty()) {
				Pair p = pq.poll();
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || map[nx][ny] != 0)
						continue;
					flag = false;
					map[nx][ny] = p.num;
					tmp.offer(new Pair(p.num, nx, ny));
				}
			}
			if(flag) break;
			pq.addAll(tmp);
		}
		
		System.out.println(map[X][Y]);
	}
}
class Pair implements Comparable<Pair> {
	int num, x, y;
	Pair(int num, int x, int y) {
		this.num = num;
		this.x = x;
		this.y = y;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return -1;
		else if(o.num == this.num) return 0;
		else return 1;
	}
}