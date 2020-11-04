import java.util.*;

public class Main {
	static int N, M, T;
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		N = sc.nextInt();//�ִ� �ο�
		T = sc.nextInt();//�̵� �ð�
		M = sc.nextInt();//�մ� ��
		int[] res = new int[M];
		Queue<Pair> r = new LinkedList<>(), l = new LinkedList<>();
		for(int i = 0; i < M; i++) {
			int num = sc.nextInt();
			String where = sc.next();
			
			if(where.equals("left")) l.offer(new Pair(i, num));
			else r.offer(new Pair(i, num));
		}
		
		int cur = 0, cap = 0, time = 0;
		boolean flag = false;
		while(!r.isEmpty() || !l.isEmpty()) {
			flag = false;
			cap = 0;
			if(!l.isEmpty() && l.peek().w <= time) {
				flag = true;
				if(cur == 0) {//���� ����
					cur = 1;
					while(!l.isEmpty() && l.peek().w <= time && cap < N) {
						res[l.poll().idx] = time + T;
						++cap;
					}
					time += T;
				}
				else {//���� ������
					time += T;
					while(!l.isEmpty() && l.peek().w <= time && cap < N) {
						res[l.poll().idx] = time + T;
						++cap;
					}
					time += T;
				}
			}
			cap = 0;
			if(!r.isEmpty() && r.peek().w <= time) {
				flag = true;
				if(cur == 1) {//���� ������
					cur = 0;
					while(!r.isEmpty() && r.peek().w <= time && cap < N) {
						res[r.poll().idx] = time + T;
						++cap;
					}
					time += T;
				}
				else {//���� ����
					time += T;
					while(!r.isEmpty() && r.peek().w <= time && cap < N) {
						res[r.poll().idx] = time + T;
						++cap;
					}
					time += T;
				}
			}
			if(!flag) ++time;
		}
		
		for(int i = 0; i < M; i++)
			System.out.println(res[i]);
	}
}
class Pair {
	int idx, w;
	Pair(int idx, int w){
		this.idx = idx;
		this.w = w;
	}
}