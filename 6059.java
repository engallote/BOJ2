import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		
		for(int i = 1; i <= N; i++){
			Arrays.fill(arr[i], 1000000000);
			arr[i][i] = 0;
		}
		
		for(int i = 1; i < N; i++){
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			arr[a][b] = Math.min(arr[a][b], c);
			arr[b][a] = arr[a][b];
		}
		
		for(int k = 1; k <= N; k++)
			for(int i = 1; i <= N; i++)
				for(int j = 1; j <= N; j++)
					if(arr[i][k] + arr[k][j] < arr[i][j])
						arr[i][j] = arr[i][k] + arr[k][j];
		
		while(--Q >= 0){
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(arr[a][b]);
		}
	}
}