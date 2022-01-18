import java.util.*;

public class Main {
	static int N, M;
	static int[] chk;
	static ArrayList<Pair>[] aly;
	static PriorityQueue<Pair> pq = new PriorityQueue<>();
	static HashSet<Integer> home = new HashSet<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	aly = new ArrayList[N + 1];
    	chk = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		aly[a].add(new Pair(b, c));
    		aly[b].add(new Pair(a, c));
    	}
    	
    	Arrays.fill(chk, Integer.MAX_VALUE);
    	
    	int P = sc.nextInt();
    	int Q = sc.nextInt();
    	
    	for(int i = 0; i < P; i++) home.add(sc.nextInt());
    	for(int i = 0; i < Q; i++) {
    		int num = sc.nextInt();
    		pq.offer(new Pair(num, 0));
    		chk[num] = 0;
    	}
    	
    	bfs();
    }
	private static void bfs() {
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(home.contains(p.v)) {
				System.out.println(p.v);
				return;
			}
			
			for(Pair next : aly[p.v])
				if(chk[next.v] > p.cost + next.cost) {
					chk[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, chk[next.v]));
				}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return -1;
		else if(o.cost == this.cost) return Integer.compare(this.v, o.v);
		else return 1;
	}
}