import java.util.*;

public class Main {
	static int N, max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
	static int[] arr, op;
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        N = sc.nextInt();
        arr = new int[N];
        op = new int[4];
        
        for(int i = 0; i < N; i++)
        	arr[i] = sc.nextInt();
        for(int i = 0; i < 4; i++)
        	op[i] = sc.nextInt();
        
        solve(1, arr[0]+"");
        System.out.println(max);
        System.out.println(min);
    }
	private static void solve(int idx, String str) {
		if(idx == N){
			cal(str);
			return;
		}
		for(int i = 0; i < 4; i++){
			if(op[i] > 0){
				--op[i];
				if(i == 0) solve(idx + 1, str + "+" + arr[idx]);
				else if(i == 1) solve(idx + 1, str + "-" + arr[idx]);
				else if(i == 2) solve(idx + 1, str + "*" + arr[idx]);
				else solve(idx + 1, str + "/" + arr[idx]);
				++op[i];
			}
		}
	}
	private static void cal(String str) {
		Stack<Integer> st = new Stack<>();
		char[] ch = str.toCharArray();
		boolean[] chk = new boolean[ch.length];
		int num = 0;
		char c = '+';
		
		for(int i = 0; i < ch.length; i++){
			if(chk[i]) continue;
			if(ch[i] >= '0' && ch[i] <= '9'){
				num *= 10;
				num += ch[i]-'0';
			}
			else{
				if(c == '*' || c == '/'){
					int num2 = st.pop();
					if(c == '*') st.push(num * num2);
					else st.push(num2 / num);
				}
				else if(c == '-') st.push(-num);
				else st.push(num);
				c = ch[i];
				num = 0;
			}
		}
		
		if(c == '+') st.push(num);
		else if(c == '-') st.push(-num);
		else if(c == '*'){
			int tmp = st.pop();
			st.push(num * tmp);
		}
		else{
			int tmp = st.pop();
			st.push(tmp / num);
		}
		
		num = 0;
		for(int i = 0; i < st.size(); i++)
			num += st.get(i);
		
		max = Math.max(max, num);
		min = Math.min(min, num);
	}
}