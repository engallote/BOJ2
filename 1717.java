import java.util.*;

public class Main {
	static int[] par;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		par = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
			par[i] = i;
		
		while(--M >= 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			
			int ap = find(b), bp = find(c);
			
			if(a == 1){
				if(ap == bp) System.out.println("YES");
				else System.out.println("NO");
			}
			else par[bp] = ap;
		}
	}
	private static int find(int x) {
		if(par[x] == x) return x;
		return par[x] = find(par[x]);
	}
}