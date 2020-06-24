import java.util.*;

public class Main {
	static int N, M;
	static int[][] map;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		map = new int[N][M];
		int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				map[i][j] = sc.nextInt();
		
		int x = 0, y = 0, num = 1, d = 0;
		while(num <= N * 2 + M * 2){
			bfs(x, y, d);
			x += dx[d];
			y += dy[d];
			++num;
			if(x < 0 || y < 0 || x >= N || y >= M){
				x -= dx[d];
				y -= dy[d];
				++d;
			}
		}
	}
	private static void bfs(int sx, int sy, int d) {
		int x = sx, y = sy, num = 0;
		
		while(true){
			if(d == 0){
				if(range(x, y) && map[x][y] == 1){
					d = 1;
					--x;
					continue;
				}
				if(!range(x, y)){
					num = N + (N - x) + M;
					System.out.print(num + " ");
					return;
				}
				++y;
			}
			else if(d == 1){
				if(range(x, y) && map[x][y] == 1){
					d = 0;
					++y;
					continue;
				}
				if(!range(x, y)){
					num = 2 * N + M + (M - y);
					System.out.print(num + " ");
					return;
				}
				--x;
			}
			else if(d == 2){
				if(range(x, y) && map[x][y] == 1){
					d = 3;
					++x;
					continue;
				}
				if(!range(x, y)){
					num = x + 1;
					System.out.print(num + " ");
					return;
				}
				--y;
			}
			else{
				if(range(x, y) && map[x][y] == 1){
					d = 2;
					--y;
					continue;
				}
				if(!range(x, y)){
					num = N + y + 1;
					System.out.print(num + " ");
					return;
				}
				++x;
			}
		}
	}
	private static boolean range(int x, int y) {
		if(x < 0 || y < 0 || x >= N || y >= M) return false;
		return true;
	}
}