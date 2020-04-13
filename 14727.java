import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		long[] arr = new long[N];
		long res = 0, sum;
		
		for(int i = 0; i < N; i++){
			arr[i] = sc.nextLong();
			res = Math.max(res, arr[i]);
		}
		
		for(int i = 0; i < N; i++){
			int l = 0, r = N - 1;
			for(int j = i - 1; j >= 0; j--)
				if(arr[j] < arr[i]){
					l = j + 1;
					break;
				}
			for(int j = i + 1; j < N; j++)
				if(arr[j] < arr[i]){
					r = j - 1;
					break;
				}
			sum = (r - l + 1) * arr[i];
			res = Math.max(res, sum);
		}
		
		System.out.println(res);
	}
}