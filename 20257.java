import java.util.*;

public class Main {
	static int[] arr = new int[4];
	static HashSet<Integer> hs = new HashSet<>();
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	for(int i = 0; i < 4; i++)
    		arr[i] = sc.nextInt();
    	
    	solve(0, 0, "");
    	
    	System.out.println(hs.size());
	}
	private static void solve(int idx, int chk, String str) {
		if(idx == 4) {
			char[] ch = str.toCharArray();
			Stack<Integer> st = new Stack<>();
			Stack<Character> op = new Stack<>();
			boolean flag = false;
			
			int num = 0;
			for(int i = 0; i < ch.length; i++) {
				if(ch[i] == '.') continue;
				else if(ch[i] == '*') {
					flag = true;
					int a = num, b = 0;
					
					if(a == 0) a = st.pop();
					
					for(int j = i + 1; j < ch.length; j++) {
						if(ch[j] == '+' || ch[j] == '-' || ch[j] == '*') break;
						b *= 10;
						b += ch[j] - '0';
						ch[j] = '.';
					}
					
					st.push(a * b);
					num = 0;
				}
				else if(ch[i] == '+' || ch[i] == '-') {
					if(num > 0)	st.push(num);
					num = 0;
					flag = true;
					op.push(ch[i]);
				}
				else {
					num *= 10;
					num += ch[i] - '0';
				}
			}
			
			if(num > 0) st.push(num);
			
			if(!flag) return;
			
			int res = st.get(0);
			
			for(int i = 1; i < st.size(); i++) {
				if(op.get(i - 1) == '+') res += st.get(i);
				else res -= st.get(i);
			}
			
			if(res >= 0) hs.add(res);
			
			return;
		}
		
		for(int i = 0; i < 4; i++)
			if((chk&(1<<i)) == 0) {
				if(idx == 0) solve(idx + 1, chk|(1<<i), str + "" + arr[i]);
				else {
					solve(idx + 1, chk|(1<<i), str + "" + arr[i]);
					solve(idx + 1, chk|(1<<i), str + "+" + arr[i]);
					solve(idx + 1, chk|(1<<i), str + "-" + arr[i]);
					solve(idx + 1, chk|(1<<i), str + "*" + arr[i]);
				}
			}
	}
}