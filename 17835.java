import java.util.*;

public class Main {
	static int N, M, K;
	static long[] chk;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);			
		N = sc.nextInt();
		M = sc.nextInt();
		K = sc.nextInt();
		chk = new long[N + 1];
		arr = new ArrayList[N + 1];
		Queue<Pair> q = new LinkedList<Pair>();
		
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		Arrays.fill(chk, Long.MAX_VALUE);
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
//			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		for(int i = 0; i < K; i++){
			int num = sc.nextInt();
			q.offer(new Pair(num, 0));
			chk[num] = 0;
		}
		
		bfs(q);
		long max = 0, idx = 0;
		for(int i = 1; i <= N; i++)
			if(max < chk[i]){
				max = chk[i];
				idx = i;
			}
		
		System.out.println(idx);
		System.out.println(max);
	}
	private static void bfs(Queue<Pair> q) {
		int size;
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				for(Pair next : arr[p.v])
					if(chk[next.v] > p.cost + next.cost){
						chk[next.v] = p.cost + next.cost;
						q.offer(new Pair(next.v, chk[next.v]));
					}
			}
		}
	}
}
class Pair{
	int v;
	long cost;
	Pair(int v, long cost){
		this.v = v;
		this.cost = cost;
	}
}