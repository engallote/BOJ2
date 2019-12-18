import java.util.*;

public class Main {
	static int N, M;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();
		M = sc.nextInt();
		int[] indgree = new int[N + 1];
		ArrayList<Integer>[] arr = new ArrayList[N + 1];
		Arrays.fill(indgree, 1);
		for(int i = 1; i <= N; i++) arr[i] = new ArrayList<>();
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			arr[a].add(b);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		for(int i = 1; i <= N; i++)
		{
			for(int next : arr[i])
				indgree[next] = Math.max(indgree[next], indgree[i] + 1);
		}
		
		for(int i = 1; i <= N; i++)
			System.out.print(indgree[i] + " ");
	}
}