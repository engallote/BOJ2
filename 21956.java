import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int K = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	Deque<Character> dq = new LinkedList<>();
    	StringBuilder sb = new StringBuilder();
    	boolean flag = true;
    	
    	while(flag) {
    		flag = false;
    		char pre = '.';
    		int cnt = 0;
    		for(int i = 0; i < ch.length; i++) {
    			dq.offer(ch[i]);
    			
    			if(pre == ch[i]) ++cnt;
    			else cnt = 1;
    			
    			if(cnt == K) {
    				flag = true;
    				while(--cnt >= 0) dq.pollLast();
    				pre = '.';
    			}
    			else pre = ch[i];
    		}
    		
    		sb = new StringBuilder();
    		while(!dq.isEmpty())
    			sb.append(dq.poll());
    		
    		ch = sb.toString().toCharArray();
    	}
    	
    	System.out.println(new String(ch));
	}
}