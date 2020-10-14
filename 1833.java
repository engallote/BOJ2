import java.util.*;

public class Main {
	static int N;
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		par = new int[N + 1];
		boolean[][] chk = new boolean[N + 1][N + 1];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		int res = 0;
		for(int i = 1; i <= N; i++)
			par[i] = i;
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= N; j++) {
				int num = sc.nextInt();
				if(chk[i][j]) continue;
				if(num < 0) {
					int ap = find(i), bp = find(j);
					par[bp] = ap;
					res += -num;
				}
				else if(i != j) pq.offer(new Pair(i, j, num));
				chk[i][j] = chk[j][i] = true;
			}
		
		Queue<Pair> ans = new LinkedList<>();
		while(!pq.isEmpty()) {
			Pair p = pq.poll();
			
			int ap = find(p.a), bp = find(p.b);
			if(ap == bp) continue;
			ans.offer(new Pair(p.a, p.b));
			par[bp] = ap;
			res += p.cost;
		}
		
		System.out.println(res + " " + ans.size());
		while(!ans.isEmpty())
			System.out.println(ans.peek().a + " " + ans.poll().b);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair> {
	int a, b, cost;
	Pair(int a, int b) {
		this.a = a;
		this.b = b;
	}
	Pair(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}