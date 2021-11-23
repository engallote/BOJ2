import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	
    	while(--N >= 0) {
    		int num = sc.nextInt();
    		ArrayList<Integer> aly = new ArrayList<>();
    		for(int j = 1; j * j < num; j++) {
    			if(num % j == 0) {
    				if(j * j == num) aly.add(j);
    				else {
    					aly.add(j);
    					aly.add(num / j);
    				}
    			}
    		}
    		
    		Collections.sort(aly);
    		
    		boolean flag = false;
    		loop:for(int i = 0; i < aly.size(); i++) 
    			for(int j = 0; j < aly.size(); j++) {
    				if(i == j) continue;
    				for(int k = 0; k < aly.size(); k++) {
    					if(j == k) continue;
    					for(int l = 0; l < aly.size(); l++) {
    						if(k == l) continue;
    						int a = aly.get(i), b = aly.get(j), c = aly.get(k), d = aly.get(l);
    						if(a * b == c * d && b - a == c + d) {
    							flag = true;
    							break loop;
    						}
    					}
    				}
    			}
    		
    		System.out.println(flag ? num + " is nasty" : num + " is not nasty");
    	}
	}
}