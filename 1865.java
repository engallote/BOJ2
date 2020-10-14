import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0) {
			int N = sc.nextInt();
			int M = sc.nextInt();
			int W = sc.nextInt();
			int[] chk = new int[N + 1];
			ArrayList<Pair>[] arr = new ArrayList[N + 1];
			
			for(int i = 1; i <= N; i++) {
				arr[i] = new ArrayList<>();
				chk[i] = 1000000000;
			}
			
			while(--M >= 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				arr[a].add(new Pair(b, c));
				arr[b].add(new Pair(a, c));
			}
			
			while(--W >= 0) {
				int a = sc.nextInt();
				int b = sc.nextInt();
				int c = sc.nextInt();
				
				arr[a].add(new Pair(b, -c));
			}
			
			chk[1] = 0;
			boolean flag = false;
			loop:for(int t = 1; t <= N; t++) {
				for(int i = 1; i <= N; i++)
					for(Pair next : arr[i]) {
						if(chk[next.v] > chk[i] + next.cost) {
							chk[next.v] = chk[i] + next.cost;
							if(t == N) {
								flag = true;
								break loop;
							}
						}
					}
			}
			
			System.out.println(flag ? "YES" : "NO");
		}
	}
}
class Pair {
	int v, cost;
	Pair(int v, int cost) {
		this.v = v;
		this.cost = cost;
	}
}