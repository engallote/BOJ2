import java.util.*;

public class Main {
	static int N;
	static HashSet<String> hs = new HashSet<>();
	static int[] arr, num;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		arr = new int[N];
		num = new int[10];
		for(int i = 0; i < N; i++) 
			arr[i] = sc.nextInt();
		
		int M = sc.nextInt();
		while(--M >= 0) num[sc.nextInt()] = 1;
		
		solve(0, 0, 0, 0);
		System.out.println(hs.size());
	}

	private static void solve(long num1, int cnt1, long num2, int cnt2) {
		if(cnt1 == arr[0] && cnt2 == arr[1])
		{
			long ret1 = 0, ret2 = 0, ret3 = 0, ret4 = 0;
			
			if(arr[1] == 1)
			{
				ret1 = num1 * num2;
				if(Long.toString(ret1).length() != arr[2] || Long.toString(ret1).length() != arr[3]) return;
				while(ret1 > 0)
				{
					if(num[(int)(ret1 % 10)] == 0) return;
					ret1 /= 10;
				}
			}
			else if(arr[1] == 2)
			{
				ret1 = (num2 % 10) * num1;
				ret2 = (num2 / 10) * num1;
				ret3 = ret2 * 10 + ret1;
				if(Long.toString(ret1).length() != arr[2] || Long.toString(ret2).length() != arr[3]
					|| Long.toString(ret3).length() != arr[4]) return;
				while(ret1 > 0)
				{
					if(num[(int)(ret1 % 10)] == 0) return;
					ret1 /= 10;
				}
				while(ret2 > 0)
				{
					if(num[(int)(ret2 % 10)] == 0) return;
					ret2 /= 10;
				}
				while(ret3 > 0)
				{
					if(num[(int)(ret3 % 10)] == 0) return;
					ret3 /= 10;
				}
			}
			else if(arr[1] == 3)
			{
				ret1 = (num2 % 10) * num1;
				ret2 = (num2 / 10 % 10) * num1;
				ret3 = (num2 / 100) * num1;
				ret4 = (ret3 * 100) + (ret2 * 10) + ret1;
				long tmp = ret4;
				if(Long.toString(ret1).length() != arr[2] || Long.toString(ret2).length() != arr[3]
				   || Long.toString(ret3).length() != arr[4] || Long.toString(ret4).length() != arr[5]) return;
				while(ret1 > 0)
				{
					if(num[(int)(ret1 % 10)] == 0) return;
					ret1 /= 10;
				}
				while(ret2 > 0)
				{
					if(num[(int)(ret2 % 10)] == 0) return;
					ret2 /= 10;
				}
				while(ret3 > 0)
				{
					if(num[(int)(ret3 % 10)] == 0) return;
					ret3 /= 10;
				}
				while(ret4 > 0)
				{
					if(num[(int)(ret4 % 10)] == 0) return;
					ret4 /= 10;
				}
			}
			hs.add(num1 + " " + num2);
			return;
		}
		for(int i = 1; i <= 9; i++)
		{
			if(num[i] == 0) continue;
			if(cnt1 < arr[0]) solve(num1 * 10 + i, cnt1 + 1, num2, cnt2);
			else solve(num1, cnt1, num2 * 10 + i, cnt2 + 1);
		}
	}
}