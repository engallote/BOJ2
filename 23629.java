import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	char[] ch = sc.next().toCharArray();
    	String[] numStr = {"ZERO", "ONE", "TWO", "THREE", "FOUR", "FIVE", "SIX", "SEVEN", "EIGHT", "NINE"};
    	HashMap<String, Integer> hm = new HashMap<>();
    	hm.put("ZERO", 0);
    	hm.put("ONE", 1);
    	hm.put("TWO", 2);
    	hm.put("THREE", 3);
    	hm.put("FOUR", 4);
    	hm.put("FIVE", 5);
    	hm.put("SIX", 6);
    	hm.put("SEVEN", 7);
    	hm.put("EIGHT", 8);
    	hm.put("NINE", 9);
    	
    	StringBuilder sb = new StringBuilder(), res = new StringBuilder();
    	for(int i = 0; i < ch.length; i++) {
    		if('A' <= ch[i] && ch[i] <= 'Z') {
    			sb.append(ch[i]);
        		
        		if(hm.containsKey(sb.toString())) {
        			res.append(hm.get(sb.toString()));
        			sb = new StringBuilder();
        		}
    		}
    		else {
    			if(i == 0 || sb.length() > 0) {
    				System.out.println("Madness!");
    				return;
    			}
    			res.append(ch[i]);
    		}
    	}
    	
    	if(res.charAt(res.length() - 1) != '=') {
    		System.out.println("Madness!");
    		return;
    	}
    	
    	long sum = 0l, num = 0l;
    	char op = '+';
    	char[] tmp = res.toString().toCharArray();
    	for(int i = 0; i < tmp.length; i++) {
    		if('0' <= tmp[i] && tmp[i] <= '9') {
    			num *= 10l;
    			num += (long)(tmp[i] - '0');
    		}
    		else if(tmp[i] == '+' || tmp[i] == '-' || tmp[i] == 'x' || tmp[i] == '/' || tmp[i] == '=') {
    			if(i - 1 >= 0 && !('0' <= tmp[i - 1] && tmp[i - 1] <= '9')) {
    				System.out.println("Madness!");
					return;
    			}
    			
    			if(op == '+') sum += num;
    			else if(op == '-') sum -= num;
    			else if(op == 'x') sum *= num;
    			else if(op == '/') {
    				if(num == 0) {
    					System.out.println("Madness!");
    					return;
    				}
    				sum /= num;
    			}
    			else {
    				System.out.println("Madness!");
					return;
    			}
//    			System.out.println(sum + " " + op + " " + num);
    			num = 0;
    			op = tmp[i];
    		}
    		else {
    			System.out.println("Madness!");
				return;
    		}
    	}
    	
    	System.out.println(res.toString());
    	tmp = Long.toString(sum).toCharArray();
    	for(int i = 0; i < tmp.length; i++) {
    		if('0' <= tmp[i] && tmp[i] <= '9') System.out.print(numStr[tmp[i] - '0']);
    		else System.out.print(tmp[i]);
    	}
    	
    }
}