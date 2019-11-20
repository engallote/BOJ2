import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String[] str = new String[30];
		str[0] = "{}";
		str[1] = "{{}}";
		str[2] = "{{},{{}}}";
		HashMap<String, Integer> hs = new HashMap<>();
		hs.put(str[0], 0);
		hs.put(str[1], 1);
		hs.put(str[2], 2);
		StringBuilder sb = new StringBuilder();
		for(int i = 3; i <= 15; i++)
		{
			sb = new StringBuilder();
			sb.append("{");
			for(int j = 0; j < i; j++)
			{
				if(j != i - 1)sb.append(str[j]+",");
				else sb.append(str[j]);
			}
			sb.append("}");
			str[i] = sb.toString();
			hs.put(str[i], i);
		}
		
		int N = sc.nextInt();
		
		for(int i = 0; i < N; i++)
		{
			String a = sc.next();
			String b = sc.next();
			
			int sum = hs.get(a) + hs.get(b);
			System.out.println(str[sum]);
		}
	}
}