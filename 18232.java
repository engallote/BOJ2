import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int M = sc.nextInt();
		int S = sc.nextInt();
		int E = sc.nextInt();
		ArrayList<Integer>[] tel = new ArrayList[N + 1];
		for(int i = 1; i <= N; i++)
			tel[i] = new ArrayList<>();
		boolean[] chk = new boolean[N + 1];
		
		for(int i = 0; i < M; i++)
		{
			int a = sc.nextInt();
			int b = sc.nextInt();
			tel[a].add(b);
			tel[b].add(a);
		}
		
		Queue<Integer> q = new LinkedList<Integer>();
		q.offer(S);
		chk[S] = true;
		int size = 0, time = 0;
		while(!q.isEmpty())
		{
			size = q.size();
			while(--size >= 0)
			{
				int x = q.poll();
				if(x == E)
				{
					q.clear();
					System.out.println(time);
					return;
				}
				
				if(x + 1 <= N && !chk[x + 1])
				{
					chk[x + 1] = true;
					q.offer(x + 1);
				}
				if(x - 1 >= 1 && !chk[x - 1])
				{
					chk[x - 1] = true;
					q.offer(x - 1);
				}
				for(int next : tel[x])
					if(!chk[next])
					{
						chk[next] = true;
						q.offer(next);
					}
					
			}
			++time;
		}
	}
}