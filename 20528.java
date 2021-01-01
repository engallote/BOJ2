import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean flag = true;
		String str = sc.next();
		char pre = str.charAt(str.length() - 1);
		
		for(int i = 1; i < N; i++) {
			char[] ch = sc.next().toCharArray();
			
			if(ch[0] != pre) flag = false;
			pre = ch[ch.length - 1];
		}
		
		System.out.println(flag ? 1 : 0);
	}
}