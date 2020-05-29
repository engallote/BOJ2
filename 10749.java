import java.util.*;

public class Main {
	static int N;
	static boolean[] chk;
	static int[] arr, par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		par = new int[N];
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextInt();
			par[i] = i;
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>(); 
		for(int i = 0; i < N; i++)
			for(int j = i + 1; j < N; j++){
				int sum = arr[i]^arr[j];
				pq.offer(new Pair(i, j, sum));
			}
		
		int cnt = 0;
		long res = 0;
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			int ap = find(p.a), bp = find(p.b);
			
			if(ap == bp) continue;
			++cnt;
			par[bp] = ap;
			res += (long)p.cost;
			if(cnt == N - 1) break;//모든 걸 다 확인했다
		}
		
		System.out.println(res);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}
class Pair implements Comparable<Pair>{
	int a, b, cost;
	Pair(int a, int b, int cost){
		this.a = a;
		this.b = b;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? 1 : (o.cost == this.cost ? 0 : -1);
	}
}