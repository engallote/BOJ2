import java.util.*;

public class Main {
	static int N, M, G, R, res;
	static int[][] arr;
	static int[][][] chk;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static ArrayList<Pair> aly = new ArrayList<>(), green = new ArrayList<>(), red = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		G = sc.nextInt();
		R = sc.nextInt();
		arr = new int[N][M];
		chk = new int[N][M][2];
		res = 0;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++){
				arr[i][j] = sc.nextInt();
				if(arr[i][j] == 2) aly.add(new Pair(i, j));
			}
		
		if(G == 0 || R == 0){
			System.out.println(0);
			return;
		}
		
		solve(0, 0, 0);
		System.out.println(res);
	}
	private static void solve(int idx, int g, int r) {
		if(g == G && r == R){
			fill();
			bfs();
			return;
		}
		if(idx == aly.size()) return;
		
		solve(idx + 1, g, r);
		
		green.add(aly.get(idx));
		solve(idx + 1, g + 1, r);
		green.remove(green.size()-1);
		
		red.add(aly.get(idx));
		solve(idx + 1, g, r + 1);
		red.remove(red.size()-1);
	}
	private static void fill() {
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		int size = 0, time = 1, count = 0;
		int[][] tmp = new int[N][M];
		
		for(Pair p : green){
			chk[p.x][p.y][0] = 0;
			q.offer(new Pair(p.x, p.y, 0));
		}
		for(Pair p : red){
			chk[p.x][p.y][1] = 0;
			q.offer(new Pair(p.x, p.y, 1));
		}
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				if(chk[p.x][p.y][p.k] == -1) continue;
				if(p.k == 0) tmp[p.x][p.y] = 1;
				else if(p.k == 1) tmp[p.x][p.y] = 2;
				for(int i = 0; i < 4; i++){
					int nx = p.x + dx[i], ny = p.y + dy[i];
					if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || chk[nx][ny][p.k] <= time) 
						continue;
					
					chk[nx][ny][p.k] = time;
					if(chk[nx][ny][(p.k + 1) % 2] == time){//meet
						chk[nx][ny][0] = chk[nx][ny][1] = -1;
						tmp[nx][ny] = 9;
						++count;
					}
					else q.offer(new Pair(nx, ny, p.k));
				}
			}
			++time;
		}
		
		res = Math.max(res, count);
	}
}
class Pair{
	int x, y, k;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int k){
		this.x = x;
		this.y = y;
		this.k = k;
	}
}