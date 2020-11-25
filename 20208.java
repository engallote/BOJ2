import java.util.*;

public class Main {
	static int N, M, H;
	static int[][] arr, milk;
	static boolean[][][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		H = sc.nextInt();
		arr = new int[N][N];
		milk = new int[N][N];
		chk = new boolean[N][N][1<<11];
		int x = 0, y = 0, idx = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 1) {
					x = i;
					y = j;
				}
				else if(arr[i][j] == 2) {
					milk[i][j] = idx;
					++idx;
				}
			}
		
		bfs(x, y);
	}
	private static void bfs(int x, int y) {
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y, M, 0, 0));
		chk[x][y][0] = true;
		
		int size, res = 0;
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(returnHome(p.x, p.y, x, y) <= p.hp) res = Math.max(res, p.cnt);
				if(p.hp == 0) continue;
				
				for(int i = 0; i < 4; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || (arr[nx][ny] == 0 && chk[nx][ny][p.chk])) continue;
					if(arr[nx][ny] == 0) {
						chk[nx][ny][p.chk] = true;
						q.offer(new Pair(nx, ny, p.hp - 1, p.cnt, p.chk));
					}
					if(arr[nx][ny] == 2 && (p.chk&1<<milk[nx][ny]) == 0) {
						chk[nx][ny][p.chk|(1<<milk[nx][ny])] = true;
						q.offer(new Pair(nx, ny, p.hp - 1 + H, p.cnt + 1, p.chk|(1<<milk[nx][ny])));
					}
				}
			}
		}
		
		System.out.println(res);
	}
	private static int returnHome(int x, int y, int x2, int y2) {
		return Math.abs(x - x2) + Math.abs(y - y2);
	}
}
class Pair {
	int x, y, hp, cnt, chk;
	Pair(int x, int y, int hp, int cnt, int chk){
		this.x = x;
		this.y = y;
		this.hp = hp;
		this.cnt = cnt;
		this.chk = chk;
	}
}