import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int res = 1, max = arr[N-1];
		
		for(int i = N - 2; i >= 0; i--)
			if(max < arr[i])
			{
				max = arr[i];
				++res;
			}
		System.out.println(res);
	}
}