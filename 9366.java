import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			int c = sc.nextInt();
			int max = Math.max(a, Math.max(b, c));
			System.out.print("Case #" + test_case + ": ");
			
			if(a == b && b == c) System.out.println("equilateral");
			else if(a == b || b == c || a == c) 
			{
				if((a == max && a < b + c) || (b == max && b < a + c) || (c == max && c < a + b))
					System.out.println("isosceles");
				else System.out.println("invalid!");
			}
			else
			{
				if((a == max && a < b + c) || (b == max && b < a + c) || (c == max && c < a + b))
					System.out.println("scalene");
				else System.out.println("invalid!");
			}
		}
	}
}