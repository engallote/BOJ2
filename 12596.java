import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			HashSet<Integer> hs = new HashSet<>();
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				if(hs.contains(num)) hs.remove(num);
				else hs.add(num);
			}
			
			System.out.println("Case #" + test_case + ": " + hs.iterator().next());
		}
	}
}