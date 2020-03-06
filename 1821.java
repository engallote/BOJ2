import java.util.*;

public class Main {
	static int N, F;
	static boolean flag;
	static boolean[] chk = new boolean[11];
	static int[] res = new int[11], tmp = new int[11];
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		F = sc.nextInt();
		flag = false;
		solve(0);
	}
	private static void solve(int idx) {
		if(flag) return;
		if(idx == N){
			if(sum()){
				flag = true;
				for(int i = 0; i < N; i++)
					System.out.print(res[i] + " ");
				System.out.println();
			}
			return;
		}
		
		for(int i = 1; i <= N; i++)
			if(!chk[i]){
				chk[i] = true;
				res[idx] = i;
				solve(idx + 1);
				res[idx] = 0;
				chk[i] = false;
			}
	}
	private static boolean sum() {
		int cnt = 0;
		for(int i = 0; i < N; i++)
			tmp[i] = res[i];
		
		while(++cnt < N){
			for(int i = 0; i < N - 1; i++)
				tmp[i] = tmp[i] + tmp[i+1];
		}
		
		return tmp[0] == F ? true : false;
	}
}