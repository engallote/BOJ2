import java.util.*;

public class Main {
	static int N, M, Q;
	static ArrayList<Integer>[] aly;
	static int[] par;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	M = sc.nextInt();
    	Q = sc.nextInt();
    	par = new int[N + 1];
    	
    	for(int i = 1; i <= N; i++) par[i] = i;
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		int ap = find(a), bp = find(b);
    		if(ap != bp) par[bp] = ap;
    	}
    	
    	while(--Q >= 0) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		
    		int ap = find(a), bp = find(b);
    		if(ap == bp) System.out.println("Y");
    		else System.out.println("N");
    	}
    }
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}