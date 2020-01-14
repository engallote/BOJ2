import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N + 1], sum = new int[N + 1];
		
		for(int i = 1; i <= N; i++){
			arr[i] = sc.nextInt();
			sum[i] = arr[i] + sum[i-1];
		}
		
		while(--M >= 0){
			int num = sc.nextInt();
			
			int l = 1, r = N, mid, res = 0;
			while(l <= r){
				mid = (l + r) / 2;
				if(sum[mid] > num) r = mid - 1;
				else{
					res = Math.max(res, mid);
					l = mid + 1;
				}
			}
			
			System.out.println(res);
		}
	}
}