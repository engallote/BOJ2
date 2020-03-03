import java.util.*;

public class Main {
	static int N, M, s, j;
	static int[][] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        M = sc.nextInt();
        int INF = Integer.MAX_VALUE;
        arr = new int[N + 1][N + 1];
        for(int i = 0; i <= N; i++){
        	Arrays.fill(arr[i], INF);
        	arr[i][i] = 0;
        }
        
        for(int i = 0; i < M; i++){
        	int a = sc.nextInt();
        	int b = sc.nextInt();
        	int c = sc.nextInt();
        	
        	arr[a][b] = Math.min(arr[a][b], c);
        	arr[b][a] = arr[a][b];
        }
        
        for(int k = 1; k <= N; k++)
        	for(int i = 1; i <= N; i++)
        		for(int j = 1; j <= N; j++)
        			if(arr[i][k] != INF && arr[k][j] != INF){
        				if(arr[i][k] + arr[k][j] < arr[i][j]){
            				arr[i][j] = arr[i][k] + arr[k][j];
            				arr[j][i] = arr[i][j];
            			}
        			}
        
        j = sc.nextInt();
        s = sc.nextInt();
        
        int sum = INF, min = INF, idx = -1;
        for(int i = 1; i <= N; i++){
        	if(i == j || i == s || arr[s][i] == INF || arr[j][i] == INF) continue;
        	sum = Math.min(sum, arr[s][i] + arr[j][i]);
        	
        }
        for(int i = 1; i <= N; i++){
        	if(i == j || i == s || arr[j][i] > arr[s][i]) continue;
        	if(arr[s][i] + arr[j][i] == sum && min > arr[j][i]){
        		min = arr[j][i];
        		idx = i;
        	}
        }
        	
        System.out.println(idx);
    }
}