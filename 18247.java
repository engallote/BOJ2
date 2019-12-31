import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0)
		{
			int N = sc.nextInt();
			int M = sc.nextInt();
			
			if(N < ('L' - 'A') + 1 || M < 4) System.out.println(-1);
			else
			{
				int num = ('L' - 'A') * M + 4;
				System.out.println(num);
			}
		}
	}
}