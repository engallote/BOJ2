import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(true) {
        	N = sc.nextInt();
        	
        	if(N == 0) break;
        	
            par = new int[N];
            Pair[] arr = new Pair[N];
            
            for(int i = 0; i < N; i++) {
            	par[i] = i;
            	int x = sc.nextInt();
            	int y = sc.nextInt();
            	arr[i] = new Pair(x, y);
            }
            PriorityQueue<Pair> pq = new PriorityQueue<>();
            
            for(int i = 0; i < N; i++)
            	for(int j = 0; j < N; j++)
            		pq.offer(new Pair(i, j, getDist(arr[i], arr[j])));
            		
            int cnt = 0;
            double res = 0;
            while(!pq.isEmpty()) {
            	Pair p = pq.poll();
            	
            	int ap = find(p.x), bp = find(p.y);
            	
            	if(ap == bp) continue;
            	par[bp] = ap;
            	++cnt;
            	res += p.dist;
            	if(cnt == N - 1) break;
            }
            
            System.out.println(String.format("%.2f", res));
        }
    }
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
	private static double getDist(Pair p1, Pair p2) {
		double a = (p2.x - p1.x) * (p2.x - p1.x);
		double b = (p2.y - p1.y) * (p2.y - p1.y);
		double sum = a + b;
		return Math.sqrt(sum);
	}
}
class Pair implements Comparable<Pair>{
	int x, y;
	double dist;
	Pair(int x, int y){
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, double dist){
		this.x = x;
		this.y = y;
		this.dist = dist;
	}
	@Override
	public int compareTo(Pair o) {
		return Double.compare(this.dist, o.dist);
	}
}