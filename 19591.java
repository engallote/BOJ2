import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		String str = sc.next();
		Deque<Long> arr = new LinkedList<Long>();
		Deque<Character> op = new LinkedList<Character>();
		
		long num = 0;
		boolean sw = false, number = false;
		for(char ch : str.toCharArray()){
			if(ch >= '0' && ch <= '9'){
				num *= 10;
				num += ch - '0';
				number = true;
			}
			else{
				if(!number){
					sw = true;
					continue;
				}
				
				if(sw){
					sw = false;
					num *= -1;
				}
				arr.offer(num);
				op.offer(ch);
				num = 0;
				number = false;
			}
		}
		if(sw) num *= -1;
		arr.offer(num);
		
		while(!op.isEmpty()){
			long max1 = 0, max2 = 0;
			int first = 100, second = 100;
			
			//처음
			long num1 = arr.pollFirst(), num2 = arr.pollFirst();
			if(op.peekFirst() == '*' || op.peekFirst() == '/'){
				first = 0;
				if(op.peekFirst() == '*') max1 = num1 * num2;
				else max1 = num1 / num2;
			}
			else{
				if(op.peekFirst() == '+') max1 = num1 + num2;
				else max1 = num1 - num2;
			}
			arr.offerFirst(num2);
			arr.offerFirst(num1);
			
			//마지막
			num1 = arr.pollLast();
			num2 = arr.pollLast();
			if(op.peekLast() == '*' || op.peekLast() == '/'){
				second = 0;
				if(op.peekLast() == '*') max2 = num1 * num2;
				else max2 = num2 / num1;
			}
			else{
				if(op.peekLast() == '+') max2 = num1 + num2;
				else max2 = num2 - num1;
			}
			arr.offerLast(num2);
			arr.offerLast(num1);
			
			//연산
			if(first == second){//같은 우선순위
				if(max1 >= max2){
					num1 = arr.pollFirst();
					num2 = arr.pollFirst();
					arr.offerFirst(max1);
					op.pollFirst();
				}
				else{
					num1 = arr.pollLast();
					num2 = arr.pollLast();
					arr.offerLast(max2);
					op.pollLast();
				}
			}
			else if(first > second){
				num1 = arr.pollLast();
				num2 = arr.pollLast();
				arr.offerLast(max2);
				op.pollLast();
			}
			else{
				num1 = arr.pollFirst();
				num2 = arr.pollFirst();
				arr.offerFirst(max1);
				op.pollFirst();
			}
		}
		
		System.out.println(arr.poll());
	}
}