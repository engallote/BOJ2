import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		
		while(--N >= 0)
		{
			char[] ch = sc.next().toCharArray();
			boolean flag = true;
			if(ch[0] == ch[1] && ch[0] >= '1' && ch[0] <= '9' && ch[4] >= 'A' && ch[4] <= 'Z')
			{
				for(int j = 2; j < ch.length; j++)
				{
					if(j == 4) continue;
					if(ch[j] >= '1' && ch[j] <= '9') continue;
					else flag = false;
				}
			}
			else flag = false;
			
			if(flag) System.out.println(new String(ch));
		}
	}
}