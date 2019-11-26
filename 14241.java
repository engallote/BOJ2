import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int res = arr[N-1] * arr[N-2], sum = arr[N-1] + arr[N-2];
		
		for(int i = N - 2; i > 0; i--)
		{
			res += sum * arr[i-1];
			sum = sum + arr[i-1];
		}
		System.out.println(res);
	}
}