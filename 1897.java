import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	char[] ch = sc.next().toCharArray();
    	boolean[] chk = new boolean[N];
    	String[] str = new String[N];
    	int idx = 0;
    	
    	for(int i = 0; i < N; i++) {
    		str[i] = sc.next();
    		if(new String(ch).equals(str[i])) {
    			idx = i;
    			chk[i] = true;
    		}
    	}
    	
    	Queue<Integer> q = new LinkedList<>();
    	q.offer(idx);
    	
    	int max = str[idx].length();
    	String res = str[idx];
    	
    	while(!q.isEmpty()) {
    		int size = q.size();
    		while(--size >= 0) {
    			int x = q.poll();
    			
    			if(str[x].length() > max) {
    				max = str[x].length();
    				res = str[x];
    			}
    			
    			for(int i = 0; i < N; i++) {
    				if(chk[i] || str[i].length() - str[x].length() != 1) continue;
    				ch = str[i].toCharArray();
    				idx = 0;
    				for(int j = 0; j < ch.length; j++) {
    					if(ch[j] == str[x].charAt(idx)) idx += 1;
    					if(idx == str[x].length()) break;
    				}
    				
					if(idx == str[x].length()) {
						chk[i] = true;
    					q.offer(i);
    				}
    			}
    		}
    	}
    	
    	System.out.println(res);
	}
}