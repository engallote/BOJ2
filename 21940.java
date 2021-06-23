import java.util.*;

public class Main {
	static int N;
	static int[][] arr;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	N = sc.nextInt();
    	int M = sc.nextInt();
    	arr = new int[N + 1][N + 1];
    	
    	for(int i = 0; i <= N; i++) {
    		Arrays.fill(arr[i], 1000000);
    		arr[i][i] = 0;
    	}
    	
    	for(int i = 0; i < M; i++) {
    		int a = sc.nextInt();
    		int b = sc.nextInt();
    		int c = sc.nextInt();
    		arr[a][b] = Math.min(arr[a][b], c);
    	}
    	
    	int K = sc.nextInt();
    	int[] fr = new int[K];
    	
    	for(int i = 0; i < K; i++) 
    		fr[i] = sc.nextInt();
    	
    	for(int k = 1; k <= N; k++)
    		for(int i = 1; i <= N; i++)
    			for(int j = 1; j <= N; j++)
    				if(arr[i][k] + arr[k][j] < arr[i][j])
    					arr[i][j] = arr[i][k] + arr[k][j];
    	
    	int res = Integer.MAX_VALUE;
    	Queue<Integer> q = new LinkedList<>();
    	for(int i = 1; i <= N; i++) {
    		int max = 0;
    		for(int j = 0; j < K; j++)
    			max = Math.max(max, arr[fr[j]][i] + arr[i][fr[j]]);
    		
    		if(max < res) {
    			res = max;
    			q.clear();
    			q.offer(i);
    		}
    		else if(max == res) q.offer(i);
    	}
    	
    	while(!q.isEmpty())
    		System.out.print(q.poll() + " ");
	}
}