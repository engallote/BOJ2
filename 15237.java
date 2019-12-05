import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int C = sc.nextInt();
		HashMap<Integer, Integer> hs = new HashMap<>();
		int[] arr = new int[N];
		for(int i = 0; i < N; i++)
		{
			int num = sc.nextInt();
			arr[i] = num;
			if(hs.containsKey(num)) hs.replace(num, hs.get(num) + 1);
			else hs.put(num, 1);
		}
		
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++)
			if(hs.containsKey(arr[i]))
			{
				pq.offer(new Pair(i, arr[i], hs.get(arr[i])));
				hs.remove(arr[i]);
			}
		
		while(!pq.isEmpty())
		{
			Pair p = pq.poll();
			
			while(--p.cnt >= 0) System.out.print(p.num + " ");
		}
	}
}
class Pair implements Comparable<Pair>{
	int idx, num, cnt;
	Pair(int idx, int num, int cnt)
	{
		this.idx = idx;
		this.num = num;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return 1;
		else if(o.cnt == this.cnt) return o.idx > this.idx ? -1 : 1;
		else return -1;
	}
}