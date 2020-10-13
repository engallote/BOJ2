import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		int[] arr = new int[N + 1];
		Stack<Integer> st = new Stack<>();
		int res = 1;
		
		for(int i = 1; i <= N; i++)
			arr[i] = sc.nextInt();
		
		st.push(0);
		
		for(int i = 1; i <= N; i++) {
			while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
				int h = arr[st.pop()];
				int w = i - st.peek() - 1;
				res = Math.max(res, Math.min(h, w));
			}
			st.push(i);
		}
		
		System.out.println(res);
	}
}