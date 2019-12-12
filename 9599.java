import java.util.*;

public class Main {
	static int N, k, s;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			N = sc.nextInt();
			k = sc.nextInt();
			s = sc.nextInt();
			
			if(N == 0 && k == 0 && s == 0) break;
			
			hs.clear();
			ArrayList<Integer> aly = new ArrayList<>();
			solve(1, 0, 0, aly);
			System.out.println(hs.size());
		}
	}
	private static void solve(int idx, int cnt, int sum, ArrayList<Integer> aly) {
		if(cnt == k)
		{
			if(sum == s) hs.add(aly.toString());
			return;
		}
		if(idx > N) return;
		aly.add(idx);
		solve(idx + 1, cnt + 1, sum + idx, aly);
		aly.remove(aly.size()-1);
		solve(idx + 1, cnt, sum, aly);
	}
}