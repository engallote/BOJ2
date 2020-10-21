import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		boolean flag = true;
		
		for(int i = 0; i < ch.length / 2; i++) {
			if(ch[i] != ch[ch.length - i - 1]) {
				System.out.println(ch.length);
				return;
			}
			if(ch[i] != ch[i + 1]) flag = false;
		}
		
		System.out.println(flag ? -1 : ch.length - 1);
	}
}