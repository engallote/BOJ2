import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		String str = sc.next();
		int[] arr = new int[str.length()];
		
		StringBuilder sb = new StringBuilder();
		for(int i = 0; i < ch.length; i++)
			if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z'))
				sb.append(ch[i]);
		
		for(int i = 1, j = 0; i < str.length(); i++) {
			while(j > 0 && str.charAt(i) != str.charAt(j)) j = arr[j - 1];
			if(str.charAt(i) == str.charAt(j)) arr[i] = ++j;
		}
		
		for(int i = 0, j = 0; i < sb.length(); i++) {
			while(j > 0 && sb.charAt(i) != str.charAt(j)) j = arr[j - 1];
			if(sb.charAt(i) == str.charAt(j)) {
				if(j == str.length() - 1) {
					System.out.println(1);
					return;
				}
				++j;
			}
		}
		
		System.out.println(0);
	}
}