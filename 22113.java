import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int M = sc.nextInt();
    	int[] order = new int[M];
    	int[][] arr = new int[N+1][N+1];
    	
    	for(int i = 0; i < M; i++)
    		order[i] = sc.nextInt();
    	
    	for(int i = 1; i <= N; i++)
    		for(int j = 1; j <= N; j++)
    			arr[i][j] = sc.nextInt();
    	
    	int res = 0;
    	for(int i = 1; i < M; i++)
    		res += arr[order[i-1]][order[i]];
    	
    	System.out.println(res);
	}
}