import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	while(sc.hasNext()) {
    		int[] arr = new int[32];
        	int pc = 0, ac = 0;
        	
    		for(int i = 0; i < 32; i++) {
    			char[] ch = sc.next().toCharArray();
        		
        		for(int j = 7; j >= 0; j--)
        			if(ch[j] == '1') arr[i] |= (1<<7-j);
        	}
    		
    		while(true) {
        		int cur = arr[pc];
        		int order = cur / 32, val = cur % 32;
        		pc = (pc + 1) & 31;
        		
        		if(order == 0) arr[val] = ac;
        		else if(order == 1) ac = arr[val];
        		else if(order == 2) {
        			if(ac == 0) pc = val;
        		}
        		else if(order == 4) ac = (ac - 1) & 255;
        		else if(order == 5) ac = (ac + 1) & 255;
        		else if(order == 6) pc = val;
        		else if(order == 7) break;
        		
        	}
        	
        	for(int i = 7; i >= 0; i--)
        		System.out.print((ac>>i)&1);
        	System.out.println();
    	}
	}
}