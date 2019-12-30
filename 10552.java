import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int C = sc.nextInt();
		int[] arr = new int[N];
		int[] good = new int[N];
		ArrayList<Integer>[] hate = new ArrayList[M+1];
		
		for(int i = 1; i <= M; i++) 
			hate[i] = new ArrayList<>();
		
		for(int i = 0; i < N; i++)
		{
			good[i] = sc.nextInt();
			hate[sc.nextInt()].add(i);
		}
		
		int res = 0;
		while(true)
		{
			if(hate[C].isEmpty()) break;
			int v = hate[C].get(0);
			if(arr[v] > 1)
			{
				res = -1;
				break;
			}
			arr[v] += 1;
			C = good[v];
			++res;
		}
		
		System.out.println(res);
	}
}