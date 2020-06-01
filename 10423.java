import java.util.*;

public class Main {
	static int N, M, K;
	static ArrayList<Pair>[] arr;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		arr = new ArrayList[N+1];
		chk = new int[N+1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			chk[i] = i;
		}

		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 0; i < K; i++){
			int num = sc.nextInt();
			chk[num] = 0;
			q.offer(num);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			pq.offer(new Pair(a, b, c));
		}
		
		int res = 0;
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			int ap = find(p.a), bp = find(p.b);
			if(ap == bp) continue;
			chk[bp] = ap;
			res += p.cost;
		}
		
		System.out.println(res);
	}
	private static int find(int x) {
		if(chk[x] == x) return x;
		return chk[x] = find(chk[x]);
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
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}