import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		long N = sc.nextLong();
		Stack<String> st = new Stack<>();
		
		if(N % 2 != 0) {
			N *= 2;
			st.push("[/] ");
		}
		
		while(N > 0) {
			if(N % 2 == 0) {
				if(N == 2) {
					st.push("[+] ");
					N -= 2;
					break;
				}
				N /= 2;
				st.push("[*] ");
			}
			else {
				N *= 2;
				if(!st.isEmpty()) st.pop();
				N += 2;
				st.push("[-] ");
			}
		}
		
		System.out.println(st.size());
		while(!st.isEmpty())
			System.out.print(st.pop() + " ");
	}
}