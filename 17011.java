import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		while(--T >= 0)
		{
			char[] ch = sc.next().toCharArray();
			
			char pre = ch[0];
			int cnt = 0;
			for(int i = 0; i < ch.length; i++)
			{
				if(pre == ch[i]) ++cnt;
				else
				{
					System.out.print(cnt + " " + pre + " ");
					cnt = 1;
					pre = ch[i];
				}
			}
			System.out.println(cnt + " " + pre);
		}
	}
}