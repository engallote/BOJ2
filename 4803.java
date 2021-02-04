import java.util.*;

public class Main {
	static int[] par;
	static boolean[] chk;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int tc = 1;
        while(true) {
        	int N = sc.nextInt();
            int M = sc.nextInt();
            
            if(N == 0 && M == 0) break;
            
            par = new int[N + 1];
            chk = new boolean[N + 1];
            
            for(int i = 1; i <= N; i++) {
            	par[i] = i;
            	chk[i] = true;
            }
            
            for(int i = 0; i < M; i++) {
            	int a = sc.nextInt();
            	int b = sc.nextInt();
            	
            	if(a > b) {
            		int tmp = a;
            		a = b;
            		b = tmp;
            	}
            	
            	int ap = find(a), bp = find(b);
            	
            	if(ap == bp || !chk[ap] || !chk[bp]) chk[ap] = chk[bp] = false;
            	
            	if(ap > bp) par[ap] = bp;
            	else par[bp] = ap;
            }
            
            System.out.print("Case " + tc + ": ");
            
            int res = 0;
            for(int i = 1; i <= N; i++)
            	if(chk[find(i)]) {
            		chk[find(i)] = false;
            		++res;
            	}
            
            if(res == 0) System.out.println("No trees.");
            else if(res == 1) System.out.println("There is one tree.");
            else System.out.println("A forest of " + res + " trees.");
            ++tc;
        }
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}