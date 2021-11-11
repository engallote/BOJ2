import java.util.*;

public class Main {
	static boolean flag = true;
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	String str = sc.next();
    	
    	solve(str, 0, str.length() - 1);
    	
    	if(flag) System.out.println("AKARAKA");
    	else System.out.println("IPSELENTI");
	}
	private static void solve(String str, int s, int e) {
		if(!flag || e - s == 1 || s >= e) return;
		char[] ch = str.toCharArray();
		
		int l = s, r = e;
		while(l <= r) {
			if(ch[l] != ch[r]) {
				flag = false;
				break;
			}
			++l;
			--r;
		}
		
		if(flag) {
			int len = str.length() / 2;
			solve(str.substring(0, len), s, len - 1);
			solve(str.substring(str.length() - len), 0, len - 1);
		}
	}
}