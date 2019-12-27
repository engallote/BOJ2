import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int N = sc.nextInt();
			if(N == 0) break;

			PriorityQueue<Pair> pq = new PriorityQueue<>();
			String[] arr = new String[N];
			int mid = N / 2;

			while(--N >= 0)
			{
				String str = sc.next();
				int num = sc.nextInt();
				pq.offer(new Pair(str, num));
			}

			arr[mid] = pq.poll().name;

			int l = mid - 1, r = mid + 1;
			boolean where = true;

			while(!pq.isEmpty())
			{
				if(where){
					arr[l] = pq.poll().name;
					--l;
				}
				else{
					arr[r] = pq.poll().name;
					++r;
				}
				where = !where;
			}
			
			for(int i = 0; i < arr.length; i++)
				System.out.print(arr[i] + " ");
			System.out.println();
		}
	}
}
class Pair implements Comparable<Pair>{
	int num;
	String name;
	Pair(String name, int num)
	{
		this.name = name;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		if(o.num > this.num) return 1;
		else if(o.num == this.num){
			char[] a = o.name.toLowerCase().toCharArray(), b = this.name.toLowerCase().toCharArray();
			for(int i = 0; i < 3; i++)
			{
				if(a[i] > b[i]) return -1;
				else if(a[i] < b[i]) return 1;
			}
			return 0;
		}
		else return -1;
	}
}