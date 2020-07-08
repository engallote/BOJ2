import java.util.*;

public class Main {
	static int N, M, F;
	static int[][] arr;
	static boolean[][] chk;
	static Pair[] s, e;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		F = sc.nextInt();
		arr = new int[N][N];
		chk = new boolean[N][N];
		s = new Pair[M];
		e = new Pair[M];
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++)
				arr[i][j] = sc.nextInt();
		
		int x = sc.nextInt() - 1;
		int y = sc.nextInt() - 1;
		
		for(int i = 0; i < M; i++){
			s[i] = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);
			e[i] = new Pair(sc.nextInt() - 1, sc.nextInt() - 1);
		}
		
		int cnt = 0;
		while(cnt < M){
			int dist = Integer.MAX_VALUE, idx = 0;
			for(int i = 0; i < M; i++){
				if(s[i].x == -1) continue;//이미 갔다 왔음
				int min = findDist(s[i], x, y);
				
				if(min < dist){
					dist = min;
					idx = i;
				}
				else if(min == dist && s[idx].x > s[i].x) idx = i;
				else if(min == dist && s[idx].x == s[i].x && s[idx].y > s[i].y) idx = i;
			}
			
			if(F >= dist){//연료 충분하다
				F -= dist;
				int goEnd = findDist(e[idx], s[idx].x, s[idx].y);
				
				if(F >= goEnd){
					F -= goEnd;
					F += goEnd * 2;
					x = e[idx].x;
					y = e[idx].y;
					s[idx].x = -1;
				}
				else{
					System.out.println(-1);
					return;
				}
			}
			else{
				System.out.println(-1);
				return;
			}
			++cnt;
		}
		
		System.out.println(F);
	}
	private static int findDist(Pair pair, int x, int y) {
		for(int i = 0; i < N; i++)
			Arrays.fill(chk[i], false);
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(x, y));
		chk[x][y] = true;
		int size, time = 0;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.x == pair.x && p.y == pair.y) return time;
				
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= N || arr[nx][ny] == 1 || chk[nx][ny]) 
						continue;
					
					chk[nx][ny] = true;
					q.offer(new Pair(nx, ny));
				}
			}
			++time;
		}
		
		return Integer.MAX_VALUE;
	}
}
class Pair{
	int x, y;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
}