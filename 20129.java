import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		PriorityQueue<Pair> pq = new PriorityQueue<>();
		for(int i = 0; i < 4; i++) {
			int num = sc.nextInt();
			pq.offer(new Pair(i, num));
		}
		
		Stack<Long> number = new Stack<Long>();
		Stack<Character> op = new Stack<>();
		char[] ch = sc.next().toCharArray();
		long num = 0;
		for(char c : ch) {
			if(c >= '0' && c <= '9') {
				num *= 10;
				num += c - '0';
			}
			else {
				number.add(num);
				op.add(c);
				num = 0;
			}
		}
		number.add(num);
		Deque<Long> tn = new LinkedList<>();
		Deque<Character> to = new LinkedList<>();
		while(!op.isEmpty()) {
			int idx = pq.poll().idx;
			char curOp = '.';
			if(idx == 0) curOp = '+';
			else if(idx == 1) curOp = '-';
			else if(idx == 2) curOp = '*';
			else curOp = '/';
			
			while(!op.isEmpty()) {
				if(curOp == op.peek()) {
					long fir = number.pop(), sec = number.pop();
					long tmp = 0;
					
					if(curOp == '+') tmp = fir + sec;
					else if(curOp == '-') tmp = fir - sec;
					else if(curOp == '*') tmp = fir * sec;
					else tmp = fir / sec;
					
					op.pop();
					number.push(tmp);
				}
				else {
					to.offer(op.pop());
					tn.offer(number.pop());
				}
			}
			while(!to.isEmpty()) op.push(to.pollLast());
			while(!tn.isEmpty()) number.push(tn.pollLast());
		}
		System.out.println(number.pop());
	}
}
class Pair implements Comparable<Pair>{
	int idx, num;
	Pair(int idx, int num) {
		this.idx = idx;
		this.num = num;
	}
	@Override
	public int compareTo(Pair o) {
		return Integer.compare(o.num, this.num);
	}
}