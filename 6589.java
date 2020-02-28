import java.util.*;

public class Main {
	static int N, M;
	static int[] arr, dp;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		HashMap<String, Integer> hs = new HashMap<>();
		while(true){
			N = sc.nextInt();
			M = sc.nextInt();
			if(N == 0 && M == 0) break;
			hs.clear();
			int[] chk = new int[N];
			Arrays.fill(chk, -1);
			ArrayList<Pair>[] arr = new ArrayList[N];
			
			for(int i = 0; i < N; i++)
				arr[i] = new ArrayList<>();
			
			int idx = 0;
			for(int i = 0; i < M; i++){
				String a = sc.next();
				String b = sc.next();
				int cost = sc.nextInt();
				if(!hs.containsKey(a)){
					hs.put(a, idx);
					++idx;
				}
				if(!hs.containsKey(b)){
					hs.put(b, idx);
					++idx;
				}
				
				arr[hs.get(a)].add(new Pair(hs.get(b), cost));
				arr[hs.get(b)].add(new Pair(hs.get(a), cost));
			}
			
			String s = sc.next(), e = sc.next();
			int sidx = hs.get(s), eidx = hs.get(e), size = 0, res = -1;
			
			Queue<Pair> q = new LinkedList<Pair>();
			q.offer(new Pair(sidx, 0));
			chk[sidx] = 0;
			
			while(!q.isEmpty()){
				size = q.size();
				while(--size >= 0){
					Pair p = q.poll();
					
					if(p.v == eidx){
						res = Math.max(p.cost, res);
						continue;
					}
					
					int c = p.cost == 0 ? 1000000000 : p.cost;
					for(Pair next : arr[p.v])
						if(chk[next.v] < Math.min(c, next.cost)){
							chk[next.v] = Math.min(c, next.cost);
							q.offer(new Pair(next.v, chk[next.v]));
						}
				}
			}
			System.out.println("Scenario #" + tc);
			System.out.println(res + " tons");
			System.out.println();
			++tc;
		}
	}
}
class Pair{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
}