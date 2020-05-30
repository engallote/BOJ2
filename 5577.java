import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		
		for(int i = 0; i < N; i++)
			arr[i] = sc.nextInt();
		
		int res = 0;
		for(int i = 0; i < N; i++){
			int tmp = arr[i];
			for(int j = 1; j <= 3; j++){
				arr[i] = j;
				int cnt = solve(i);
				res = Math.max(res, cnt);
			}
			arr[i] = tmp;
		}
		
		System.out.println(N-res);
	}
	private static int solve(int idx) {
		int cnt = 0;
		int l = idx, r = idx, count = 0;
		
		while(l >= 0 && r < N && arr[l] == arr[r]){
			int color = arr[l];
			count = 0;
			while(l >= 0 && arr[l] == color){
				--l;
				++count;
			}
			while(r < N && arr[r] == color){
				++r;
				++count;
			}
			if(count >= 4) cnt += count;
		}
		return cnt - 1;
	}
}