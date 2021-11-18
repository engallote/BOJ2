import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[] arr = new int[M];
    	int[][] path = new int[N][N];
    	
    	for(int i = 0; i < M; i++) arr[i] = sc.nextInt() - 1;
    	
    	for(int i = 0; i < N; i++)
    		for(int j = 0; j < N; j++)
    			path[i][j] = sc.nextInt();
    	
    	for(int k = 0; k < N; k++)
    		for(int i = 0; i < N; i++)
    			for(int j = 0; j < N; j++)
    				if(path[i][k] + path[k][j] < path[i][j])
    					path[i][j] = path[i][k] + path[k][j];
    				
    	int res = 0, idx = 0;
    	while(idx < M) {
    		res += path[arr[idx]][arr[idx + 1]];
    		idx += 1;
    		if(idx == M - 1) break;
    	}
    	
    	System.out.println(res);
	}
}