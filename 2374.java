import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        long res = 0;
        Stack<Long> st = new Stack<>();
        
        for(int i = 0; i < N; i++) {
        	long num = sc.nextLong();
        	if(st.isEmpty()) st.push(num);
    		else {
    			while(st.peek() < num) {
    				long tmp = st.pop();
    				
    				if(st.isEmpty() || st.peek() > num) {
    					res += num - tmp;
    					break;
    				}
    				else res += st.peek() - tmp;
    			}
    			st.push(num);
    		}
        }
        
        if(st.size() > 1) 
        	res += st.get(0) - st.peek();
        
        System.out.println(res);
	}
}