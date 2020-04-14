import java.util.*;

public class Main {
	static int N;
	static long[][] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		int M = sc.nextInt();
		arr = new long[N][3];
		
		for(int i = 0; i < N; i++){
			arr[i][0] = sc.nextLong();
			arr[i][1] = sc.nextLong();
			arr[i][2] = sc.nextLong();
		}
		
		long l = 1, r = Long.MAX_VALUE - 1, mid, res = Long.MAX_VALUE;
		while(l <= r){
			mid = (l + r) / 2;
			
			if(can(M, mid)){
				res = Math.min(res, mid);
				r = mid - 1;
			}
			else l = mid + 1;
		}
		
		System.out.println(res);
	}
	private static boolean can(int m, long mid) {
		long at = m;
		long hp = mid;
		
		for(int i = 0; i < N; i++){
			if(arr[i][0] == 1){
				long cnt = arr[i][2] / at;
				if(arr[i][2] % at == 0) cnt -= 1;
				if(hp - (cnt * arr[i][1]) <= 0) return false;
				hp -= cnt * arr[i][1];
			}
			else{
				at += arr[i][1];
				hp = Math.min(hp + arr[i][2], mid);
			}
		}
		
		return true;
	}
}