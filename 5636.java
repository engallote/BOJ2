import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	boolean[] chk = new boolean[100001];
    	chk[0] = chk[1] = true;
    	for(int i = 2; i < 100001; i++) {
    		if(chk[i]) continue;
    		for(int j = i + i; j < 100001; j+=i) chk[j] = true;
    	}
    	
    	while(true) {
    		String s = sc.next();
    		if(s.equals("0")) break;
    		
    		char[] ch = s.toCharArray();
    		int num = 0, res = 0;
    		
    		for(int i = 0; i < ch.length; i++) {
    			num = 0;
    			for(int j = i; j < ch.length; j++) {
    				num *= 10;
    				num += ch[j] - '0';
    				if(num > 100000) break;
    				if(!chk[num]) res = Math.max(res, num);
    			}
    		}
    		
    		System.out.println(res);
    	}
	}
}