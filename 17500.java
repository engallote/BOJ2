import java.util.*;

public class Main {
	static int N, M;
	static boolean flag;
	static char[][] map;
	static boolean[][] visit, chk;
	static int[]dx = {1, 0, -1 , 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = N * 4 + 1;
		N = N * 2 + 1;
		flag = false;
		map = new char[N][M];
		visit = new boolean[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++){
			Arrays.fill(map[i], ' ');
			if(i % 2 == 0){
				for(int j = 0; j < M; j+=4)
					map[i][j] = '+';
			}
			else{
				char[] ch = sc.next().toCharArray();
				int idx = 0;
				
				for(int j = 2; j < M; j+=4)
					map[i][j] = ch[idx++];
			}
		}
		chk[0][0] = true;
		solve(0, 0);
		if(!flag) System.out.println("no");
	}
	private static void solve(int x, int y) {
		if(flag) return;
		if(x == N - 1 && y == M - 1){
			if(find()){
				System.out.println("yes");
				flag = true;
				for(int i = 0; i < M + 2; i++) System.out.print("#");
				System.out.println();
				for(int i = 0; i < N; i++){
					System.out.print("#");
					System.out.print(new String(map[i]));
					System.out.println("#");
				}
				for(int i = 0; i < M + 2; i++) System.out.print("#");
				System.out.println();
			}
			return;
		}
		
		for(int i = 0 ; i < 4; i++){
			int nx = x + dx[i] * 2, ny = y + dy[i] * 4;
			if(!range(nx, ny) || chk[nx][ny]) continue;
			chk[nx][ny] = true;
			if(i == 0 || i == 2) map[x+dx[i]][y+dy[i]] = '|';
			else for(int k = 1; k < 4; k++) map[x+dx[i]*k][y+dy[i]*k] = '-';
			
			solve(nx, ny);
			
			chk[nx][ny] = false;
			if(i == 0 || i == 2) map[x+dx[i]][y+dy[i]] = ' ';
			else for(int k = 1; k < 4; k++) map[x+dx[i]*k][y+dy[i]*k] = ' ';
		}
	}
	private static boolean find() {
		for(int i = 0; i < N; i++)
			Arrays.fill(visit[i], false);
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(map[i][j] >= 'A' && map[i][j] <= 'Z' && !visit[i][j]){
					visit[i][j] = true;
					if(!bfs(i, j, map[i][j])) return false;
				}
		
		return true;
	}
	private static boolean bfs(int x, int y, char c) {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i] * 2;
					if(!range(nx, ny) || visit[nx][ny] || map[nx][ny] == '-' || map[nx][ny] == '|') 
						continue;
					nx += dx[i];
					ny += dy[i] * 2;
					if(!range(nx, ny) || visit[nx][ny] || map[nx][ny] == '+') continue;
					visit[nx][ny] = true;
					if(map[nx][ny] == '.' || map[nx][ny] == c) q.offer(new Pair(nx, ny));
					else return false;
				}
			}
		}
		return true;
	}
	private static boolean range(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}