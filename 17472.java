import java.util.*;

public class Main {
	static int N, M, res, len;
	static int[][] arr, chk, bridge;
	static boolean[] v;
	static ArrayList<Pair> aly = new ArrayList<>();
	static int[] dx = {1, 0, -1, 0}, dy = {0, 1, 0, -1};
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new int[N][M];
		chk = new int[N][M];
		int idx = 1, INF = 10000000;
		res = Integer.MAX_VALUE;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				arr[i][j] = sc.nextInt();
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 1 && chk[i][j] == 0)
				{
					dfs(i, j, idx);
					++idx;
				}
		len = idx;
		bridge = new int[len][len];
		
		for(int i = 0; i < idx; i++)
			Arrays.fill(bridge[i], INF);
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < M; j++)
				if(arr[i][j] == 1)
					find(i, j);
				
		for(int i = 1; i < len; i++)
			for(int j = 1; j < len; j++)
				if(bridge[i][j] != INF) aly.add(new Pair(i, j, bridge[i][j]));
		v = new boolean[aly.size()];
		Collections.sort(aly);
		solve(0);
		if(res == Integer.MAX_VALUE) res = -1;
		System.out.println(res);
	}
	private static void solve(int idx) {
		if(idx == aly.size())
		{
			boolean[][] visit = new boolean[len][len];
			boolean[] visit2 = new boolean[len];
			Queue<Integer> q = new LinkedList<Integer>();
			int all = 0, sum = 0;
			for(int i = 0; i < aly.size(); i++)
			{
				if(!v[i]) continue;
				sum += aly.get(i).cost;
				visit[aly.get(i).a][aly.get(i).b] = visit[aly.get(i).b][aly.get(i).a] = true;
			}
			q.offer(1);
			visit2[1] = true;
			while(!q.isEmpty())
			{
				int x = q.poll();
				++all;
				
				for(int i = 1; i < len; i++)
					if(visit[x][i] && !visit2[i])
					{
						visit2[i] = true;
						q.offer(i);
					}
			}
			
			if(all == len - 1)
				res = Math.min(res, sum);
			
			return;
		}
		v[idx] = true;
		solve(idx + 1);
		v[idx] = false;
		solve(idx + 1);
	}
	private static void find(int x, int y) {
		int time = 0;
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			time = 0;
			while(nx >= 0 && ny >= 0 && nx < N && ny < M)
			{
				if(arr[nx][ny] == 1)
				{
					if(chk[nx][ny] != chk[x][y])
					{
						if(time == 1) break;
						bridge[chk[x][y]][chk[nx][ny]] = Math.min(bridge[chk[x][y]][chk[nx][ny]], time);
						bridge[chk[nx][ny]][chk[x][y]] = bridge[chk[nx][ny]][chk[x][y]];
					}
					break;
				}
				nx += dx[i];
				ny += dy[i];
				++time;
			}
		}
	}
	private static void dfs(int x, int y, int idx) {
		chk[x][y] = idx;
		
		for(int i = 0; i < 4; i++)
		{
			int nx = x + dx[i], ny = y + dy[i];
			if(nx < 0 || ny < 0 || nx >= N || ny >= M || arr[nx][ny] == 0 || chk[nx][ny] != 0)
				continue;
			dfs(nx, ny, idx);
		}
	}
}
class Pair implements Comparable<Pair>{
	int a, b, cost;
	Pair(int a, int b, int cost)
	{
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : 1;
	}
}