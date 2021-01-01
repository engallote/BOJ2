import java.util.*;

public class Main {
	static ArrayList<String> arr;
	static int[] cnt;
	static HashMap<String, Integer> hm = new HashMap<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int N = sc.nextInt();
			arr = new ArrayList<>();
			cnt = new int[16];
			hm.clear();
			int res = 100000000, idx = 0;
			
			for(int i = 0; i < N; i++) {
				String str = sc.next();
				
				if(hm.containsKey(str)) cnt[hm.get(str)] += 1;
				else {
					arr.add(str);
					hm.put(str, idx);
					cnt[idx] += 1;
					idx += 1;
				}
				
				if(cnt[hm.get(str)] >= 3) res = 0;
			}
			
			if(res != 0) res = solve(0, "", "", "");
			System.out.println(res);
		}
	}
	private static int solve(int idx, String a, String b, String c) {
		if(idx == 3) {
			int sum = 0;
			
			for(int i = 0; i < 4; i++) {
				if(a.charAt(i) != b.charAt(i)) ++sum;
				if(b.charAt(i) != c.charAt(i)) ++sum;
				if(a.charAt(i) != c.charAt(i)) ++sum;
			}
			
			return sum;
		}
		
		int ret = 100000000;
		for(int i = 0; i < arr.size(); i++)
			if(cnt[hm.get(arr.get(i))] > 0) {
				cnt[hm.get(arr.get(i))] -= 1;
				
				if(a.length() == 0)	ret = Math.min(ret, solve(idx + 1, arr.get(i), b, c));
				if(b.length() == 0)	ret = Math.min(ret, solve(idx + 1, a, arr.get(i), c));
				if(c.length() == 0)	ret = Math.min(ret, solve(idx + 1, a, b, arr.get(i)));
				
				cnt[hm.get(arr.get(i))] += 1;
			}
		
		return ret;
	}
}