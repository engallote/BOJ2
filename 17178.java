import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		Queue<String>[] q = new LinkedList[N];
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		Stack<String> st = new Stack<>();
		for(int i = 0; i < N; i++)
		{
			q[i] = new LinkedList<String>();
			for(int j = 0; j < 5; j++)
			{
				String num = sc.next();
				q[i].offer(num);
				pq.offer(new Pair(num));
			}
		}
		
		for(int i = 0; i < N; i++)
		{
			while(!q[i].isEmpty())
			{
				while(!st.isEmpty() && st.peek().equals(pq.peek().str))
				{
//					System.out.println("stack pop : " + pq.peek().str);
					st.pop();
					pq.poll();
				}
				if(q[i].peek().equals(pq.peek().str))
				{
//					System.out.println("q poll : " + q[i].peek());
					q[i].poll();
					pq.poll();
				}
				else
				{
//					System.out.println(q[i].peek() + " push");
					st.push(q[i].poll());
				}
			}
		}
		
		while(!st.isEmpty())
		{
			if(st.peek().equals(pq.peek().str))
			{
//				System.out.println("stack pop : " + pq.peek().str);
				st.pop();
				pq.poll();
			}
			else break;
		}
		if(st.isEmpty()) System.out.println("GOOD");
		else System.out.println("BAD");
	}
}
class Pair implements Comparable<Pair>{
	String str;
	Pair(String str)
	{
		this.str = str;
	}
	@Override
	public int compareTo(Pair o) {
		String[] a = o.str.split("-"), b = this.str.split("-");
		if(a[0].charAt(0) < b[0].charAt(0)) return 1;
		else if(a[0].charAt(0) == b[0].charAt(0))
		{
			if(Integer.parseInt(a[1]) > Integer.parseInt(b[1])) return -1;
			else if(Integer.parseInt(a[1]) == Integer.parseInt(b[1])) return 0;
			else return 1;
		}
		else return -1;
	}
}