import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int l = 0, r = N - 1, sum = 0;
		while(l <= r) {
			if(l == r) {
				sum += arr[l];
				break;
			}
			sum += arr[r] * 2;
			++l;
			--r;
		}
		
		System.out.println(sum);
	}
}