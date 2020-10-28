import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		par = new int[N + 1];
		ArrayList<Pair> arr = new ArrayList<>();
		long res1 = 0, res2 = 0;
		
		for(int i = 0; i <= N; i++) par[i] = i;
		
		for(int i = 0; i <= M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr.add(new Pair(a, b, c));
		}
		
		//√÷º±
		Collections.sort(arr, new SortUp());
		int cnt = 0;
		for(Pair p : arr) {
			int ap = find(p.a), bp = find(p.b);
			if(ap == bp) continue;
			par[bp] = ap;
			res1 += p.cost == 1 ? 0l : 1l;
			++cnt;
			if(cnt > N) break;
		}
		
		//√÷æ«
		for(int i = 0; i <= N; i++) par[i] = i;
		Collections.sort(arr, new SortDown());
		cnt = 0;
		
		for(Pair p : arr) {
			int ap = find(p.a), bp = find(p.b);
			if(ap == bp) continue;
			par[bp] = ap;
			res2 += p.cost == 1 ? 0l : 1l;
			++cnt;
			if(cnt > N) break;
		}
		
		System.out.println(res2 * res2 - res1);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair {
	int a, b, cost;
	Pair(int a, int b, int cost) {
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
}
class SortUp implements Comparator<Pair> {
	@Override
	public int compare(Pair o1, Pair o2) {
		return Integer.compare(o2.cost, o1.cost);
	}
}
class SortDown implements Comparator<Pair> {
	@Override
	public int compare(Pair o1, Pair o2) {
		return Integer.compare(o1.cost, o2.cost);
	}
}