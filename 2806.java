import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		String str = sc.next();
		char[] ch = new char[N + 1];
		
		for(int i = 0; i < N; i++)
			ch[i] = str.charAt(i);
		ch[N] = 'A';
		
		int res = 0;
		for(int i = 0; i < N; i++) {
			if(ch[i] == ch[i + 1]) continue;
			else {
				if(i + 1 <= N && i > 0 && ch[i - 1] == ch[i + 1]) {
					ch[i] = ch[i + 1];
					continue;
				}
				++res;
			}
		}
		
		System.out.println(res);
	}
}