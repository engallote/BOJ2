import java.util.*;

public class Main {
	static int N, M, K;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		bfs();
	}
	private static void bfs() {
		long[][] chk = new long[N+1][K+1];
		for(int i = 0; i <= N; i++)
			Arrays.fill(chk[i], Long.MAX_VALUE);
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(1, 0, K));
		chk[1][K] = 0;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(p.v == N){
				System.out.println(p.cost);
				return;
			}
			
			for(Pair next : arr[p.v]){
				if(chk[next.v][p.k] > p.cost + next.cost){
					chk[next.v][p.k] = p.cost + next.cost;
					q.offer(new Pair(next.v, chk[next.v][p.k], p.k));
				}
				if(p.k > 0 && chk[next.v][p.k-1] > p.cost){
					chk[next.v][p.k-1] = p.cost;
					q.offer(new Pair(next.v, p.cost, p.k - 1));
				}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v, k;
	long cost;
	Pair(int v, long cost){
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, long cost, int k){
		this.v = v;
		this.cost = cost;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}