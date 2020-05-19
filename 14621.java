import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        par = new int[N+1];
        PriorityQueue<Pair> arr = new PriorityQueue<>();
        int[] sex = new int[N+1];
        HashSet<Integer> hs = new HashSet<>();
        
        for(int i = 1; i <= N; i++){
        	par[i] = i;
        	char ch = sc.next().charAt(0);
        	if(ch == 'W') sex[i] = 2;
        	else sex[i] = 1;
        }
        
        int res = 0;
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	
        	if(sex[a] != sex[b]) arr.offer(new Pair(a, b, c));
        }
        
        while(!arr.isEmpty()){
        	Pair p = arr.poll();
    		int ap = find(p.u), bp = find(p.v);
    		
    		if(ap == bp) continue;
    		
    		hs.add(p.u);
    		hs.add(p.v);
    		par[bp] = ap;
    		res += p.cost;
        }
        
        if(hs.size() != N) System.out.println(-1);
        else System.out.println(res);
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