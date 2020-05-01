import java.util.*;

public class Main {
	static int N, M, D, E;
	static long res = Long.MIN_VALUE;
	static long[] arr;
	static ArrayList<Pair>[] aly;
	static long[] chk, chk2;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		D = sc.nextInt();
		E = sc.nextInt();
		arr = new long[N+1];
		aly = new ArrayList[N+1];
		chk = new long[N+1];
		chk2 = new long[N+1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextLong();
			aly[i] = new ArrayList<>();
		}
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			aly[a].add(new Pair(b, c));
			aly[b].add(new Pair(a, c));
		}
		
		fromHome();
		fromSchool();
		boolean flag = false;
		for(int i = 2; i < N; i++)
			if(chk[i] != Long.MAX_VALUE && chk2[i] != Long.MAX_VALUE){
				flag = true;
				res = Math.max(res, arr[i] * E - (chk[i] + chk2[i]) * D);
			}
		
		if(flag) System.out.println(res);
		else System.out.println("Impossible");
	}
	private static void fromSchool() {
		Arrays.fill(chk2, Long.MAX_VALUE);
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(N, 0l));
		chk2[N] = 0l;

		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(chk2[p.v] < p.cost) continue;
			for(Pair next : aly[p.v])
				if(arr[next.v] > arr[p.v] && chk2[next.v] > p.cost + next.cost){
					chk2[next.v] = p.cost + next.cost;
					q.offer(new Pair(next.v, chk2[next.v]));
				}
		}
	}
	private static void fromHome() {
		Arrays.fill(chk, Long.MAX_VALUE);
		PriorityQueue<Pair> q = new PriorityQueue<>();
		q.offer(new Pair(1, 0l));
		chk[1] = 0l;

		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(chk[p.v] < p.cost) continue;
			for(Pair next : aly[p.v])
				if(arr[next.v] > arr[p.v] && chk[next.v] > p.cost + next.cost){
					chk[next.v] = p.cost + next.cost;
					q.offer(new Pair(next.v, chk[next.v]));
				}
		}
	}
}
class Pair implements Comparable<Pair>{
	int v;
	long cost;
	Pair(int v, long cost){
		this.v = v;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : (o.cost == this.cost ? 0 : 1);
	}
}