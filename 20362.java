import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String S = sc.next();
		HashMap<String, Integer> hm = new HashMap<>();
		boolean flag = true;
		int res = 0;
		
		while(--N >= 0) {
			String name = sc.next();
			String ans = sc.next();
			
			if(!flag) continue;
			if(name.equals(S)) {
				flag = false;
				res = hm.containsKey(ans) ? hm.get(ans) : 0;
			}
			
			if(hm.containsKey(ans)) hm.replace(ans, hm.get(ans) + 1);
			else hm.put(ans, 1);
		}
		
		System.out.println(res);
	}
}