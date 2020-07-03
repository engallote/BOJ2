import java.util.*;

public class Main {
	static int N;
	static Pair[] arr;
	static ArrayList<Pair>[] aly;
	static int[] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		boolean[] visit = new boolean[1000001];
		HashSet<Integer> hs = new HashSet<>();
		for(int i = 2; i <= 1000000; i++){
			if(visit[i]) continue;
			hs.add(i);
			for(int j = i + i; j <= 1000000; j+=i)
				visit[j] = true;
		}
		
		int sx = sc.nextInt();
		int sy = sc.nextInt();
		int ex = sc.nextInt();
		int ey = sc.nextInt();
		N = sc.nextInt();
		aly = new ArrayList[N + 2];
		arr = new Pair[N + 2];
		chk = new int[N + 2];
		
		Arrays.fill(chk, Integer.MAX_VALUE);
		for(int i = 1; i <= N; i++)
			arr[i] = new Pair(sc.nextInt(), sc.nextInt());
		
		arr[0] = new Pair(sx, sy);
		arr[N + 1] = new Pair(ex, ey);
		N += 2;
		
		for(int i = 0; i < N; i++)
			aly[i] = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
			for(int j = i + 1; j < N; j++){
				int dist = (int)Math.sqrt(Math.pow(Math.abs(arr[i].idx- arr[j].idx), 2) + Math.pow(Math.abs(arr[i].d - arr[j].d), 2));
				if(hs.contains(dist)){
					aly[i].add(new Pair(j, dist));
					aly[j].add(new Pair(i, dist));
				}
			}
		
		bfs();
	}
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0));
		chk[0] = 0;
		int size, res = Integer.MAX_VALUE;
		
		while(!q.isEmpty()){
			size = q.size();
			
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.idx == N - 1){
					res = Math.min(res, p.d);
					continue;
				}
				
				for(Pair next : aly[p.idx])
					if(chk[next.idx] > p.d + next.d){
						chk[next.idx] = p.d + next.d;
						q.offer(new Pair(next.idx, chk[next.idx]));
					}
			}
		}
		
		if(res == Integer.MAX_VALUE) System.out.println(-1);
		else System.out.println(res);
	}
}
class Pair{
	int idx, d;
	Pair(int idx, int d){
		this.idx = idx;
		this.d = d;
	}
}