import java.util.*;

public class Main {
	static int N, M, p, q;
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0){
			N = sc.nextInt();
			M = sc.nextInt();
			p = sc.nextInt();
			q = sc.nextInt();
			par = new int[N+1];
			
			for(int i = 1; i <= N; i++)
				par[i] = i;
			
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for(int i = 0; i < M; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				pq.offer(new Pair(a, b, c));
			}
			
			boolean flag = false;
			while(!pq.isEmpty()){
				Pair pair = pq.poll();
				
				int ap = find(pair.u), bp = find(pair.v);
				
				if(ap == bp) continue;
				if((pair.v == q && pair.u == p) || (pair.u == q && pair.v == p)) flag = true;
				par[bp] = ap;
			}
			
			if(flag) System.out.println("YES");
			else System.out.println("NO");
		}
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int u, v, cost;
	Pair(int u, int v, int cost){
		this.u = u;
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}