import java.util.*;

public class Main {
	static int N, M;
	static int[] item, chk;
	static ArrayList<Pair>[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int R = sc.nextInt();
        item = new int[N + 1];
        chk = new int[N + 1];
        arr = new ArrayList[N + 1];
        
        for(int i = 1; i <= N; i++){
        	item[i] = sc.nextInt();
        	arr[i] = new ArrayList<>();
        }
        
        for(int i = 0; i < R; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	arr[a].add(new Pair(b, c));
        	arr[b].add(new Pair(a, c));
        }
        
        int res = 0;
        for(int i = 1; i <= N; i++)
        	res = Math.max(res, findMax(i));
        System.out.println(res);
    }
	private static int findMax(int idx) {
		Queue<Pair> q = new LinkedList<Pair>();
		Arrays.fill(chk, Integer.MAX_VALUE);
		q.offer(new Pair(idx, 0));
		chk[idx] = 0;
		
		while(!q.isEmpty()){
			Pair p = q.poll();
			
			for(Pair next : arr[p.v])
				if(p.cost + next.cost <= M && chk[next.v] > p.cost + next.cost){
					chk[next.v] = p.cost + next.cost;
					q.offer(new Pair(next.v, chk[next.v]));
				}
		}
		
		int ret = 0;
		for(int i = 1; i <= N; i++)
			if(chk[i] <= M)
				ret += item[i];
		
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