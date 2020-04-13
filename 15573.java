import java.util.*;

public class Main {
	static int N, M, K;
	static int[][] arr;
	static boolean[][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static ArrayList<Pair> aly = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new int[N][M];
		chk = new boolean[N][M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				if(j == 0 || j == M - 1 || i == 0) aly.add(new Pair(i, j));
			}
		
		int l = 1, r = 1000000, mid, res = r;
		while(l <= r){
			mid = (l + r) / 2;
			
			int cnt = find(mid);
			
			if(cnt >= K){
				res = Math.min(res, mid);
				r = mid - 1;
			}
			else l = mid + 1;
			
			re();
		}
		
		System.out.println(res);
	}
	private static void re() {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
	}
	private static int find(int d) {
		int size = 0, cnt = 0;
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(Pair next : aly)
			if(arr[next.x][next.y] <= d){
				chk[next.x][next.y] = true;
				q.offer(next);
			}
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(arr[p.x][p.y] > d) continue;
				
				++cnt;
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || chk[nx][ny] || arr[nx][ny] > d) 
						continue;
					
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
		}
		
		return cnt;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}