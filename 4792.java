import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int K = sc.nextInt();
			
			if(N == 0 && M == 0 && K == 0) break;
			
			par = new int[N + 1];
			ArrayList<Pair> blue = new ArrayList<>(), red = new ArrayList<>();
			
			for(int i = 1; i <= N; i++)
				par[i] = i;
			
			for(int i = 0; i < M; i++) {
				char c = sc.next().charAt(0);
				int a = sc.nextInt();
				int b = sc.nextInt();
				
				if(c == 'B') blue.add(new Pair(a, b));
				else red.add(new Pair(a, b));
			}
			int max = 0, min = 0;
			for(Pair p : blue) {
				int ap = find(p.x), bp = find(p.y);
				if(ap == bp) continue;
				
				par[bp] = ap;
				++max;
			}
			
			for(int i = 1; i <= N; i++)
				par[i] = i;
			
			for(Pair p : red) {
				int ap = find(p.x), bp = find(p.y);
				if(ap == bp) continue;
				
				par[bp] = ap;
			}
			for(Pair p : blue) {
				int ap = find(p.x), bp = find(p.y);
				if(ap == bp) continue;
				
				par[bp] = ap;
				++min;
			}
			
			if(min <= K && K <= max) System.out.println(1);
			else System.out.println(0);
		}
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair {
	int x, y;
	Pair(int x, int y) {
		this.x = x;
		this.y = y;
	}
}