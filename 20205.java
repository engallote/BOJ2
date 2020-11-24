import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int[][] res = new int[N * K][N * K];
		int cnt = 0, rc = 0;
		for(int i = 0; i < N; i++) {
			for(int j = 0; j < N; j++) {
				int num = sc.nextInt();
				
				int r = K * rc, c = K * cnt;
				
				for(int k = r; k < r + K; k++)
					for(int l = c; l < c + K; l++)
						res[k][l] = num;
				++cnt;
			}
			++rc;
			cnt = 0;
		}
		
		for(int i = 0; i < N * K; i++) {
			for(int j = 0; j < N * K; j++)
				System.out.print(res[i][j] + " ");
			System.out.println();
		}
	}
}