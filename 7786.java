import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long l = sc.nextLong();
		long u = sc.nextLong();
		
		long res = solve(u) - solve(l - 1 >= 0 ? l - 1 : 0);
		System.out.println(res);
	}

	private static long solve(long num) {
		if(num < 10) return num * (num + 1) / 2;
		else if(num % 10 == 9) return 45 * (num / 10 + 1) + solve(num / 10) * 10;
		else return find(num) + solve(num-1);
	}

	private static long find(long num) {
		if(num < 10) return num;
		return find(num / 10) + find(num % 10);
	}
}