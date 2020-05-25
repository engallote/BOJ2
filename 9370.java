import java.util.*;

public class Main {
	static int N, M, t, g, h;
	static ArrayList<Pair>[] arr;
	static int[][] chk;
	static int[] dest;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0){
			N = sc.nextInt();
			M = sc.nextInt();
			t = sc.nextInt();
			arr = new ArrayList[N+1];
			chk = new int[N+1][2];
			dest = new int[t];
			
			for(int i = 1; i <= N; i++){
				arr[i] = new ArrayList<>();
				Arrays.fill(chk[i], Integer.MAX_VALUE);
			}
			
			int s = sc.nextInt();
			g = sc.nextInt();
			h = sc.nextInt();
			
			for(int i = 0; i < M; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				arr[a].add(new Pair(b, c));
				arr[b].add(new Pair(a, c));
			}
			
			for(int i = 0; i < t; i++)
				dest[i] = sc.nextInt();
			
			solve(s);
		}
	}
	private static void solve(int s) {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		PriorityQueue<Integer> ans = new PriorityQueue<>();
		pq.offer(new Pair(s, 0, 0));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			for(Pair next : arr[p.v]){
				if((p.v == g && next.v == h) || (p.v == h && next.v == g)){
					if(chk[next.v][1] <= p.cost + next.cost) continue;
					chk[next.v][1] = p.cost + next.cost;
					pq.offer(new Pair(next.v, chk[next.v][1], 1));
				}
				else if(chk[next.v][p.k] > p.cost + next.cost){
					chk[next.v][p.k] = p.cost + next.cost;
					pq.offer(new Pair(next.v, chk[next.v][p.k], p.k));
				}
			}
		}
		
		for(int i = 0; i < t; i++){
			if(chk[dest[i]][1] != Integer.MAX_VALUE && chk[dest[i]][0] >= chk[dest[i]][1]) 
				ans.offer(dest[i]);
		}
		
		while(!ans.isEmpty()) System.out.print(ans.poll() + " ");
		System.out.println();
	}
}
class Pair implements Comparable<Pair>{
	int v, cost, k;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, int cost, int k){
		this.v = v;
		this.cost = cost;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}