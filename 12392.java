import java.util.*;

public class Main {
	static int N;
	static int[] arr;
	static boolean flag;
	static ArrayList<Integer> num1 = new ArrayList<>(), num2 = new ArrayList<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			N = sc.nextInt();
			arr = new int[N];
			num1.clear();
			num2.clear();
			flag = false;
			
			for(int i = 0; i < N; i++)
				arr[i] = sc.nextInt();
			
			System.out.println("Case #" + test_case + ":");
			solve(0, 0, 0, 0);
			if(!flag) System.out.println("Impossible");
		}
	}
	private static void solve(int idx, int chk, int sum1, int sum2) {
		if(flag) return;
		if(idx == N) {
			if(sum1 > 0 && sum1 == sum2) {
				flag = true;
				for(int num : num1)
					System.out.print(num + " ");
				System.out.println();
				for(int num : num2)
					System.out.print(num + " ");
				System.out.println();
			}
			return;
		}
		
		solve(idx + 1, chk, sum1, sum2);
		num1.add(arr[idx]);
		solve(idx + 1, chk, sum1 + arr[idx], sum2);
		num1.remove(num1.size()-1);
		num2.add(arr[idx]);
		solve(idx + 1, chk, sum1, sum2 + arr[idx]);
		num2.remove(num2.size()-1);
	}
}