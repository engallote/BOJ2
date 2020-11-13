import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int L = sc.nextInt();
		int R = sc.nextInt();
		map = new char[N][M];
		int x = 0, y = 0;
		for(int i = 0; i < N; i++) {
			map[i] = sc.next().toCharArray();
			for(int j = 0; j < M; j++) {
				if(map[i][j] == '2') {
					x = i;
					y = j;
				}
			}
		}
		
		bfs(x, y, L, R);
	}
	private static void bfs(int x, int y, int l, int r) {
		int cnt = 0;
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, l, r));
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				++cnt;
				
				for(int i = p.x + 1; i < N; i++) {
					if(map[i][p.y] == '1') break;
					if(map[i][p.y] == '2') continue;
					map[i][p.y] = '2';
					q.offer(new Pair(i, p.y, p.l, p.r));
				}
				for(int i = p.x - 1; i >= 0; i--) {
					if(map[i][p.y] == '1') break;
					if(map[i][p.y] == '2') continue;
					map[i][p.y] = '2';
					q.offer(new Pair(i, p.y, p.l, p.r));
				}
				
				if(p.l > 0 && p.y - 1 >= 0 && map[p.x][p.y - 1] == '0') {
					map[p.x][p.y - 1] = '2';
					q.offer(new Pair(p.x, p.y - 1, p.l - 1, p.r));
				}
				if(p.r > 0 && p.y + 1 < M && map[p.x][p.y + 1] == '0') {
					map[p.x][p.y + 1] = '2';
					q.offer(new Pair(p.x, p.y + 1, p.l, p.r - 1));
				}
			}
		}
		
		System.out.println(cnt);
	}
}
class Pair{
	int x, y, l, r;
	Pair(int x, int y, int l, int r){
		this.x = x;
		this.y = y;
		this.l = l;
		this.r = r;
	}
}