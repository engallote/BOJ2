import java.util.*;

public class Main {
	static int max, min;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		max = -1;
		min = Integer.MAX_VALUE;
		
		solve(str, 0);
		System.out.println(min + " " + max);
	}
	private static void solve(String str, int num) {
		if(str.length() == 1) {
			if((str.charAt(0) - '0') % 2 != 0) {
				max = Math.max(max, num + 1);
				min = Math.min(min, num + 1);
			}
			else {
				max = Math.max(max, num);
				min = Math.min(min, num);
			}
			return;
		}
		
		int tmp = 0;
		for(char c : str.toCharArray())
			if((c - '0') % 2 != 0) ++tmp;
		
		if(str.length() == 2) {
			int num1 = str.charAt(0) - '0', num2 = str.charAt(1) - '0';
			
			solve(Integer.toString(num1 + num2), num + tmp);
		}
		else if(str.length() == 3) {
			int num1 = str.charAt(0) - '0', num2 = str.charAt(1) - '0', num3 = str.charAt(2) - '0';

			solve(Integer.toString(num1 + num2 + num3), num + tmp);
		}
		else {
			for(int i = 1; i < str.length() - 1; i++)
				for(int j = 1; j < str.length() - 1; j++) {
					if(i + j >= str.length()) break;
					int num1 = Integer.parseInt(str.substring(0, i));
					int num2 = Integer.parseInt(str.substring(i, i+j));
					int num3 = Integer.parseInt(str.substring(i+j));
					
					solve(Integer.toString(num1 + num2+ num3), num + tmp);
				}
		}
	}
}