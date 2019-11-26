import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		HashSet<Integer> hs = new HashSet<>();
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			
			if(N == 0)
			{
				System.out.println("Case #" + test_case + ": INSOMNIA");
				continue;
			}
			hs.clear();
			int res = 0;
			for(int i = 1; i <= 1000; i++)
			{
				int num = i * N;
				while(num > 0)
				{
					hs.add(num % 10);
					num /= 10;
				}
				
				if(hs.size() == 10) 
				{
					res = i * N;
					break;
				}
			}
			
			System.out.println("Case #" + test_case + ": " + res);
		}
	}
}