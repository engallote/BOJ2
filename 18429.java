import java.util.*;

public class Main {
	static int N, K;
	static int[] arr;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        K = sc.nextInt();
        arr = new int[N];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        
        int res = solve(500, 0, 0);
        System.out.println(res);
    }
	private static int solve(int num, int chk, int cnt) {
		if(cnt == N) return 1;
		int ret = 0;
		
		for(int i = 0; i < N; i++)
			if((chk&(1<<i)) == 0 && num + arr[i] - K >= 500)
				ret += solve(num + arr[i] - K, chk|(1<<i), cnt + 1);
		
		return ret;
	}
}