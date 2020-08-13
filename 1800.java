import java.util.*;

public class Main {
	static int N, P, K, res;
	static ArrayList<Pair>[] arr;
	static int[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        P = sc.nextInt();
        K = sc.nextInt();
        arr = new ArrayList[N+1];
        chk = new int[N+1];
        res = Integer.MAX_VALUE;
        
        for(int i = 1; i <= N; i++) {
        	arr[i] = new ArrayList<>();
        	chk[i] = Integer.MAX_VALUE;
        }
        
        for(int i = 0; i < P; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	arr[a].add(new Pair(b, c));
        	arr[b].add(new Pair(a, c));
        }
        
        int l = 0, r = 1000000, mid;
        while(l <= r){
        	mid = (l + r) / 2;
        	
        	if(bfs(mid)){
        		res = mid;
        		r = mid - 1;
        	}
        	else l = mid + 1;
        }
        
        System.out.println(res == Integer.MAX_VALUE ? -1 : res);
	}
	private static boolean bfs(int m) {
		Arrays.fill(chk, Integer.MAX_VALUE);
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(1, 0));
		chk[1] = 0;
		int size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				if(p.v == N) continue;
				
				for(Pair next : arr[p.v]){
					int cost = chk[p.v];
					if(next.cost > m) cost += 1;
					
					if(chk[next.v] > cost){
						chk[next.v] = cost;
						q.offer(new Pair(next.v, cost));
					}
				}
			}
		}
		
		return chk[N] <= K ? true : false;
	}
}
class Pair{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
}