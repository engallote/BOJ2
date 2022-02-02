import java.util.*;

public class Main {
	static int N;
	static Pair[] arr;
	static boolean[][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	arr = new Pair[N];
    	chk = new boolean[N][N];
    	
    	for(int i = 0; i < N; i++) {
    		int x = sc.nextInt();
    		int y = sc.nextInt();
    		int p = sc.nextInt();
    		arr[i] = new Pair(x, y, p);
    	}
    	
    	for(int i = 0; i < N - 1; i++)
    		for(int j = 0; j < N; j++)
    			if(i != j) getDis(i, j);
    	
    	int res = 0;
    	for(int i = 0; i < N; i++)
    		res = Math.max(res, find(i));
    	
    	System.out.println(res);
    }
	private static void getDis(int s, int e) {
		Pair ps = arr[s], pe = arr[e];
		
		if(Math.pow(ps.p, 2) >= Math.pow(ps.x - pe.x, 2) + Math.pow(ps.y - pe.y, 2))
			chk[s][e] = true;
	}
	private static int find(int s) {
		boolean[] find = new boolean[N];
		Queue<Integer> q = new LinkedList<>();
		q.offer(s);
		find[s] = true;
		int cnt = 0;
		
		while(!q.isEmpty()) {
			int size = q.size();
			cnt += size;
			while(--size >= 0) {
				int x = q.poll();
				
				for(int i = 0; i < N; i++)
					if(!find[i] && chk[x][i]) {
						find[i] = true;
						q.offer(i);
					}
			}
		}
		
		return cnt;
	}
}
class Pair {
	int x, y, p;
	Pair(int x, int y, int p) {
		this.x = x;
		this.y = y;
		this.p = p;
	}
}