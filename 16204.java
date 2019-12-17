import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int K = sc.nextInt();
		
		int res = Math.min(M, K) + (N - Math.max(M, K));
		System.out.println(res);
	}
}