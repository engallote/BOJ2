import java.util.*;

public class Main {
	static int N, M, K;
	static boolean flag;
	static char[][] arr;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		M = sc.nextInt() * 2 + 1;
		N = sc.nextInt() * 2 + 1;
		K = (int)(sc.nextDouble() * 2);
		
		arr = new char[N][M];
		for(int i = 0; i < N; i++)
			arr[i] = sc.next().toCharArray();
		
		int res = bfs(N - 1, K, 0);
		
		System.out.println(res);
	}
	private static int bfs(int n, int k, int w) {
		int x = n, y = k, sx = -1, sy = -1, res = 0;
		
		while(true){
			x += sx;
			y += sy;
			if(x == 0 || x == N - 1) sx *= -1;
			if(y == 0 || y == M - 1) sy *= -1;
			
			if(x >= n) break;
			
			if(arr[x][y] == 'B' || arr[x][y] == '.'){//블록 관통
				++res;
				dfs(x, y);
			}
			else if(arr[x][y] == '|'){//블록 경계선
				flag = false;
				dfs(x, y + sy);
				
				if(flag) 
					++res;
			}
			else if(arr[x][y] == '-'){//블록 경계선
				flag = false;
				dfs(x + sx, y);
				
				if(flag) 
					++res;
			}
		}
		
		return res;
	}
	private static void dfs(int x, int y) {
		if(arr[x][y] == 'B') flag = true;
		arr[x][y] = 'O';
		for(int i = 0; i < 4; i++){
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
			
			if(arr[nx][ny] == 'B' || arr[nx][ny] == '.')
				dfs(nx, ny);
		}
	}
}