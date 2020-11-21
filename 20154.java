import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int[] arr = new int['Z' + 1];
		arr['A'] = 3;
		arr['B'] = 2;
		arr['C'] = 1;
		arr['D'] = 2;
		arr['E'] = 3;
		arr['F'] = 3;
		arr['G'] = 3;
		arr['H'] = 3;
		arr['I'] = 1;
		arr['J'] = 1;
		arr['K'] = 3;
		arr['L'] = 1;
		arr['M'] = 3;
		arr['N'] = 3;
		arr['O'] = 1;
		arr['P'] = 2;
		arr['Q'] = 2;
		arr['R'] = 2;
		arr['S'] = 1;
		arr['T'] = 2;
		arr['U'] = 1;
		arr['V'] = 1;
		arr['W'] = 2;
		arr['X'] = 2;
		arr['Y'] = 2;
		arr['Z'] = 1;
		
		char[] ch = sc.next().toCharArray();
		Queue<Integer> q = new LinkedList<>(), tmp = new LinkedList<>();
		
		for(char c : ch)
			q.offer(arr[c]);
		
		while(q.size() > 1) {
			while(!q.isEmpty()) {
				if(q.size() == 1) {
					tmp.offer(q.poll());
					break;
				}
				int num1 = q.poll(), num2 = q.poll();
				tmp.offer((num1 + num2) % 10);
			}
			q.addAll(tmp);
			tmp.clear();
		}
		
		System.out.println(q.poll() % 2 != 0 ? "I'm a winner!" : "You're the winner?");
	}
}