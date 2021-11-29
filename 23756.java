import java.util.*;

public class Main {
    public static void main(String[] args) {
    	Scanner sc = new Scanner(System.in);
    	int N = sc.nextInt();
    	int cur = sc.nextInt();
    	int res = 0;
    	
    	for(int i = 0; i < N; i++) {
    		int num = sc.nextInt();
    		
    		int cal1 = 0;
    		if(cur > num) cal1 = cur - num;
    		else cal1 = num - cur;
    		
    		int cal2 = 0;
    		if(cur > num) cal2 = num + (360 - cur);
    		else cal2 = 360 - num + cur;
    		
    		res += Math.min(cal1, cal2);
    		cur = num;
    	}
    	
    	System.out.println(res);
    }
}