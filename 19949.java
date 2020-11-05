import java.util.*;

public class Main {
	static int[] arr;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		arr = new int[10];
		for(int i = 0; i < 10; i++)
			arr[i] = sc.nextInt();
		
		int res = solve(0, 0, 0, 0);
		System.out.println(res);
	}
	private static int solve(int sum, int idx, int p1, int p2) {
		if(idx == 10) {
			if(sum >= 5) return 1;
			return 0;
		}
		
		int ret = 0;
		for(int i = 1; i <= 5; i++) {
			if(p1 == i && p2 == i) continue;
			if(arr[idx] == i) ret += solve(sum + 1, idx + 1, i, p1);
			else ret += solve(sum, idx + 1, i, p1);
		}
		return ret;
	}
}