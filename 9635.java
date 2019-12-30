import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0)
		{
			int N = sc.nextInt();
			int X = sc.nextInt();
			int Y = sc.nextInt();
			int x = 0, y = 0;
			
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				if(i == 0) x = num;
				else if(i == N - 1) y = num;
			}
			
			if(x == X && y == Y) System.out.println("BOTH");
			else if(x == X && y != Y) System.out.println("EASY");
			else if(x != X && y == Y) System.out.println("HARD");
			else System.out.println("OKAY");
		}
	}
}