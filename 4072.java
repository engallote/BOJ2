import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("#")) break;
			
			String[] st = str.split(" ");
			StringBuilder sb = new StringBuilder();
			for(int i = 0; i < st.length; i++)
			{
				sb = new StringBuilder();
				sb.append(st[i]);
				sb.reverse();
				System.out.print(sb.toString() + " ");
			}
			System.out.println();
		}
	}
}