import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int l, r;
    	boolean flag = false;
    	ArrayList<Long> arr = new ArrayList<>();
    	
    	for(long i = 1; ; i++) {
    		char[] ch = Long.toString(i).toCharArray();
    		l = 0;
    		r = ch.length - 1;
    		flag = true;
    		while(l < r) {
    			if(ch[l] != ch[r]) {
    				flag = false;
    				break;
    			}
    			++l;
    			--r;
    		}
    		
    		if(!flag) continue;
    		long num = i * i;
    		if(num > 100000000000000l) break;
    		
    		ch = Long.toString(num).toCharArray();
    		l = 0;
    		r = ch.length - 1;
    		flag = true;
    		while(l < r) {
    			if(ch[l] != ch[r]) {
    				flag = false;
    				break;
    			}
    			++l;
    			--r;
    		}
    		
    		if(flag) arr.add(i * i);
    	}
    	
    	
    	
    	int T = sc.nextInt();
    	for(int i = 1; i <= T; i++) {
    		long a = sc.nextLong();
    		long b = sc.nextLong();
    		long res = 0;
    		
    		for(int j = 0; j < arr.size(); j++)
    			if(a <= arr.get(j) && arr.get(j) <= b)
    				++res;
    		
    		System.out.println("Case #" + i + ": " + res);
    	}
	}
}