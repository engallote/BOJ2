import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int Q = sc.nextInt();
		int[] arr = new int[N + 1], sum = new int[N + 1];
		
		for(int i = 1; i <= N; i++)
		{
			arr[i] = sc.nextInt();
			sum[i] = arr[i] + sum[i-1];
		}
		
		while(--Q >= 0)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			System.out.println(sum[b]-sum[a-1]);
		}
	}
}