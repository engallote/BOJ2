import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int P = sc.nextInt();
		int W = sc.nextInt();//�̰��� ��
		int L = sc.nextInt();//���� ��
		int G = sc.nextInt();//����� ���� ����
		HashSet<String> win = new HashSet<>();
		
		for(int i = 0; i < P; i++) {
			String name = sc.next();
			char c = sc.next().charAt(0);
			
			if(c == 'W') win.add(name);
		}
		
		int cost = 0;
		boolean flag = false;
		for(int i = 0; i < N; i++) {
			String name = sc.next();
			
			if(win.contains(name)) cost += 20;
			else cost -= 15;
			if(cost < 0) cost = 0;
			
			if(cost >= G) flag = true;
		}
		
		if(flag) System.out.println("I AM NOT IRONMAN!!");
		else System.out.println("I AM IRONMAN!!");
	}
}