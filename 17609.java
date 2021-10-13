import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);    	
    	int N = sc.nextInt();
    	
    	for(int i = 0; i < N; i++) {
    		char[] ch = sc.next().toCharArray();
    		
    		int l = 0, r = ch.length - 1, k = 1;
    		boolean flag = true;
    		
    		while(l <= r) {
    			if(ch[l] == ch[r]) {
    				l += 1;
    				r -= 1;
    			}
    			else {
    				if(k == 0) {
    					flag = false;
    					break;
    				}
    				
    				boolean a = false, b = false;
    				if(l + 1 <= r && ch[l + 1] == ch[r]) a = find(l + 1, r, ch);
    				if(r - 1 >= l && ch[l] == ch[r - 1]) b = find(l, r - 1, ch);
    				k -= 1;
    				
    				if(a || b) flag = true;
    				else if(!a && !b) flag = false;
    				break;
    			}
    		}
    		
    		if(flag) {
    			if(k == 1) System.out.println(0);
    			else System.out.println(1);
    		}
    		else System.out.println(2);
    	}
	}

	private static boolean find(int l, int r, char[] ch) {
		while(l <= r) {
			if(ch[l] == ch[r]) {
				l += 1;
				r -= 1;
			}
			else return false;
		}
		return true;
	}
}