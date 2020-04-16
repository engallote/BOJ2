import java.util.*;

public class Main {
	static int N, M;
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, -1, 0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0){
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new char[N][M];
			chk = new boolean[N][M];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			
			//rule 2 check
			if(!isWaterOk()){
				System.out.println("NO");
				continue;
			}
			
			//rule 1 check
			if(!isIslandOk()){
				System.out.println("NO");
				continue;
			}
			boolean flag = true;
			
			for(int i = 0; i < N && flag; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] != '#' && !chk[i][j]){
						flag = false;
						break;
					}
			
			if(!flag){
				System.out.println("NO");
				continue;
			}
			
			//rule 3 check
			if(!isIslandOk2()){
				System.out.println("NO");
				continue;
			}
			
			System.out.println("YES");
		}
	}
	private static boolean isIslandOk2() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				if(i + 1 < N && j + 1 < M && arr[i][j] == '#' && arr[i][j+1] == '#' && arr[i+1][j] == '#' && arr[i+1][j+1] == '#')
					return false;
			}
		
		return true;
	}
	private static boolean isIslandOk() {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		int num = 0, tmp = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] >= '1' && arr[i][j] <= '9' && !chk[i][j]){
					num = arr[i][j] - '0';
					tmp = bfs(i, j);
					if(num != tmp) return false;
				}
		return true;
	}
	private static int bfs(int x, int y) {
		int cnt = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		while(!q.isEmpty()){
			Pair p = q.poll();
			++cnt;
			
			for(int i = 0; i < 4; i++){
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] == '#')
					continue;
				if(arr[nx][ny] >= '1' && arr[nx][ny] <= '9') return -1000000;
				chk[nx][ny] = true;
				q.offer(new Pair(nx, ny));
			}
		}
		return cnt;
	}
	private static boolean isWaterOk() {
		int water = 0;
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == '#' && !chk[i][j]){
					chk[i][j] = true;
					dfs(i, j);
					++water;
				}
		
		if(water > 1) return false;
		else return true;
	}
	private static void dfs(int x, int y) {
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] != '#') 
				continue;
			chk[nx][ny] = true;
			dfs(nx, ny);
		}
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}