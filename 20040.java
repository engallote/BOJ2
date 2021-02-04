import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int M = sc.nextInt();
        par = new int[N];
        
        for(int i = 0; i < N; i++)
        	par[i] = i;
        
        int res = -1;
        for(int i = 1; i <= M; i++) {
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	
        	int ap = find(a), bp = find(b);
        	if(ap == bp) {
        		if(res == -1) res = i;
        		continue;
        	}
        	
        	par[bp] = ap;
        }
        
        if(res != - 1) System.out.println(res);
        else System.out.println(0);
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}