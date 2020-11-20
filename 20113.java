import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		
		int max = -1, idx = 0;
		for(int i = 0; i < N; i++) {
			int num = sc.nextInt();
			if(num == 0) continue;
			++arr[num];
			
			if(max == arr[num]) {
				if(idx == 0) idx = num;
				else idx = -1;
			}
			else if(max < arr[num]) {
				max = arr[num];
				idx = num;
			}
		}
		
		System.out.println(idx <= 0 ? "skipped" : idx);
	}
}