import java.util.*;

public class Main {
	static int N;
	static long[] cost;
	static long[][] chk;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		cost = new long[N+1];
		chk = new long[N+1][2600];
		arr = new ArrayList[N+1];
		
		for(int i = 1; i <= N; i++){
			cost[i] = sc.nextLong();
			arr[i] = new ArrayList<>();
			Arrays.fill(chk[i], Long.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		solve();
	}
	private static void solve() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0l, cost[1]));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(chk[p.v][(int)p.cost] <= p.dist) continue;
			if(p.v == N){
				System.out.println(p.dist);
				return;
			}
			
			chk[p.v][(int)p.cost] = p.dist;
			
			for(Pair next : arr[p.v])
				pq.offer(new Pair(next.v, next.cost * p.cost + p.dist, Math.min(p.cost, cost[next.v])));
		}
	}
}
class Pair implements Comparable<Pair>{
	int v;
	long cost, dist;
	
	Pair(int v, long cost){
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, long dist, long cost){
		this.v = v;
		this.dist = dist;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.dist > this.dist ? -1 : (o.dist == this.dist ? 0 : 1);
	}
}