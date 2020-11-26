import java.util.*;

public class Main {
	static int N, A, B, C;
	static ArrayList<Pair>[] arr;
	static int[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		A = sc.nextInt();
		B = sc.nextInt();
		C = sc.nextInt();
		arr = new ArrayList[N + 1];
		chk = new int[N + 1][10001];
		
		for(int i = 1; i <= N; i++) {
			arr[i] = new ArrayList<>();
			Arrays.fill(chk[i], Integer.MAX_VALUE);
		}
		
		for(int i = 0; i < M; i++) {
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a].add(new Pair(b, c));
			arr[b].add(new Pair(a, c));
		}
		
		bfs();
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(A, C, 0));
		chk[A][C] = 0;
		int size, res = Integer.MAX_VALUE;
		
		while(!q.isEmpty()) {
			size = q.size();
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.v == B) {
					res = Math.min(res, p.max);
					continue;
				}
				
				for(Pair next : arr[p.v]) {
					if(next.cost <= p.cost && chk[next.v][p.cost - next.cost] > chk[p.v][p.cost] + next.cost) {
						chk[next.v][p.cost - next.cost] = chk[p.v][p.cost] + next.cost;
						q.offer(new Pair(next.v, p.cost - next.cost, Math.max(p.max, next.cost)));
					}
				}
			}
		}
		
		System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
}
class Pair {
	int v, cost, max;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
	Pair(int v, int cost, int max) {
		this.v = v;
		this.cost = cost;
		this.max = max;
	}
}