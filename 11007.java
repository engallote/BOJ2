import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		while(--T >= 0)
		{
			int N = sc.nextInt();
			ArrayList<Character> arr = new ArrayList<>();
			
			for(char i = 'a'; i <= 'z'; i++)
				arr.add(i);
			
			StringBuilder sb = new StringBuilder();
			
			for(int i = 0; i < N; i++)
			{
				int num = sc.nextInt();
				sb.append(arr.get(num));
				char p = arr.get(num);
				arr.remove(num);
				arr.add(0, p);
			}
			
			System.out.println(sb.toString());
		}
	}
}