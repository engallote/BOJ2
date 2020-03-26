import java.util.*;

public class Main {
	static int N, M, res, cnt;
	static int[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args){
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt();
		N = sc.nextInt();
		res = 0;
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		dfs(3, 0);
		System.out.println(res);
	}
	private static void dfs(int count, int sum) {
		res = Math.max(res, sum);
		if(count == 0) return;
		int[][] tmp = new int[N][M];
		
		copyArr(tmp);
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] != 0){
					cnt = 0;
					findNum(i, j, arr[i][j]);
					down();
					dfs(count - 1, sum + (cnt * cnt));
					reArr(tmp);
				}
	}
	private static void reArr(int[][] tmp) {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = tmp[i][j];
	}
	private static void down() {
		for(int i = N - 1; i > 0; i--)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 0){
					int nx = i - 1;
					while(nx >= 0){
						if(arr[nx][j] != 0){
							arr[i][j] = arr[nx][j];
							arr[nx][j] = 0;
							break;
						}
						--nx;
					}
				}
	}
	private static void findNum(int x, int y, int k) {
		++cnt;
		arr[x][y] = 0;
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] != k) continue;
			findNum(nx, ny, k);
		}
	}
	private static void copyArr(int[][] tmp) {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				tmp[i][j] = arr[i][j];
	}
}