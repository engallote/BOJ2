import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T =  sc.nextInt();
		while(--T >= 0){
			int N = sc.nextInt();
			int p = sc.nextInt();
			int q = sc.nextInt();
			long[][] arr = new long[p + 1][p + 1];
			int[] h = new int[N];
			
			for(int i = 1; i <= p; i++){
				Arrays.fill(arr[i], 3000000000l);
				arr[i][i] = 0;
			}
			
			for(int i = 0; i < N; i++)
				h[i] = sc.nextInt();
			
			for(int i = 0; i < q; i++){
				int a = sc.nextInt();
				int b = sc.nextInt();
				long c = sc.nextLong();
				arr[a][b] = Math.min(arr[a][b], c);
				arr[b][a] = Math.min(arr[b][a], c);
			}
			
			for(int k = 1; k <= p; k++)
				for(int i = 1; i <= p; i++)
					for(int j = 1; j <= p; j++)
						if(arr[i][k] + arr[k][j] < arr[i][j])
							arr[i][j] = arr[i][k] + arr[k][j];
						
			long res = Long.MAX_VALUE;
			int idx = 0;
			
			for(int i = 1; i <= p; i++){
				long sum = 0;
				for(int j = 0; j < N; j++){
					if(arr[h[j]][i] == 3000000000l){
						sum = Long.MAX_VALUE;
						break;
					}
					sum += arr[h[j]][i] * arr[h[j]][i];
				}
				if(res > sum){
					idx = i;
					res = sum;
				}
			}
			
			System.out.println(idx + " " + res);
		}
	}
}