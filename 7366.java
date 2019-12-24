import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int res = 0;
			for(int i = 0; i < N; i++)
			{
				String str = sc.next();
				if(str.equals("sheep")) ++res;
			}
			
			System.out.println("Case " + test_case + ": This list contains " + res + " sheep.");
			System.out.println();
		}
	}
}