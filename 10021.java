import java.util.*;

public class Main {
	static int N, C;
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		C = sc.nextInt();
		par = new int[N];
		Pair[] arr = new Pair[N];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		
		for(int i = 0; i < N; i++) {
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
			par[i] = i;
		}
		
		for(int i = 0; i < N; i++)
			for(int j = i + 1; j < N; j++) {
				int x = Math.abs(arr[i].x - arr[j].x), y = Math.abs(arr[i].y - arr[j].y);
				int dist = x * x + y * y;
				if(dist < C) continue;
				pq.offer(new Pair(i, j, dist));
			}
		
		long res = 0;
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int ap = find(p.x), bp = find(p.y);
			if(ap == bp) continue;
			par[bp] = ap;
			res += p.cost;
		}
		
		for(int i = 1; i < N; i++)
			if(par[i] != par[0]) {
				System.out.println(-1);
				return;
			}
		
		System.out.println(res);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int x, y, cost;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
	Pair(int x, int y, int cost) {
		this.x = x;
		this.y = y;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}