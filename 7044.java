import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        par = new int[N + 1];
        PriorityQueue<Pair> pq = new PriorityQueue<>();
        
        for(int i = 1; i <= N; i++)
        	par[i] = i;
        
        for(int i = 0; i < M; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	
        	if(a > b) {
        		int tmp = a;
        		a = b;
        		b = tmp;
        	}
        	pq.offer(new Pair(a, b, c));
        }
        
        int res = 0, cnt = 0;
        while(!pq.isEmpty()) {
        	Pair p = pq.poll();
        	
        	int ap = find(p.a), bp = find(p.b);
        	if(ap == bp) continue;
        	
        	par[bp] = ap;
        	res += p.c;
        	++cnt;
        	
        	if(cnt == N - 1) break;
        }
        
        if(cnt != N - 1) System.out.println(-1);
        else System.out.println(res);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int a, b, c;
	Pair(int a, int b, int c) {
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(o.c, this.c);
	}
}