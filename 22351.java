import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	String num = new String(ch);
    	
    	for(int i = 1; i <= 3; i++) {
    		int pre = Integer.parseInt(num.substring(0, i)), s = pre, cur = -1;
    		boolean flag = true;
    		
    		for(int j = i; j < ch.length; j++) {
    			if(cur == -1) {
    				cur = ch[j] - '0';
    				if(cur == 0) {
    					flag = false;
    					break;
    				}
    			}
    			else {
    				cur *= 10;
    				cur += ch[j] - '0';
    			}
    			
    			if(cur < pre) continue;
    			if(cur - pre != 1) {
    				flag = false;
    				break;
    			}
    			else {
    				pre = cur;
    				cur = -1;
    			}
    		}
    		
    		if(cur != -1) continue;
    		flag = true;
    		if(flag) {
    			System.out.println(s + " " + pre);
    			return;
    		}
    	}
    	
    	System.out.println(num + " " + num);
	}
}