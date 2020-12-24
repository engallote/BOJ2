import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int T = sc.nextInt();
		
		for(int test_case = 1; test_case <= T; test_case++) {
			int R = sc.nextInt();//���� Ƚ��
			int K = sc.nextInt();//���� �ο���
			int N = sc.nextInt();//��� �ο���
			int res = 0;
			Queue<Integer> q = new LinkedList<>();
			
			for(int i = 0; i < N; i++)
				q.offer(sc.nextInt());
			
			int r = 1, seat = 0, size = 0;
			while(r <= R) {
				size = N;
				seat = 0;
				while(--size >= 0) {
					int num = q.peek();
					if(seat + num <= K) {
						seat += num;
						q.poll();
						q.offer(num);
					}
					else break;
				}
				++r;
				res += seat;
			}
			
			System.out.println("Case #" + test_case + ": " + res);
		}
	}
}