import java.util.*;

public class Main {
	static int N, M;
	static int[] par;
	static Pair[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		par = new int[N + 1];
		arr = new Pair[N + 1];
		
		for(int i = 1; i <= N; i++){
			par[i] = i;
			int x = sc.nextInt();
			int y = sc.nextInt();
			arr[i] = new Pair(x, y);
		}
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int ap = find(a), bp = find(b);
			
			par[bp] = ap;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 1; i <= N; i++)
			for(int j = i + 1; j <= N; j++){
				double cost = cal(arr[i], arr[j]);
				pq.offer(new Pair(i, j, cost));
			}
		
		double res = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			int ap = find(p.u), bp = find(p.v);
			if(ap == bp) continue;
			par[bp] = ap;
			res += p.cost;
		}
		
		System.out.println(String.format("%.2f", res));
	}
	private static double cal(Pair p1, Pair p2) {
		return Math.sqrt(Math.pow(Math.abs(p1.u - p2.u), 2) + Math.pow(Math.abs(p1.v - p2.v), 2));
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int u, v;
	double cost;
	Pair(int u, int v){
		this.u = u;
		this.v = v;
	}
	Pair(int u, int v, double cost){
		this.u = u;
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}