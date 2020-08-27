import java.util.*;

public class Main {
	static int N, M, C;
	static long res;
	static ArrayList<Pair>[] arr;
	static ArrayList<Integer> market;
	static int[][] dist;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		C = sc.nextInt();
		res = Long.MAX_VALUE;
		arr = new ArrayList[N+1];
		market = new ArrayList<>();
		dist = new int[C][N+1];
		chk = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			chk[i] = -1;
		}
		
		for(int i = 0; i < C; i++){
			Arrays.fill(dist[i], Integer.MAX_VALUE);
			int num = sc.nextInt();
			market.add(num);
			chk[num] = i;
		}
		
		while(--M >= 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		for(int i = 0; i < C; i++)
			bfs(i, market.get(i));
		
		ArrayList<Integer> path = new ArrayList<>();
		dfs(0, 0, path);
		
		System.out.println(res);
	}
	private static void bfs(int idx, int start) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(start, 0));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(dist[idx][p.v] <= p.cost) continue;
			dist[idx][p.v] = p.cost;
			
			for(Pair next : arr[p.v])
				if(dist[idx][next.v] > p.cost + next.cost)
					pq.offer(new Pair(next.v, p.cost + next.cost));
		}
	}
	private static void dfs(int cnt, int visit, ArrayList<Integer> path) {
		if(cnt == C){
			cal(path);
			return;
		}
		
		for(int i = 0; i < C; i++)
			if((visit&(1<<i)) == 0){
				path.add(market.get(i));
				dfs(cnt + 1, visit|(1<<i), path);
				path.remove(path.size()-1);
			}
	}
	private static void cal(ArrayList<Integer> path) {
		int sum = 0;
		for(int i = 0; i < path.size() - 1; i++)
			sum += dist[chk[path.get(i)]][path.get(i+1)];
		
		int tmp = 0;
		for(int i = 1; i <= N; i++)
			if(chk[i] == -1){
				tmp = 0;
				tmp += dist[chk[path.get(0)]][i];
				tmp += dist[chk[path.get(path.size()-1)]][i];
				res = Math.min(res, sum + tmp);
			}
	}
}
class Pair implements Comparable<Pair>{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}