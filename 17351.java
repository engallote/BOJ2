import java.util.*;

public class Main {
	static int N;
	static char[] ch = {'M', 'O', 'L', 'A'};
	static char[][] arr;
	static int[][][] dp;
	static int[] dx = {1, 0}, dy = {0, 1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new char[N][N];
		dp = new int[N][N][5];
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.next().toCharArray();
			for(int j = 0; j < N; j++)
				Arrays.fill(dp[i][j], -1);
		}
		
		int res = bfs();
		System.out.println(res);
	}
	private static int bfs() {
		int cnt = 0, size = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		if(arr[0][0] == 'M') q.offer(new Pair(0, 0, 1, 0));
		else q.offer(new Pair(0, 0, 0, 0));
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == N - 1){
					cnt = Math.max(cnt, p.cnt);
					continue;
				}
				
				for(int i = 0; i < 2; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N) 
						continue;
					
					if(ch[p.idx] == arr[nx][ny]){
						if(p.idx == 3){
							if(dp[nx][ny][0] < p.cnt + 1){
								dp[nx][ny][0] = p.cnt + 1;
								q.offer(new Pair(nx, ny, 0, p.cnt + 1));
							}
						}
						else{
							if(dp[nx][ny][p.idx + 1] < p.cnt){
								dp[nx][ny][p.idx + 1] = p.cnt;
								q.offer(new Pair(nx, ny, p.idx + 1, p.cnt));
							}
						}
					}
					if(dp[nx][ny][0] < p.cnt){
						dp[nx][ny][0] = p.cnt;
						q.offer(new Pair(nx, ny, 0, p.cnt));
					}
				}
			}
		}
		
		return cnt;
	}
}
class Pair{
	int x, y, idx, cnt;
	Pair(int x, int y, int idx, int cnt){
		this.x = x;
		this.y = y;
		this.idx = idx;
		this.cnt = cnt;
	}
}