import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[][] arr = new int[N+1][N+1];
		
		for(int i = 0; i < N - 1; i++)
			arr[sc.nextInt()][sc.nextInt()] = sc.nextInt();
		
		int[] res = new int[N + 1];
		
		for(int i = 1; i < N; i++){
			if(arr[i][i+1] == 0) res[i+1] = res[i];
			else res[i+1] = res[i] == 0 ? 1 : 0;
		}
		
		System.out.println(res[N]);
	}
}