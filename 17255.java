import java.util.*;

public class Main {
	static int len;
	static char[] ch;
	static HashSet<String> hs = new HashSet<>();
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ch = sc.next().toCharArray();
		len = ch.length;
		
		for(int i = 0; i < len; i++)
			solve(i - 1, i + 1, ch[i] + "", ch[i] + ">");
		
		System.out.println(hs.size());
	}
	private static void solve(int l, int r, String num, String str) {
		if(l < 0 && r == len){
			hs.add(str);
			return;
		}
		
		if(l - 1 >= -1) solve(l - 1, r, ch[l] + "" + num, str + (ch[l] + "" + num) + ">");
		if(r + 1 <= len) solve(l, r + 1, num + ch[r] + "", str + (num + ch[r] + "") + ">");
	}
}