import java.util.*;

public class Main {
	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		int N = sc.nextInt();
		char[] ch = sc.next().toCharArray();
		int[] arr = new int[N];
		int res = 0;
		Stack<Integer> st = new Stack<>();
		for(int i = 0; i < N; i++) {
			if(ch[i] == '(') st.push(i);
			else {
				if(!st.isEmpty()) arr[i] = arr[st.pop()] = 1;
			}
		}
		
		int tmp = 0;
		for(int i = 0; i < N; i++) {
			if(arr[i] == 1) ++tmp;
			else {
				res = Math.max(res, tmp);
				tmp = 0;
			}
		}
		res = Math.max(res, tmp);
		
		System.out.println(res);
	}
}