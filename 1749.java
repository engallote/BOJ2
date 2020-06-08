import java.util.*;

public class Main {
	static int N, M;
	static long[][] arr, sum;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		arr = new long[N+1][M+1];
		sum = new long[N+1][M+1];
		long res = Long.MIN_VALUE;
		
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++){
				arr[i][j] = sc.nextLong();
				res = Math.max(res, arr[i][j]);
				sum[i][j] = sum[i][j-1] + arr[i][j];
			}
		
		long tmp = 0;
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++){
				for(int k = j; k <= M; k++){
					tmp = 0;
					for(int a = i; a <= N; a++){
						tmp += sum[a][k] - sum[a][j-1];
						res = Math.max(res, tmp);
					}
				}
			}
		
		System.out.println(res);
	}
}