import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N][N], sum = new int[N][N];
		int res = -100000000;
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				arr[i][j] = sc.nextInt();
				res = Math.max(res, arr[i][j]);
				sum[i][j] = arr[i][j];
				if(j > 0) sum[i][j] += sum[i][j-1];
			}
		
		
		for(int i = 0; i < N; i++)
			for(int j = 0; j < N; j++) {
				for(int k = 1; i + k < N && j + k < N; k++) {
					int tmp = 0;
					
					for(int l = i; l <= i + k; l++) {
						tmp += sum[l][j + k];
						if(j > 0) tmp -= sum[l][j - 1];
					}
					
					res = Math.max(res, tmp);
				}
			}
		
		System.out.println(res);
	}
}