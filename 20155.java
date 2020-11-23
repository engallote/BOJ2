import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int[] arr = new int[N + 1];
		int max = 0;
		
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			++arr[num];
			max = Math.max(max, arr[num]);
		}
		
		System.out.println(max);
	}
}