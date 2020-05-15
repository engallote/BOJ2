import java.util.*;
 
public class Main {
	static int N, M;
	static ArrayList<Pair>[] arr;
	static int[] chk;
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        arr = new ArrayList[N+1];
        chk = new int[N+1];
        int[] indgree = new int[N+1];
        
        for(int i = 1; i <= N; i++)
        	arr[i] = new ArrayList<>();
        
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	++indgree[b];
        	arr[a].add(new Pair(b, c));
        }
        
        int res = 0;
        for(int i = 1; i <= N; i++)
        	if(indgree[i] == 0)
        		res = Math.max(res, bfs(i));
        	
        System.out.println(res);
    }
	private static int bfs(int idx) {
		Arrays.fill(chk, -1);
		Queue<Pair> q = new LinkedList<Pair>();
		q.offer(new Pair(idx, 0));
		chk[idx] = 0;
		int ret = 0, size;
		
		while(!q.isEmpty()){
			size = q.size();
			while(--size >= 0){
				Pair p = q.poll();
				
				ret = Math.max(p.cost, ret);
				
				for(Pair next : arr[p.v])
					if(chk[next.v] < p.cost + next.cost){
						chk[next.v] = p.cost + next.cost;
						q.offer(new Pair(next.v, chk[next.v]));
					}
			}
		}
		
		return ret;
	}
}
class Pair{
	int v, cost;
	Pair(int v, int cost){
		this.v = v;
		this.cost = cost;
	}
}