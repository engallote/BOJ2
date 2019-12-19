import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		boolean left = true, B = false;
		char[] ch = sc.next().toCharArray();
		int where = 1;
		for(char c : ch)
		{
			if(c == 'P')
			{
				if(where == 2) B = true;
				if(where == 1) left = !left;
			}
			else ++where;
		}
		
		if(where >= 3) 
		{
			if(B) System.out.println(6);
			else System.out.println(left ? 5 : 1);
		}
		else System.out.println(0);
	}
}