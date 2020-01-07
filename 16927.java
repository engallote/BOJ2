import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int R = sc.nextInt();
		
		arr = new int[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		int cnt = 0, min = Math.min(N, M);
		while(cnt * 2 < min){
			int rot = R % (2 * (N + M - 4 * cnt) - 4);
			
			while(--rot >= 0)
				rotate(cnt, cnt, N-cnt-1, M-cnt-1);
			
			++cnt;
		}
		
		for(int i = 0; i < N; i++){
			for(int j = 0; j < M; j++)
				System.out.print(arr[i][j] + " ");
			System.out.println();
		}
	}
	private static void rotate(int sx, int sy, int ex, int ey) {
		int tmp = arr[sx][sy];
		
		for(int i = sy; i < ey; i++)
			arr[sx][i] = arr[sx][i+1];
		for(int i = sx; i < ex; i++)
			arr[i][ey] = arr[i+1][ey];
		for(int i = ey; i > sy; i--)
			arr[ex][i] = arr[ex][i-1];
		for(int i = ex; i > sx; i--)
			arr[i][sy] = arr[i-1][sy];
		
		arr[sx+1][sy] = tmp;
	}
}