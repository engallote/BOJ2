import java.util.*;

public class Main {
	static int N, M, T;
	static long D;
	static ArrayList<Pair>[] aly;
	static boolean[] st;
	static long[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//교차로 수
		M = sc.nextInt();//도로 수
		T = sc.nextInt();//수리점 수
		D = sc.nextLong();//수리 후 갈 수 있는 거리
		st = new boolean[N + 1];
		chk = new long[N + 1][N + 1];
		aly = new ArrayList[N + 1];
		
		for(int i = 1; i <= N; i++){
			aly[i] = new ArrayList<>();
			Arrays.fill(chk[i], Long.MAX_VALUE);
		}
		
		st[1] = true;
		Arrays.fill(chk[1], 0);
		for(int i = 0; i < T; i++)
			st[sc.nextInt()] = true;
		
		for(int i = 0; i < M; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			long c = sc.nextLong();
			aly[a].add(new Pair(b, c));
			aly[b].add(new Pair(a, c));
		}
		
		bfs();
	}
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0, D));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.x == N){
				System.out.println(p.c);
				return;
			}
			if(p.d == 0 && !st[p.x]) continue;
			
			for(Pair next : aly[p.x])
				if(chk[next.x][p.x] > p.c + next.c && p.d - next.c >= 0){
					if(st[next.x]){
						chk[next.x][p.x] = p.c + next.c;
						pq.offer(new Pair(next.x, chk[next.x][p.x], D));
					}
					else{
						if((p.d - next.c == 0 && next.x == N) || p.d - next.c > 0){
							chk[next.x][p.x] = p.c + next.c;
							pq.offer(new Pair(next.x, chk[next.x][p.x], p.d - next.c));
						}
					}
				}//if
		}//while
		
		System.out.println("stuck");
	}
}
class Pair implements Comparable<Pair>{
	int x;
	long c, d;
	Pair(int x, long c){
		this.x = x;
		this.c = c;
	}
	Pair(int x, long c, long d){
		this.x = x;
		this.c = c;
		this.d = d;
	}
	@Override
	public int compareTo(Pair o) {
		return o.c > this.c ? -1 : 1;
	}
}