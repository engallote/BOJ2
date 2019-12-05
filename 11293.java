import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++)
		{
			int N = sc.nextInt();
			sc.nextLine();
			char[][] answer = new char[N][];
			for(int i = 0; i < N; i++)
			{
				String str = sc.nextLine();
				str = str.replaceAll(" ", "");
				answer[i] = str.toCharArray();
			}
			int L = sc.nextInt();
			System.out.println("Customer " + test_case);
			for(int i = 0; i < L; i++)
			{
				int q = sc.nextInt() - 1;
				int a = sc.nextInt() - 1;
				int b = sc.nextInt() - 1;
				char A = sc.next().charAt(0);
				char B = sc.next().charAt(0);
				
				if(answer[q][a] == A && answer[q][b] == B) System.out.println("correct");
				else System.out.println("error");
			}
		}
	}
}