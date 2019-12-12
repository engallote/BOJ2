import java.util.*;

public class Main {
	static char[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int M = sc.nextInt();
			int N = sc.nextInt();
			if(N == 0 && M == 0) break;
			arr = new char[N][M];
			chk = new boolean[N][M];
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.next().toCharArray();
			
			for(int i = 0; i < N; i++)
				for(int j = 0; j < M; j++)
					if(arr[i][j] == 'S' && !chk[i][j])
						solve(i, j, N, M);
			
			for(int i = 0; i < N; i++)
				System.out.println(new String(arr[i]));
		}
	}
	private static void solve(int x, int y, int n, int m) {
		chk[x][y] = true;
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= n || ny >= m || chk[nx][ny] || arr[nx][ny] != 'T')
				continue;
			arr[nx][ny] = 'S';
			solve(nx, ny, n, m);
		}
	}
}