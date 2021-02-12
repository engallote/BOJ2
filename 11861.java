import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        int[] arr = new int[N + 2];
        
        for(int i = 1; i <= N; i++)
        	arr[i] = sc.nextInt();
        
        Stack<Integer> st = new Stack<>();
        st.push(0);
        int res = 0;
        
        for(int i = 1; i <= N + 1; i++) {
        	while(!st.isEmpty() && arr[st.peek()] > arr[i]) {
        		int h = arr[st.pop()];
        		
        		res = Math.max(res, (i - st.peek() - 1) * h);
        	}
        	
        	st.push(i);
        }
        
        System.out.println(res);
	}
}