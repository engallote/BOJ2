import java.util.*;

public class Main {
	static int N, M;
	static int[][] arr;
	static int[][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		chk = new int[N][M][2];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
			}
		
		chk[0][0][1] = chk[0][0][0] = arr[0][0];
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0, 1, arr[0][0]));
		
		int size = 0, res = Integer.MAX_VALUE;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == N - 1 && p.y == M - 1){
					res = Math.min(res, p.num);
					continue;
				}
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M) continue;
					if(p.k == 1){
						int nnx = nx + dx[i], nny = ny + dy[i];
						if(nnx >= 0 && nny >= 0 && nnx < N && nny < M && chk[nnx][nny][0] > Math.max(p.num, arr[nnx][nny])){
							chk[nnx][nny][0] = Math.max(p.num, arr[nnx][nny]);
							q.offer(new Pair(nnx, nny, 0, Math.max(p.num, arr[nnx][nny])));
						}
					}
					if(chk[nx][ny][p.k] > Math.max(p.num, arr[nx][ny])){
						chk[nx][ny][p.k] = Math.max(p.num, arr[nx][ny]);
						q.offer(new Pair(nx, ny, p.k, Math.max(p.num, arr[nx][ny])));
					}
				}
			}
		}
		
		System.out.println(res);
	}
}
class Pair{
	int x, y, num, k;
	Pair(int x, int y, int k, int num){
		this.x = x;
		this.y = y;
		this.k = k;
		this.num = num;
	}
}