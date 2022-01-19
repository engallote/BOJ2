import java.util.*;

public class Main {
	static int N;
	static boolean flag;
	static int[] what, cost;
	static ArrayList<Integer>[] aly;
	static boolean[][] chk;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int[] who = new int[100];
    	who['E'] = 0;
    	who['L'] = 1;
    	who['T'] = 2;
    	
    	while(true) {
    		N = sc.nextInt();
    		flag = false;
    		
    		if(N == 0) break;
    		
    		what = new int[N + 1];
    		cost = new int[N + 1];
        	aly = new ArrayList[N + 1];
        	chk = new boolean[N + 1][501];
        	
        	for(int i = 1; i <= N; i++) aly[i] = new ArrayList<>();
        	
        	for(int i = 1; i <= N; i++) {
        		char c = sc.next().charAt(0);
        		int pay = sc.nextInt();
        		
        		what[i] = who[c];
        		cost[i] = pay;
        		
        		while(true) {
        			int num = sc.nextInt();
        			if(num == 0) break;
        			
        			aly[i].add(num);
        		}
        	}
        	
        	dfs(1, 0);
        	if(flag) System.out.println("Yes");
        	else System.out.println("No");
    	}
    }
	private static void dfs(int idx, int c) {
		if(flag) return;
		if(idx == N) {
			flag = true;
			return;
		}
		if(chk[idx][c]) return;
		
		chk[idx][c] = true;
		
		for(int next : aly[idx]) {
			if(what[next] == 1) {//레플
				dfs(next, c < cost[next] ? cost[next] : c);
			}
			else if(what[next] == 2) {//트롤
				if(c - cost[next] >= 0)	dfs(next, c - cost[next]);
			}
			else {//빈 공간
				dfs(next, c);
			}
		}
	}
}