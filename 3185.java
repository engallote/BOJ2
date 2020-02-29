import java.util.*;

public class Main {
	static int len, realLen;
	static char[] ch;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		ch = sc.nextLine().toCharArray();
		len = ch.length;
		realLen = 0;
		first();
		
		int len2 = (int)Math.round((double)realLen / 3.0);
		second(len2);
		
		String res = third(len2);
		if(res.equals("-1")){
			len2 = (int)(Math.round((double)realLen / 3.0 * 2.0));
			second(len2);
		}
		else System.out.println(res);
	}
	private static String third(int len2) {
		StringBuilder sb = new StringBuilder();
		boolean flag = false;
		int tmp = 0;
		for(int i = 0; i < len; i++){
			if(tmp < len2){
				sb.append(ch[i]);
				if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) ++tmp;
			}
			else{
				if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')){
					if(mo(ch[i])){
						flag = true;
						sb.append(ch[i]);
					}
					else sb.append(".");
				}
				else sb.append(ch[i]);
			}
		}
		if(flag) return sb.toString();
		return "-1";
	}
	private static void second(int len2) {
		int tmp = 0;
		for(int i = 0; i < len; i++){
			if(tmp < len2){
				System.out.print(ch[i]);
				if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')) ++tmp;
			}
			else{
				if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z'))
					System.out.print(".");
				else System.out.print(ch[i]);
			}
		}
		System.out.println();
	}
	private static void first() {
		for(int i = 0; i < len; i++){
			if((ch[i] >= 'a' && ch[i] <= 'z') || (ch[i] >= 'A' && ch[i] <= 'Z')){
				System.out.print(".");
				++realLen;
			}
			else System.out.print(ch[i]);
		}
		System.out.println();
	}
	private static boolean mo(char c) {
		if(c == 'a' || c == 'e' || c == 'i' || c == 'o' || c == 'u') return true;
		if(c == 'A' || c == 'E' || c == 'I' || c == 'O' || c == 'U') return true;
		return false;
	}
}