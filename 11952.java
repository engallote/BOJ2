import java.util.*;

public class Main {
	static int N, M, K, S;
	static long p, q;
	static ArrayList<Integer>[] arr;
	static long[] chk;
	static boolean[] jom, not;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        K = sc.nextInt();//점령당한 도시 개수
        S = sc.nextInt();//최대 이동 횟수
        p = sc.nextLong();//안전한 도시 숙박비
        q = sc.nextLong();//위험한 도시 숙박비
        arr = new ArrayList[N + 1];
        chk = new long[N + 1];
        jom = new boolean[N + 1];
        not = new boolean[N + 1];
        Arrays.fill(chk, Long.MAX_VALUE);
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        Queue<Integer> tmp = new LinkedList<Integer>();
        for(int k = 0; k < K; k++){
        	int num = sc.nextInt();
        	jom[num] = true;
        	tmp.offer(num);
        }
        
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	arr[a].add(b);
        	arr[b].add(a);
        }

        findNotSatis(tmp);
    	not[1] = not[N] = false;
    	
        bfs();
    }
	private static void bfs() {
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		pq.offer(new Pair(1, 0));
		chk[1] = 0;
		while(!pq.isEmpty()){
			Pair pp = pq.poll();
			
			if(pp.x == N){
				System.out.println(pp.cost - p);
				return;
			}
			if(chk[pp.x] != pp.cost) continue;
			
			for(int next : arr[pp.x]){
				if(jom[next]) continue;
				if(not[next] && chk[next] > pp.cost + q){
					chk[next] = pp.cost + q;
					pq.offer(new Pair(next, chk[next]));
				}
				if(!not[next] && chk[next] > pp.cost + p){
					chk[next] = pp.cost + p;
					pq.offer(new Pair(next, chk[next]));
				}
			}
		}
	}
	private static void findNotSatis(Queue<Integer> tmp) {
		int size = 0, cnt = S;
		
		while(--cnt >= 0){
			size = tmp.size();
			while(--size >= 0){
				int x = tmp.poll();
				
				for(int next : arr[x])
					if(!not[next]){
						not[next] = true;
						tmp.offer(next);
					}
			}
		}
	}
}
class Pair implements Comparable<Pair>{
	int x;
	long cost;
	Pair(int x, long cost){
		this.x = x;
		this.cost = cost;
	}
	@Override
	public int compareTo(Pair o) {
		return o.cost > this.cost ? -1 : 1;
	}
}