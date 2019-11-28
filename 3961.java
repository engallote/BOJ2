import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		Pair[] arr = new Pair['z'+1];
		arr['q'] = new Pair(0, 0);
		arr['w'] = new Pair(0, 1);
		arr['e'] = new Pair(0, 2);
		arr['r'] = new Pair(0, 3);
		arr['t'] = new Pair(0, 4);
		arr['y'] = new Pair(0, 5);
		arr['u'] = new Pair(0, 6);
		arr['i'] = new Pair(0, 7);
		arr['o'] = new Pair(0, 8);
		arr['p'] = new Pair(0, 9);
		
		arr['a'] = new Pair(1, 0);
		arr['s'] = new Pair(1, 1);
		arr['d'] = new Pair(1, 2);
		arr['f'] = new Pair(1, 3);
		arr['g'] = new Pair(1, 4);
		arr['h'] = new Pair(1, 5);
		arr['j'] = new Pair(1, 6);
		arr['k'] = new Pair(1, 7);
		arr['l'] = new Pair(1, 8);
		
		arr['z'] = new Pair(2, 0);
		arr['x'] = new Pair(2, 1);
		arr['c'] = new Pair(2, 2);
		arr['v'] = new Pair(2, 3);
		arr['b'] = new Pair(2, 4);
		arr['n'] = new Pair(2, 5);
		arr['m'] = new Pair(2, 6);
		
		while(--T >= 0)
		{
			char[] ch = sc.next().toCharArray();
			int N = sc.nextInt();
			int len = ch.length, sum = 0;
			PriorityQueue<Pair> pq = new PriorityQueue<>();
			for(int i = 0; i < N; i++)
			{
				char[] tmp = sc.next().toCharArray();
				sum = 0;
				for(int j = 0; j < len; j++)
					sum += Math.abs(arr[ch[j]].x - arr[tmp[j]].x) + Math.abs(arr[ch[j]].y - arr[tmp[j]].y);
				pq.offer(new Pair(new String(tmp), sum));
			}
			
			while(!pq.isEmpty()) System.out.println(pq.peek().str + " " + pq.poll().cnt);
		}
	}
}
class Pair implements Comparable<Pair>{
	int x, y, cnt;
	String str;
	Pair(int x, int y)
	{
		this.x = x;
		this.y = y;
	}
	Pair(String str, int cnt)
	{
		this.str = str;
		this.cnt = cnt;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.cnt > this.cnt) return -1;
		else if(o.cnt == this.cnt)
		{
			char[] a = o.str.toCharArray(), b = this.str.toCharArray();
			for(int i = 0; i < a.length; i++)
			{
				if(a[i] > b[i]) return -1;
				else if(a[i] < b[i]) return 1;
			}
			return 0;
		}
		else return 1;
	}
}