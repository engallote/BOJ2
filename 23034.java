import java.util.*;

public class Main {
	static int N;
	static int[] par;
	static int[][] dist;
	static ArrayList<Pair>[] aly;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int M = sc.nextInt();
    	par = new int[N + 1];
    	dist = new int[N + 1][N + 1];
    	aly = new ArrayList[N + 1];
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	
    	for(int i = 1; i <= N; i++)
    		aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		
    		pq.offer(new Pair(a, b, c));
    	}
    	
    	for(int i = 1; i <= N; i++) par[i] = i;
		
		int sum = 0, cnt = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			int ap = find(p.a), bp = find(p.b);
			
			if(ap == bp) continue;
			
			par[bp] = ap;
			sum += p.cost;
			++cnt;
			
			aly[p.a].add(new Pair(p.b, p.cost));
			aly[p.b].add(new Pair(p.a, p.cost));
			if(cnt == N - 1) break;
		}
		
		for(int i = 1; i <= N; i++) bfs(i);
		
    	int Q = sc.nextInt();
    	while(--Q >= 0) {
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		
    		System.out.println(sum - dist[x][y]);
    	}
	}
	private static void bfs(int s) {
		Queue<Integer> q = new LinkedList<>();
		boolean[] chk = new boolean[N + 1];
		q.offer(s);
		chk[s] = true;
		
		while(!q.isEmpty()) {
			int size = q.size();
			while(--size >= 0) {
				int x = q.poll();
				
				for(Pair next : aly[x])
					if(!chk[next.a]) {
						chk[next.a] = true;
						dist[s][next.a] = Math.max(dist[s][next.a], next.cost);
						dist[s][next.a] = Math.max(dist[s][next.a], dist[s][x]);
						q.offer(next.a);
					}
			}
		}
		
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b, cost;
	Pair(int a, int cost) {
		this.a = a;
		this.cost = cost;
	}
	Pair(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.cost, o.cost);
	}
}