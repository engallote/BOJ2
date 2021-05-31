import java.util.*;

public class Main {
	static int N, M;
	static boolean[] chk;
	static ArrayList<Integer>[] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	arr = new ArrayList[N];
    	chk = new boolean[N];
    	
    	for(int i = 0; i < N; i++) arr[i] = new ArrayList<>();
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		arr[a].add(b);
    		arr[b].add(a);
    	}
    	
    	boolean res = false;
    	for(int i = 0; i < N; i++) {
    		res = dfs(i, 0);
    		if(res) break;
    	}
    	
    	System.out.println(res ? 1 : 0);
	}
	private static boolean dfs(int idx, int cnt) {
		if(cnt == 4) return true;
		boolean ret = false;
		
		chk[idx] = true;
		
		for(int next : arr[idx])
			if(!chk[next]) ret |= dfs(next, cnt + 1);
		
		chk[idx] = false;
		return ret;
	}
}