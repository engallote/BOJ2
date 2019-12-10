import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		HashSet<Character> hs = new HashSet<>();
		int[] alp = new int[26];
		for(char c : ch)
		{
			hs.add(c);
			alp[c-'a'] += 1;
		}
		
		if(hs.size() <= 2) System.out.println(0);
		else
		{
			Arrays.sort(alp);
			int res = 0;
			for(int i = 23; i >= 0; i--)
				res += alp[i];
			System.out.println(res);
		}
	}
}