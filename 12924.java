import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int A = sc.nextInt();
    	int B = sc.nextInt();
    	HashSet<String> hs = new HashSet<>();
    	int res = 0;
    	for(int i = A; i <= B; i++) {
    		if(i < 10 || (i / 10 < 10 && i % 10 == 0)) continue;
    		String str = Integer.toString(i);
    		
    		for(int j = 1; j <= str.length() - 1; j++) {
    			String num = str.substring(j) + "" + str.substring(0, j);
    			int tmp = Integer.parseInt(num);
    			if(A <= tmp && tmp <= B && i < tmp && !hs.contains(str+","+num)) {
    				hs.add(str+","+num);
    				++res;
    			}
    		}
    	}
    	
    	System.out.println(res);
	}
}