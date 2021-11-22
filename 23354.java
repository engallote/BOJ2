import java.util.*;

public class Main {
	static int N, res;
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	static int[][] map, dp;
	static ArrayList<Pair> aly = new ArrayList<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	map = new int[N][N];
    	dp = new int[6][6];
    	int sx = 0, sy = 0;
    	res = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++) {
    			map[i][j] = sc.nextInt();
    			if(map[i][j] == -1) {
    				map[i][j] = 0;
    				sx = i;
    				sy = j;
    			}
    			else if(map[i][j] == 0) aly.add(new Pair(i, j));
    		}
    	
    	if(aly.size() == 0) {
    		System.out.println(0);
    		return;
    	}
    	
    	for(int i = 0; i < 6; i++) {
    		Arrays.fill(dp[i], 100000000);
    		dp[i][i] = 0;
    	}
    	
    	for(int i = 0; i < aly.size(); i++) {
    		makeDistFirst(i, new Pair(sx, sy));
    		for(int j = i + 1; j < aly.size(); j++)
    			makeDist(i, j);
    	}
    	
    	ArrayList<Integer> path = new ArrayList<>();
    	solve(0, 0, sx, sy, path);
    	
    	System.out.println(res);
	}
	private static void makeDistFirst(int s, Pair e) {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		int[][] chk = new int[N][N];
		for(int i = 0; i < N; i++) Arrays.fill(chk[i], Integer.MAX_VALUE);
		chk[aly.get(s).x][aly.get(s).y] = 0;
		q.offer(new Pair(aly.get(s).x, aly.get(s).y, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(p.x == e.x && p.y == e.y) break;
			if(chk[p.x][p.y] > p.cost) continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] <= chk[p.x][p.y] + map[nx][ny]) continue;
				chk[nx][ny] = chk[p.x][p.y] + map[nx][ny];
				q.offer(new Pair(nx, ny, chk[nx][ny]));
			}
		}
		
		dp[s][5] = dp[5][s] = Math.min(dp[s][5], chk[e.x][e.y]);
	}
	private static void makeDist(int s, int e) {
		PriorityQueue<Pair> q = new PriorityQueue<Pair>();
		int[][] chk = new int[N][N];
		for(int i = 0; i < N; i++) Arrays.fill(chk[i], Integer.MAX_VALUE);
		chk[aly.get(s).x][aly.get(s).y] = 0;
		q.offer(new Pair(aly.get(s).x, aly.get(s).y, 0));
		
		while(!q.isEmpty()) {
			Pair p = q.poll();
			
			if(p.x == aly.get(e).x && p.y == aly.get(e).y) break;
			if(chk[p.x][p.y] > p.cost) continue;
			
			for(int i = 0; i < 4; i++) {
				int nx = p.x + dx[i], ny = p.y + dy[i];
				if(nx < 0 || ny < 0 || nx >= N || ny >= N || chk[nx][ny] <= chk[p.x][p.y] + map[nx][ny]) continue;
				chk[nx][ny] = chk[p.x][p.y] + map[nx][ny];
				q.offer(new Pair(nx, ny, chk[nx][ny]));
			}
		}
		
		dp[s][e] = dp[e][s] = Math.min(dp[s][e], chk[aly.get(e).x][aly.get(e).y]);
	}
	private static void solve(int cnt, int chk, int sx, int sy, ArrayList<Integer> path) {
		if(cnt == aly.size()) {
			findDist(sx, sy, path);
			return;
		}
		
		for(int i = 0; i < aly.size(); i++)
			if((chk&(1<<i)) == 0) {
				path.add(i);
				solve(cnt + 1, chk | (1<<i), sx, sy, path);
				path.remove(path.size() - 1);
			}
	}
	private static void findDist(int sx, int sy, ArrayList<Integer> path) {
		int sum = 0;
		
		//중대에서 1번 탈영병 잡으러
		sum += dp[5][path.get(0)];
		
		for(int i = 1; i < path.size(); i++) {
			//직전 탈영병에서 다음 탈영병한테 바로 가기
			int sum1 = dp[path.get(i - 1)][path.get(i)];
			
			//중간에 중대 들렀다가 가기
			int sum2 = dp[path.get(i - 1)][5] + dp[5][path.get(i)];
			
			sum += Math.min(sum1, sum2);
		}
		
		sum += dp[path.get(path.size() - 1)][5];
		res = Math.min(res, sum);
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cost;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
}