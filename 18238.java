import java.util.*;

public class Main {
	public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        char[] ch = sc.next().toCharArray();
        
        int cur = 0, res = 0;
        for(int i = 0; i < ch.length; i++) {
        	int next = ch[i] - 'A';
        	
        	if(cur < next) {
        		if(Math.abs(next - cur) > 26 - next + cur) res += 26 - next + cur;
        		else res += Math.abs(next - cur);
        	}
        	else if(cur > next) {
        		if(Math.abs(cur - next) > (26 - cur) + next) res += (26 - cur) + next;
            	else res += Math.abs(next - cur);
        	}
        	
        	cur = next;
        }
        
        System.out.println(res);
    }
}