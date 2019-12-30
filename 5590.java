import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int K = sc.nextInt();
		int cost, size;
		ArrayList<Pair>[] arr = new ArrayList[N+1];
		Queue<Pair> q = new LinkedList<Pair>();
		int[] chk = new int[N + 1];
		for(int i = 1; i <= N; i++)
			arr[i] = new ArrayList<>();
		
		for(int i = 0; i < K; i++)
		{
			int num = sc.nextInt();
			if(num == 0)
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				Arrays.fill(chk, Integer.MAX_VALUE);
				cost = Integer.MAX_VALUE;
				chk[a] = 0;
				q.offer(new Pair(a, 0));
				while(!q.isEmpty())
				{
					size = q.size();
					while(--size >= 0)
					{
						Pair p = q.poll();
						if(p.v == b)
						{
							cost = Math.min(cost, p.d);
							continue;
						}
						for(Pair next : arr[p.v])
							if(chk[next.v] > p.d + next.d)
							{
								chk[next.v] = p.d + next.d;
								q.offer(new Pair(next.v, p.d + next.d));
							}
					}
				}
				q.clear();
				if(cost == Integer.MAX_VALUE) cost = -1;
				System.out.println(cost);
			}
			else
			{
				int a = sc.nextInt();
				int b = sc.nextInt();
				int d = sc.nextInt();
				arr[a].add(new Pair(b, d));
				arr[b].add(new Pair(a, d));
			}
		}
	}
}
class Pair{
	int v, d;
	Pair(int v, int d)
	{
		this.v = v;
		this.d = d;
	}
}