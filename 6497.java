import java.util.*;

public class Main {
	static int N, M;
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true){
			N = sc.nextInt();
			M = sc.nextInt();
			if(N == 0 && M == 0) break;
			par = new int[N + 1];
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for(int i = 0; i <= N; i++)
				par[i] = i;
			
			int res = 0;
			for(int i = 0; i < M; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				res += c;
				pq.offer(new Pair(a, b, c));
			}
			
			while(!pq.isEmpty()){
				Pair p = pq.poll();
				int a = find(p.a), b = find(p.b);
				
				if(a == b) continue;
				par[b] = a;
				res -= p.c;
			}
			
			System.out.println(res);
		}
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b, c;
	Pair(int a, int b, int c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.c > this.c) return -1;
		else if(o.c == this.c) return 0;
		else return 1;
	}
}