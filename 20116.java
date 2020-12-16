import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long L = sc.nextLong();
		long[] arr = new long[N];
		
		double mid = 0, sum = 0, cnt = 1;
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextLong();
		
		boolean flag = true;
		mid = arr[N - 1];
		sum = arr[N - 1];
		for(int i = N - 2; i >= 0; i--) {
			++cnt;
			sum += arr[i];
			
			if(arr[i] - L < mid && mid < arr[i] + L) mid = sum / cnt;
			else {
				flag = false;
				break;
			}
		}
		
		if(flag) System.out.println("stable");
		else System.out.println("unstable");
	}
}