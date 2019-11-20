import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int A = sc.nextInt();
		int B = sc.nextInt();
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		
		for(int i = -1000; i <= 1000; i++)
		{
			if((i * i) + (A * 2 * i) == -B) pq.offer(i);
		}
		
		while(!pq.isEmpty())
			System.out.print(pq.poll() + " ");
	}
}