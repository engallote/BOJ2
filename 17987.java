import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		char[] ch = sc.next().toCharArray();
		int len = ch.length;
		int sp = 1;
		
		StringBuilder sb = new StringBuilder();
		sb.append("OOH");
		
		for(int i = 0; i < len-2; i++){
			if(sp == 0)	sb.append("A");
			else sb.append("W");
			++sp;
			sp %= 2;
		}
		
		sb.reverse();
		System.out.println(sb.toString());
	}
}