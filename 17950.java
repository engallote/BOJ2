import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int H = sc.nextInt();
		int x = sc.nextInt();
		long res = 0, mul = x, mod = 1000000007;
		
		for(int i = 1; i <= H; i++){
			long num = sc.nextLong();
			res += mul * num;
			res %= mod;
			mul *= x;
			mul %= mod;
		}
		
		System.out.println(res);
	}
}