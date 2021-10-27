import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	while(--N >= 0) {
    		char[] ch = sc.next().toCharArray();
    		if(new String(ch).contains("lol")) {
    			System.out.println(0);
    			continue;
    		}
    		
    		boolean flag = false;
    		for(int i = 0; i < ch.length; i++) {
    			if(ch[i] == 'l') {
    				if(i + 1 < ch.length && (ch[i + 1] == 'l' || ch[i + 1] == 'o')) {//ll lo
    					System.out.println(1);
    					flag = true;
    					break;
    				}
    				if(i + 2 < ch.length && ch[i + 2] == 'l') {// l.l
    					System.out.println(1);
    					flag = true;
    					break;
    				}
    			}
    			else if(ch[i] == 'o') {
    				if(i + 1 < ch.length && ch[i + 1] == 'l') {//ol
    					System.out.println(1);
    					flag = true;
    					break;
    				}
    			}
    		}
    		
    		if(flag) continue;
    		
    		if(new String(ch).contains("l") || new String(ch).contains("o")) System.out.println(2);
    		else System.out.println(3);
    	}
	}
}