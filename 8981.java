import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N], arr2 = new int[N], res = new int[N];
		
		for(int i = 0; i < N; i++) {
			arr[i] = sc.nextInt();
			arr2[i] = arr[i];
		}
		
		System.out.println(N);
		
		int idx = 0, cnt = 0, num = arr[0];
		
		while(cnt < N) {
			while(num == 0) {
				idx = (idx + 1) % N;
				num = arr[idx];
			}
			
			res[idx] = arr2[cnt];
			arr[idx] = 0;
			idx = (arr2[cnt] + idx) % N;
			num = arr[idx];
			cnt++;
		}
		
		for(int i = 0; i < N; i++)
			System.out.print(res[i] + " ");
	}
}