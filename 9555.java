import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static boolean[][] chk;
	static int[] num = new int[101];
	static int[] dx = {1, 0, -1, 0, 1, 1, -1, -1}, dy = {0, 1, 0, -1, 1, -1, 1, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0){
			N = sc.nextInt();
			M = sc.nextInt();
			arr = new int[N][M];
			chk = new boolean[N][M];
			int res = 0;
			Arrays.fill(num, 0);
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					arr[i][j] = sc.nextInt();
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(!chk[i][j] && arr[i][j] != -1 && num[arr[i][j]] == 0){
						if(bfs(i, j)){
							++res;
							++num[arr[i][j]];
						}
					}
			System.out.println(res);
		}
	}

	private static boolean bfs(int x, int y) {
		int num = arr[x][y], size = 0, cnt = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		
		while(!q.isEmpty()){
			size = q.size();
			
			while(--size >= 0){
				Pair p = q.poll();
				if(arr[p.x][p.y] == num) ++cnt;
				
				for(int i = 0; i < 8; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] != num) 
						continue;
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		if(cnt >= 2) return true;
		return false;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}