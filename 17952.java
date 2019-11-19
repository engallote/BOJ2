import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Stack<Integer> st = new Stack<>(), score = new Stack<>();
		int res = 0;
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			if(num == 0) 
			{
				if(st.isEmpty()) continue;
				int time = st.pop();
				if(time - 1 == 0) res += score.pop();
				else st.push(time - 1);
			}
			else
			{
				score.push(sc.nextInt());
				st.push(sc.nextInt() - 1);
				if(st.peek() == 0)
				{
					res += score.pop();
					st.pop();
				}
			}
		}
		
		System.out.println(res);
	}
}