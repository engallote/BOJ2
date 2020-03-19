import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		par = new int[N+1];
		long res = 0, tmp = 0;
		
		for(int i = 1; i <= N; i++)
			par[i] = i;
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			pq.offer(new Pair(a, b, c));
		}
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int a = find(p.a);
			int b = find(p.b);
			
			if(a == b) continue;
			par[b] = a;
			res += p.c;
			tmp = p.c;
		}
		
		System.out.println(res - tmp);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b;
	long c;
	Pair(int a, int b, long c){
		this.a = a;
		this.b = b;
		this.c = c;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? -1 : 1;
	}
}