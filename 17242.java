import java.util.*;

public class Main {
	static int N, M;
	static ArrayList<Pair>[] arr, aly;
	static long[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N];
        aly = new ArrayList[N];
        chk = new long[N];
        
        for(int i = 0; i < N; i++){
        	arr[i] = new ArrayList<>();
        	aly[i] = new ArrayList<>();
        }
        Arrays.fill(chk, Long.MAX_VALUE);
        
        for(int i = 0; i < M; i++){
        	int x = sc.nextInt();
        	int y = sc.nextInt();
        	long k = sc.nextLong();
        	long b = sc.nextLong();
        	arr[x].add(new Pair(y, k, b));
        	arr[y].add(new Pair(x, k, b));
        }
        
        bfs();
    }
	private static void bfs() {
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(0, 0l, 0l));
		boolean flag = false;
		chk[0] = 0l;
		aly[0].add(new Pair(0, 0));
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			if(p.v == N - 1) continue;
			
			for(Pair next : arr[p.v]){
				if(p.k + next.k <= 1000 && p.b + next.b <= 1000){
					long k = p.k + next.k, b = p.b + next.b;
					flag = true;
					for(int i = 0; i < aly[next.v].size(); i++){
						Pair num = aly[next.v].get(i);
						if(num.k <= k && num.b <= b){
							flag = false;
							break;
						}
						else if(num.k >= k && num.b >= b){
							aly[next.v].remove(i);
							--i;
						}
					}
					if(flag){
						aly[next.v].add(new Pair(k, b));
						q.offer(new Pair(next.v, k, b));
					}
				}
			}
		}
		
		long res = Long.MAX_VALUE;
		
		for(Pair num : aly[N-1])
			res = Math.min(res, num.k * num.b);
		System.out.println(res == Long.MAX_VALUE ? -1 : res);
	}
}
class Pair{
	int v;
	long k, b;
	Pair(int v, long k, long b){
		this.v = v;
		this.k = k;
		this.b = b;
	}
	Pair(long k, long b){
		this.k = k;
		this.b = b;
	}
}