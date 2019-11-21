import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int[26];
		while(true)
		{
			String str = sc.nextLine();
			if(str.equals("END")) break;
			Arrays.fill(arr, 0);
			String res = str;
			boolean a = true;
			char[] ch = str.toCharArray();
			for(char c : ch)
			{
				if(c == ' ') continue;
				arr[c-'A'] += 1;
				if(arr[c-'A'] > 1)
				{
					a = false;
					break;
				}
			}
			if(a) System.out.println(res);
		}
	}
}