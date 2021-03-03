import java.util.*;

public class Main {
	static int max, midx;
	static int[] par;
	static boolean[] chk;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int K = sc.nextInt();
        par = new int[N];
        chk = new boolean[N];
        arr = new ArrayList[N];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 0; i < N; i++) {
        	par[i] = i;
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0 ; i < K; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	pq.offer(new Pair(a, b, c));
        }
        
        int cnt = 0, sum = 0;
        while(!pq.isEmpty()) {
        	Pair p = pq.poll();
        	
        	int ap = find(p.a), bp = find(p.b);
        	
        	if(ap == bp) continue;
        	
        	par[bp] = ap;
        	arr[p.a].add(new Pair(p.a, p.b, p.c));
        	arr[p.b].add(new Pair(p.b, p.a, p.c));
        	sum += p.c;
        	++cnt;
        	if(cnt == N - 1) break;
        }
        
        System.out.println(sum);
        
        max = 0;
        midx = 0;
        dfs(0, 0);
        Arrays.fill(chk, false);
        max = 0;
        dfs(midx, 0);
        System.out.println(max);
    }
	private static void dfs(int idx, int cost) {
		chk[idx] = true;
		
		if(cost > max) {
			max = cost;
			midx = idx;
		}
		
		for(Pair next : arr[idx])
			if(!chk[next.b]) dfs(next.b, cost + next.c);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b, c;
	Pair(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(this.c, o.c);
	}
}