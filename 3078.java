import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		Queue<Integer>[] q = new LinkedList[21];
		
		for(int i = 1; i <= 20; i++)
			q[i] = new LinkedList<>();
		
		long res = 0;
		for(int i = 0; i < N; i++) {
			String name = sc.next();
			int len = name.length();
			
			while(!q[len].isEmpty() && i - q[len].peek() > K)
				q[len].poll();
			
			res += q[len].size();
			q[len].offer(i);
		}
		
		System.out.println(res);
	}
}