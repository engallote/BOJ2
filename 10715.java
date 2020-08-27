import java.util.*;

public class Main {
	static int N, M, C;
	static ArrayList<Pair>[] arr;
	static long[] chk;
	static boolean[] visit;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		C = sc.nextInt();
		arr = new ArrayList[N+1];
		chk = new long[N+1];
		visit = new boolean[N+1];
		long res = 0, sum = 0;
		
		for(int i = 1; i <= N; i++){
			arr[i] = new ArrayList<>();
			chk[i] = Long.MAX_VALUE;
		}
		
		while(--M >= 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			res += c;
			sum += c;
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));
		chk[1] = 0;
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(chk[p.v] < p.cost || visit[p.v]) continue;
			visit[p.v] = true;
			
			for(Pair next : arr[p.v])
				if(visit[next.v]) sum -= next.cost;
			
			res = Math.min(res, (long)C * p.cost + sum);
			
			for(Pair next : arr[p.v])
				if(chk[next.v] > p.cost + next.cost){
					chk[next.v] = p.cost + next.cost;
					pq.offer(new Pair(next.v, chk[next.v]));
				}
		}
		
		System.out.println(res);
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