import java.util.*;

public class Main {
	static int N, R, M;
	static int[] city;
	static ArrayList<Pair>[] arr;
	static HashMap<String, Integer> hs = new HashMap<>();
	static HashSet<String> free = new HashSet<>(), half = new HashSet<>();
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        R = sc.nextInt();
        arr = new ArrayList[N];
        
        free.add("Mugunghwa");
        free.add("ITX-Saemaeul");
        free.add("ITX-Cheongchun");
        half.add("S-Train");
        half.add("V-Train");
        
        for(int i = 0; i < N; i++){
        	arr[i] = new ArrayList<>();
        	String name = sc.next();
        	hs.put(name, i);
        }
        
        M = sc.nextInt();
        city = new int[M];
        
        for(int i = 0; i < M; i++){
        	String str = sc.next();
        	city[i] = hs.get(str);
        }
        
        int K = sc.nextInt();
        for(int i = 0; i < K; i++){
        	String type = sc.next();
        	String start = sc.next();
        	String end = sc.next();
        	int cost = sc.nextInt();
        	arr[hs.get(start)].add(new Pair(hs.get(end), cost, type));
        	arr[hs.get(end)].add(new Pair(hs.get(start), cost, type));
        }
        
        bfs();
    }
	private static void bfs() {
		int res1 = Integer.MAX_VALUE, res2 = Integer.MAX_VALUE;
		int[][][] chk = new int[M][N][2];
		for(int i = 0; i < M; i++)
			for(int j = 0; j < N; j++)
				Arrays.fill(chk[i][j], Integer.MAX_VALUE);
		
		chk[0][city[0]][0] = chk[0][city[0]][1] = 0;
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, city[0], 0, 0));
		pq.offer(new Pair(1, city[0], 0, 1));
		
		while(!pq.isEmpty()){
			Pair p = pq.poll();
			
			if(p.idx >= M){
				if(p.k == 0) res1 = Math.min(res1, p.cost);
				else res2 = Math.min(res2, p.cost);
				if(res1 != Integer.MAX_VALUE && res2 != Integer.MAX_VALUE) break;
				continue;
			}
			
			if(p.k == 0 && res1 != Integer.MAX_VALUE) continue;
			if(p.k == 1 && res2 != Integer.MAX_VALUE) continue;
			
			for(Pair next : arr[p.v]){
				if(p.k == 0){//내일로 티켓 안 샀음
					if(chk[p.idx][next.v][p.k] > p.cost + next.cost){
						chk[p.idx][next.v][p.k] = p.cost + next.cost;
						if(next.v == city[p.idx])
							pq.offer(new Pair(p.idx + 1, next.v, p.cost + next.cost, p.k));
						else
							pq.offer(new Pair(p.idx, next.v, p.cost + next.cost, p.k));
					}
				}
				else{//티켓 샀음
					int cost = next.cost;
					if(free.contains(next.type)) cost = 0;
					else if(half.contains(next.type)) cost /= 2;
					cost += p.cost;
					
					if(chk[p.idx][next.v][p.k] > cost){
						chk[p.idx][next.v][p.k] = cost;
						if(next.v == city[p.idx])
							pq.offer(new Pair(p.idx + 1, next.v, cost, p.k));
						else
							pq.offer(new Pair(p.idx, next.v, cost, p.k));
					}
				}
			}
		}//while
		
		res2 += R;
		if(res1 <= res2) System.out.println("No");
		else System.out.println("Yes");
	}
}
class Pair implements Comparable<Pair>{
	int idx, v, cost, k;
	String type;
	Pair(int v, int cost, String type){
		this.v = v;
		this.cost = cost;
		this.type = type;
	}
	Pair(int idx, int v, int cost, int k){
		this.idx = idx;
		this.v = v;
		this.cost = cost;
		this.k = k;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cost > this.cost) return -1;
		else if(o.cost == this.cost){
			if(o.idx > this.idx) return 1;
			else if(o.idx == this.idx) return 0;
			else return -1;
		}
		else return 1;
	}
}