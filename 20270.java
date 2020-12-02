import java.util.*;

public class Main {
	static int N, M;
	static char[][] map;
	static int[][] food;
	static boolean[][] chk;
	static int[] dx = {1, 1, -1, -1, 0, 0}, dy = {1, -1, 1, -1, 2, -2};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			int d = sc.nextInt();
			N = 2 * d - 1;
			M = N + (N - 1);
			map = new char[N][M];
			food = new int[N][M];
			chk = new boolean[N][M];
			sc.nextLine();
			
			for(int i = 0; i < N; i++) {
				map[i] = sc.nextLine().toCharArray();
				for(int j = 0; j < M; j++)
					if(map[i][j] == ' ') map[i][j] = '.';
				Arrays.fill(food[i], -1);
			}
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if((map[i][j] == 'L' || map[i][j] == 'F') && !chk[i][j])
						findLand(i, j);
					
			for(int i = 0; i < N; i++)
				Arrays.fill(chk[i], false);
			
			int x = d - 1, y = M / 2;
			int res = bfs(x, y);
			
			System.out.println(res);
		}
	}
	private static void findLand(int x, int y) {
		Queue<Pair> q = new LinkedList<>(), tmp = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		
		int f = 0;
		while(!q.isEmpty()) {
			Pair p = q.poll();
			tmp.offer(p);
			
			if(map[p.x][p.y] == 'F') ++f;
			
			for(int i = 0; i < 6; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || map[nx][ny] == '.' || map[nx][ny] == 'W' || chk[nx][ny]) 
					continue;
				chk[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
		
		while(!tmp.isEmpty()) {
			Pair p = tmp.poll();
			
			food[p.x][p.y] = f;
		}
	}
	private static int bfs(int x, int y) {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int max = 0, size = 0;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(map[p.x][p.y] == 'L' || map[p.x][p.y] == 'F') {
					max = Math.max(max, food[p.x][p.y]);
					continue;
				}
				
				for(int i = 0; i < 6; i++) {
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || map[nx][ny] == '.') 
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		return max;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}