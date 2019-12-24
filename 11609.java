import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < N; i++)
		{
			String name = sc.next();
			String name2 = sc.next();
			pq.offer(new Pair(name, name2));
		}
		
		while(!pq.isEmpty())
			System.out.println(pq.peek().name1 + " " + pq.poll().name2);
	}
}
class Pair implements Comparable<Pair>{
	String name1, name2;
	Pair(String name1, String name2)
	{
		this.name1 = name1;
		this.name2 = name2;
	}
	@Override
	public int compareTo(Pair o) {
		char[] a2 = o.name2.toCharArray(), b2 = this.name2.toCharArray();
		
		int len = Math.min(a2.length, b2.length);
		for(int i = 0; i < len; i++)
		{
			if(a2[i] > b2[i]) return -1;
			else if(a2[i] < b2[i]) return 1;
		}
		if(a2.length == b2.length)
		{
			char[] a1 = o.name1.toCharArray(), b1 = this.name1.toCharArray();
			int len2 = Math.min(a1.length, b1.length);
			for(int i = 0; i < len2; i++)
			{
				if(a1[i] > b1[i]) return -1;
				else if(a1[i] < b1[i]) return 1;
			}
			if(a1.length == b1.length) return 0;
			else if(a1.length > b1.length) return -1;
			else return 1;
		}
		else if(a2.length > b2.length) return -1;
		else return 1;
	}
}