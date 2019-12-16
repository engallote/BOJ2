import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		while(true)
		{
			int num = sc.nextInt();
			if(num == -1) break;
			int sum = 0;
			Queue<Integer> q = new LinkedList<Integer>();
			
			for(int i = 1; i < num; i++)
				if(num % i == 0)
				{
					q.offer(i);
					sum += i;
				}
			
			if(sum == num)
			{
				System.out.print(num + " = ");
				while(!q.isEmpty())
				{
					if(q.size() == 1) System.out.println(q.poll());
					else System.out.print(q.poll() + " + ");
				}
			}
			else System.out.println(num + " is NOT perfect.");
		}
	}
}