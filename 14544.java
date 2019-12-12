import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			HashMap<String, Integer> hs = new HashMap<>();
			for(int i = 0; i < N; i++)
				hs.put(sc.next(), 0);
			System.out.print("VOTE " + test_case);
			int max = 0;
			String winner = ".";
			int win = 0;
			for(int i = 0; i < M; i++)
			{
				String name = sc.next();
				int num = sc.nextInt();
				String name2 = sc.next();
				
				hs.replace(name, hs.get(name) + num);
				if(max < hs.get(name))
				{
					max = hs.get(name);
					winner = name;
					win = 1;
				}
				else if(max == hs.get(name)) ++win;
			}
			
			if(win == 1) System.out.println(": THE WINNER IS " + winner + " " + max);
			else System.out.println(": THERE IS A DILEMMA");
		}
	}
}