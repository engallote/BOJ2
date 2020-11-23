import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
	static int[][][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N][N];
		chk = new int[N][N][4][50];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				for(int k = 0; k < 4; k++)
					Arrays.fill(chk[i][j][k], Integer.MAX_VALUE);
			}
		
		bfs();
	}
	private static void bfs() {
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(0, 0, 0, 0, 0));
		Arrays.fill(chk[0][0][0], 0);
		Arrays.fill(chk[0][0][1], 0);
		Arrays.fill(chk[0][0][2], 0);
		Arrays.fill(chk[0][0][3], 0);
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(p.x == N - 1 && p.y == N - 1) {
				System.out.println(p.w);
				return;
			}
			if(arr[N - 1][N - 1] != 0 && p.w >= arr[N - 1][N - 1]) continue;
			
			for(int i = 0; i < 4; i++) {
				int jump = 1;
				if(i == p.d) jump = p.cnt + 1;
				int nx = p.x + dx[i] * jump, ny = p.y + dy[i] * jump;
				
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == p.w + 1) continue;
				
				boolean flag = true;
				for(int j = 1; j <= jump; j++) {
					int nnx = p.x + dx[i] * j, nny = p.y + dy[i] * j;
					if(nnx < 0 || nny < 0 || nnx >= N || nny >= N || (arr[nnx][nny] != 0 && arr[nnx][nny] <= p.w)) {
						flag = false;
						break;
					}
				}
				
				if(!flag || chk[nx][ny][i][jump] <= p.w + 1) continue;
				
				chk[nx][ny][i][jump] = p.w + 1;
				if(p.d != i) q.offer(new Pair(nx, ny, p.w + 1, i, 1));
				else q.offer(new Pair(nx, ny, p.w + 1, p.d, p.cnt + 1));
			}
		}
		
		System.out.println("Fired");
	}
}
class Pair implements Comparable<Pair>{
	int x, y, w, d, cnt;
	Pair(int x, int y, int w, int d, int cnt){
		this.x = x;
		this.y = y;
		this.w = w;
		this.d = d;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.w, o.w);
	}
}