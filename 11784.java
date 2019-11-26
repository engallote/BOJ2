import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(sc.hasNext())
		{
			char[] ch = sc.next().toCharArray();
			int len = ch.length;
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < len; i+=2)
				sb.append((char)Integer.parseInt(ch[i]+""+ch[i+1], 16));
			
			System.out.println(sb.toString());
		}
	}
}