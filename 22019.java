import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class Main {
	static int N, M, L;
	static ArrayList<Pair>[] aly;
	static int[][] chk;
    public static void main(String[] args) throws IOException {
//    	Scanner sc = new Scanner(System.in);
    	BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    	StringTokenizer st = new StringTokenizer(br.readLine());
    	N = Integer.parseInt(st.nextToken());//city
    	M = Integer.parseInt(st.nextToken());//road
    	L = Integer.parseInt(st.nextToken());//max len
    	aly = new ArrayList[N + 1];
    	chk = new int[N + 1][1001];
    	
    	for(int i = 1; i <= N; i++) {
    		aly[i] = new ArrayList<>();
    		Arrays.fill(chk[i], -1);
    	}
    	
    	for(int i = 0; i < M; i++) {
    		st = new StringTokenizer(br.readLine());
    		int a = Integer.parseInt(st.nextToken());
    		int b = Integer.parseInt(st.nextToken());
    		int c = Integer.parseInt(st.nextToken());
    		
    		aly[a].add(new Pair(b, c, 0));
    		aly[b].add(new Pair(a, c, 1));
    	}
    	
    	for(int i = 1; i <= N; i++)
    		Collections.sort(aly[i]);
    	
    	bfs();
	}
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0, 0));
		
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			if(p.v == N) {
				System.out.println(p.k);
				return;
			}
			
			if(chk[p.v][p.k] != -1) continue;
			chk[p.v][p.k] = p.k;
			
			for(Pair next : aly[p.v]) {
				if(p.cost + next.cost > L || p.k + 1 > N) continue;
			
				pq.offer(new Pair(next.v, p.cost + next.cost, p.k + next.k));
			}			
		}
		
		System.out.println(-1);
	}
}
class Pair implements Comparable<Pair>{
	int v, cost, k;
	Pair(int v, int cost, int k) {
		this.v = v;
		this.cost = cost;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.k > this.k) return -1;
		else if(o.k == this.k) return Integer.compare(this.cost, o.cost);
		else return 1;
	}
}