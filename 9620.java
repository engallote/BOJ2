import java.util.*;

public class Main {
	static ArrayList<Pair> arr = new ArrayList<>();
	static int[][] dp = new int[20][11];
	static int len;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0)
		{
			arr.clear();
			for(int i = 0; i < 20; i++) Arrays.fill(dp[i], -1);
			while(true)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				if(a == 0 && b == 0) break;
				arr.add(new Pair(a, b));
			}
			Collections.sort(arr);
			len = arr.size();
			int res = solve(0, 0);
			System.out.println(res);
		}
	}
	private static int solve(int idx, int end) {
		if(idx >= len) return 0;
		if(dp[idx][end] != -1) return dp[idx][end];
		int ret = 0;
		
		for(int i = idx; i < len; i++)
			if(arr.get(i).start >= end) ret = Math.max(ret, solve(i + 1, arr.get(i).end) + 1);
		
		return dp[idx][end] = ret;
	}
}
class Pair implements Comparable<Pair>{
	int start, end;
	Pair(int start, int end)
	{
		this.start = start;
		this.end = end;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.start > this.start) return -1;
		else if(o.start == this.start)
		{
			if(o.end > this.end) return -1;
			else if(o.end == this.end) return 0;
			else return 1;
		}
		else return 1;
	}
}