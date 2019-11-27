import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		for(int test_case = 1;; test_case++)
		{
			int N = sc.nextInt();
			if(N == 0) break;
			int res = 0, len = 1;
			
			for(int i = 0; i < N; i++)
			{
				for(int j = 0; j < len; j++)
				{
					int num = sc.nextInt();
					if(i < N - 1 && (j == 0 || j == len - 1)) res += num;
					else if(i == N - 1) res += num;
				}
				++len;
			}
			
			System.out.println("Case #" + test_case + ":" + res);
		}
	}
}