import java.util.*;

public class Main {
	static int N;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int[][] path = new int[N + 1][N + 1];
    	
    	for(int i = 1; i <= N; i++) {
    		Arrays.fill(path[i], 100000000);
    		path[i][i] = 0;
    	}
    	
    	for(int i = 0; i < N - 1; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		path[a][b] = 1;
    	}
    	
    	for(int k = 1; k <= N; k++)
    		for(int i = 1; i <= N; i++)
    			for(int j = 1; j <= N; j++)
    				if(path[i][k] + path[k][j] < path[i][j])
    					path[i][j] = path[i][k] + path[k][j];
    	
    	int[] cnt = new int[N + 1];
    	for(int i = 1; i <= N; i++) {
    		for(int j = 1; j <= N; j++)
    			if(path[i][j] != 100000000) cnt[j] += 1;
    	}
    	
    	for(int i = 1; i <= N; i++)
    		if(cnt[i] == N) {
    			System.out.println(i);
    			return;
    		}
    	System.out.println(-1);
	}
}