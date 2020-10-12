import java.util.*;

public class Main {
	static int D, P;
	static long max = -1;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		D = sc.nextInt();
		P = sc.nextInt();
		solve(1l, 0, 9);
		
		System.out.println(max);
	}
	private static void solve(long mul, int cnt, int num) {
		if(String.valueOf(mul).length() > D) return;
		if(cnt == P){
			max = Math.max(max, mul);
			return;
		}
		
		for(int i = num; i >= 2; i--)
			solve(mul * i, cnt + 1, i);
	}
}