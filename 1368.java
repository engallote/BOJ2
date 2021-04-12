import java.util.*;

public class Main {
	static int N;
	static int[] par;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	par = new int[N + 1];
    	int[] cost = new int[N + 1];
    	PriorityQueue<Pair> pq = new PriorityQueue<>();
    	
    	for(int i = 1; i <= N; i++) {
    		par[i] = i;
    		cost[i] = sc.nextInt();
    		pq.offer(new Pair(i, 0, cost[i]));
    	}
    	
    	for(int i = 1; i <= N; i++)
    		for(int j = 1; j <= N; j++) {
    			int num = sc.nextInt();
    			if(i == j) continue;
    			
    			if(i < j) pq.offer(new Pair(i, j, num));
    		}
    	
    	int res = 0;
    	while(!pq.isEmpty()) {
    		Pair p = pq.poll();
    		
    		int ap = find(p.a), bp = find(p.b);
    		
    		if(ap == bp) continue;
    		
    		par[bp] = ap;
    		res += p.c;
    		--N;
    		
    		if(N == 0) break;
    	}
    	
    	System.out.println(res);
    }
    private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
	static class Pair implements Comparable<Pair> {
    	int a, b, c;
    	Pair(int a, int b, int c){
    		this.a = a;
    		this.b = b;
    		this.c = c;
    	}
		@Override
		public int compareTo(Main.Pair o) {
			return Integer.compare(this.c, o.c);
		}
    }
}