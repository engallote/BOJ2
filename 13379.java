import java.util.*;

public class Main {
	static int C, M;
	static ArrayList<Pair>[] arr;
	static int[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = sc.nextInt();
        
        while(--T >= 0) {
        	C = sc.nextInt();//the number of cities
        	M = sc.nextInt();//the number of minimum time
        	arr = new ArrayList[C + 1];
        	chk = new int[C + 1];
        	
        	for(int i = 1; i <= C; i++) {
        		arr[i] = new ArrayList<>();
        		chk[i] = 1000000000;
        	}
        	
        	for(int i = 0; i < C - 1; i++) {
        		int a = sc.nextInt();
        		int b = sc.nextInt();
        		int c = sc.nextInt();
        		arr[a].add(new Pair(b, c));
        	}
        	
        	int res = bfs();
        	System.out.println(res);
        }
	}
	private static int bfs() {
		Queue<Pair> q = new LinkedList<>();
		q.offer(new Pair(1, 0));
		chk[1] = 0;
		int size, res = -1;
		
		while(!q.isEmpty()) {
			size = q.size();
			
			while(--size >= 0) {
				Pair p = q.poll();
				
				if(p.v != 1 && chk[p.v] >= M && chk[p.v] > res) res = chk[p.v];
				
				for(Pair next : arr[p.v])
					if(chk[next.v] > next.cost + p.cost) {
						chk[next.v] = p.cost + next.cost;
						q.offer(new Pair(next.v, chk[next.v]));
					}
			}
		}
		
		return res;
	}
}
class Pair{
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}