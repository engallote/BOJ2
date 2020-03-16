import java.util.*;

public class Main {
	static int N, K;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext()){
			N = sc.nextInt();
			K = sc.nextInt();
			
			if(K == 0){
				System.out.println(1);
				continue;
			}
			if(9 * N < K){
				System.out.println(0);
				continue;
			}
			
			int res = solve(0, 0);
			System.out.println(res);
		}
	}
	private static int solve(int idx, int sum) {
		if(idx == N){
			if(sum == K) return 1;
			else return 0;
		}

		int ret = 0;
		for(int i = 0; i <= 9; i++)
			if(sum + i <= K) ret += solve(idx + 1, sum + i);

		return ret;
	}
}