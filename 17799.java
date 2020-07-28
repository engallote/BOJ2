import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		Arrays.sort(arr);
		
		int l = 0, r = N - 1, res = 0;
		while(l <= r){
			if(l == r){
				++res;
				break;
			}
			else if(arr[r] + arr[l] <= M){
				++l;
				--r;
				++res;
			}
			else{
				++res;
				--r;
			}
		}
		
		System.out.println(res);
	}
}