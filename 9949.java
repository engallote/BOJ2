import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int tc = 1;
		while(true)
		{
			char a = sc.next().toLowerCase().charAt(0);
			char b = sc.next().toLowerCase().charAt(0);
			
			if(a == '#' && b == '#') break;
			
			System.out.println("Case " + tc);
			
			int N = sc.nextInt();
			sc.nextLine();
			
			while(--N >= 0)
			{
				char[] ch = sc.nextLine().toCharArray();
				for(char c : ch)
				{
					if(c == a || c == b || (c - 'A') == (a - 'a') || (c - 'A') == (b - 'a')) 
						System.out.print("_");
					else System.out.print(c);
				}
				System.out.println();
			}
			
			++tc;
			System.out.println();
		}
	}
}