import java.util.*;

public class Main {
	static int N, res, a, b, c, d;
	static int[][] arr;
	static String ans = "";
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	a = sc.nextInt();
    	b = sc.nextInt();
    	c = sc.nextInt();
    	d = sc.nextInt();
    	arr = new int[N][5];
    	res = Integer.MAX_VALUE;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < 5; j++)
    			arr[i][j] = sc.nextInt();
    	
    	solve(0, 0, 0, 0, 0, 0, 0);
    	
    	if(res == Integer.MAX_VALUE) {
    		System.out.println(-1);
    		return;
    	}
    	System.out.println(res);
    	System.out.println(ans);
    }
	private static void solve(int idx, int chk, int p, int f, int s, int v, int sum) {
		if(p >= a && f >= b && s >= c && v >= d) {
			if(res > sum) {
				res = sum;
				ans = "";
				for(int i = 0; i < N; i++)
					if((chk&(1<<i)) != 0) ans += (i + 1) + " ";
			}
			else if(res == sum) {
				PriorityQueue<String> pq = new PriorityQueue<>();
				pq.offer(ans);
				
				ans = "";
				for(int i = 0; i < N; i++)
					if((chk&(1<<i)) != 0) ans += (i + 1) + " ";
				
				pq.offer(ans);
				
				ans = pq.poll();
			}
			return;
		}
		if(idx == N) return;
		
		for(int i = idx; i < N; i++)
			solve(i + 1, chk | (1<<i), p + arr[i][0], f + arr[i][1], s + arr[i][2], v + arr[i][3], sum + arr[i][4]);
	}
}