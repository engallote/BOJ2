import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		int[][] arr = new int[N + 1][M + 1];
		int idx = 0, min = Integer.MAX_VALUE;
		for(int i = 1; i <= N; i++)
			for(int j = 1; j <= M; j++)
			{
				arr[i][j] = sc.nextInt();
				arr[i][j] += arr[i][j-1];
				if(arr[i][j] >= K && min > j)
				{
					min = j;
					idx = i;
				}
			}
		
		System.out.println(idx + " " + min);
	}
}