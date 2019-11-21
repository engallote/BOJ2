import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0)
		{
			int N = sc.nextInt();
			char[] ch = sc.next().toCharArray();
			if(N < 12)
			{
				System.out.println("invalid");
				continue;
			}
			boolean up = false, low = false, digit = false, symbol = false;
			for(char c : ch)
			{
				if(c >= 'A' && c <= 'Z') up = true;
				else if(c >= 'a' && c <= 'z') low = true;
				else if(c >= '0' && c <= '9') digit = true;
				else if(c == '+' || c == '_' || c == ')' || c == '(' || c == '*' || c == '&' || c == '^' || c == '%'
						|| c == '$' || c == '#' || c == '#' || c == '@' || c == '!' || c == '.' || c == ',' || c == '/'
						|| c == ';' || c == '{' || c == '}') symbol = true;
			}
			
			if(up && low && digit && symbol) System.out.println("valid");
			else System.out.println("invalid");
		}
	}
}