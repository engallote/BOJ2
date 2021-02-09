import java.util.*;

public class Main {
	static int N, res;
	static ArrayList<Integer>[] path;
	static int[] go, chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        int M = sc.nextInt();
        path = new ArrayList[N + 1];
        go = new int[N + 1];
        chk = new int[N + 1];
        res = 0;
        
        for(int i = 1; i <= N; i++)
        	path[i] = new ArrayList<>();
        
        while(--M >= 0) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	if(a < 0) go[-a] = b;
        	else path[a].add(b);
        }
        
        dfs(1, 2);
        System.out.println(res);
	}
	private static void dfs(int idx, int jump) {
		if(chk[idx] < jump) {
			if(go[idx] == 0 && chk[idx] == 0) ++res;
			chk[idx] = jump;
			
			if(go[idx] != 0)
				dfs(go[idx], jump);
			if(jump == 2) {
				for(int next : path[idx])
					dfs(next, 1);
			}
		}
	}
}