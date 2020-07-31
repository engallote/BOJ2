import java.util.*;

public class Main {
	static int N, V, E, K, S;
	static int[][] chk;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		V = sc.nextInt();
		E = sc.nextInt();
		K = sc.nextInt();
		S = sc.nextInt();
		chk = new int[V+1][V+1];
		int[] start = new int[N + 1];
		
		for(int i = 0; i <= V; i++)
			Arrays.fill(chk[i], Integer.MAX_VALUE);
		
		for(int i = 1; i <= N; i++){
			start[i] = sc.nextInt();
			chk[start[i]][start[i]] = 0;
		}
		
		for(int i = 0; i < E; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int d = sc.nextInt();
			chk[a][b] = chk[b][a] = d;
		}
		
		for(int k = 1; k <= V; k++)
			for(int i = 1; i <= V; i++)
				for(int j = 1; j <= V; j++)
					if(chk[i][k] != Integer.MAX_VALUE && chk[k][j] != Integer.MAX_VALUE
						&& chk[i][k] + chk[k][j] < chk[i][j]){
						chk[i][j] = chk[i][k] + chk[k][j];
					}
		
		int sum = 0;
		for(int i = 1; i <= N; i++){
			if(chk[start[i]][K] == Integer.MAX_VALUE && chk[start[i]][S] == Integer.MAX_VALUE){
				System.out.println(-1);
				return;
			}
			sum += chk[start[i]][K] == Integer.MAX_VALUE ? -1 : chk[start[i]][K];
			sum += chk[start[i]][S] == Integer.MAX_VALUE ? -1 : chk[start[i]][S];
		}
		
		System.out.println(sum);
	}
}