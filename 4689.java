import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			String num = sc.next();
			int from = sc.nextInt();
			int to = sc.nextInt();
			long N = Long.parseLong(num,from);
			String res = Long.toString(N, to).toUpperCase();
			if(res.length() > 7) System.out.println("  ERROR");
			else 
			{
				for(int i = 0; i < 7 - res.length(); i++)
					System.out.print(" ");
				System.out.println(res);
			}
		}
	}
}