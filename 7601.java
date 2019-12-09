import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true)
		{
			int N = sc.nextInt();
			int D = sc.nextInt();
			if(N == 0 && D == 0) break;
			int re = sc.nextInt();
			int re2 = sc.nextInt();
			if(re2 != 0) re2 = N - re2 + 1;
			System.out.println("Scenario " + tc);
			String ans = "OK";
			for(int i = 1; i <= D; i++)
			{
				int a = sc.nextInt();
				int b = (N - sc.nextInt()) + 1;
				ans = "OK";
				if(re != 0 && a >= re) a += 1;
				if(b <= re2) b += 1;
				if(a == b) ans = "ALERT";
				System.out.println("Day " + i + " " + ans);
			}
			++tc;
		}
	}
}