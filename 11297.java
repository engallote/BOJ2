import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int m = sc.nextInt();
			int d = sc.nextInt();
			int y = sc.nextInt();
			if(m == 0 && d == 0 && y == 0) break;
			int sum = (m + d + y) % 25 + 1;
			sc.nextLine();
			char[] ch = sc.nextLine().toCharArray();
			
			for(char c : ch)
			{
				if(c >= 'a' && c <= 'z')
				{
					int num = ((c - 'a') - sum);
					if(num < 0) num = 26 + num;
					char tmp = (char)(num % 26 + 'a');
					System.out.print(tmp);
				}
				else System.out.print(c);
			}
			System.out.println();
		}
	}
}